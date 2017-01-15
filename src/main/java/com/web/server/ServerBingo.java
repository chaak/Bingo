//package com.web.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Random;
import java.util.TimerTask;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ServerBingo {
    private static int PORT = 9898;

    public static void main(String args[]) throws InterruptedException, IOException {
        System.out.println("Server is launched.");
        int connectionNumber = 1;

        try (ServerSocket socket = new ServerSocket(PORT)) {
            while (true) {
                Connection connection = new Connection(socket.accept(), connectionNumber++);
                connection.start();
            }
        }
    }

    private static class Connection extends Thread {
        private Socket socket;
        static int connectionNumber;

        Connection(Socket socket, int connectionNumber) {
            this.socket = socket;
            Connection.connectionNumber = connectionNumber;
        }

        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String input;
                while ((input = in.readLine()) != null) {
                    if (Objects.equals(input, "GET.NUMBER")) {
                        System.out.println("Client" + connectionNumber);
                        out.println(randomNumber(1, 75));
                    }
                    
                }

            } catch (IOException e) {
                System.out.println("error nr: " + connectionNumber + ": " + e);
            }
        }

        static int randomNumber(int min, int max) {
            Random random = new Random();
            return random.nextInt((max - min) + 1) + min;
        }

    }

}



