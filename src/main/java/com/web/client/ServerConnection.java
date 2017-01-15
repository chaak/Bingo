package com.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.TimerTask;
import static com.web.client.ClientBingo.randomNumber;

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
                randomNumber.setValue(serverInput.readLine()); //od servera
                ClientBingo.turn = false;

                if(ClientBingo.checkState()){
                    out.println("POST.WINNER");
                    randomNumber.setValue(serverInput.readLine());
                    socket.close();
                    cancel();
                }

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
