package com.web.server;

import java.io.IOException;
import java.net.*;
import java.util.Random;

/**
 * Created by JakubWitczak on 15.01.2017.
 */
public class Connection extends Thread {
    private DatagramSocket serverSocket;
    private static int connectionNumber;
    private static int PORT = 4445;

    public Connection(int connectionNumber) throws IOException {
        serverSocket = new MulticastSocket(PORT);
        Connection.connectionNumber = connectionNumber;
        System.out.println("Server is launched.");
    }

    public void run() {
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            try {

                int response = randomNumber(1, 75);
                sendData = String.valueOf(response).getBytes();

                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, 4446);
                serverSocket.send(sendPacket);

//                if (Objects.equals(input, "GET.NUMBER")) {
//                    InetAddress address = packet.getAddress();
//                    int port = packet.getPort();
//
//                    int response = randomNumber(1, 75);
//                    sendData = String.valueOf(response).getBytes();
//
//                    packet = new DatagramPacket(sendData, sendData.length, address, port);
//                    serverSocket.send(packet);
//                }

//                    if (Objects.equals(input, "POST.WINNER")) {
//                        out.println("Client" + connectionNumber + " " + "WINS!");
//                    }

                // }

            } catch (IOException e) {
                System.out.println("error nr: " + connectionNumber + ": " + e);
            }
        }
    }

    static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}
