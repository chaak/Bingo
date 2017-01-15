package com.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.TimerTask;

/**
 * Created by JakubWitczak on 05.01.2017.
 */
class ServerConnection extends TimerTask {
    private static String IP = "127.0.0.1";
    private static int PORT = 9898;

    @Override
    public void run() {
        try (
                Socket socket = new Socket(IP, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            while(true) {
                out.println("GET.NUMBER");
                ClientBingo.randomNumber.setValue(serverInput.readLine());//broadcasting!!
                ClientBingo.turn = false;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
