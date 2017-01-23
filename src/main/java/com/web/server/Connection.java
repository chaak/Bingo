package com.web.server;

import java.io.IOException;
import java.net.*;
import java.util.Random;

/**
 * Created by JakubWitczak on 15.01.2017.
 */
public class Connection extends Thread {

    final InetAddress group = InetAddress.getByName("237.0.0.1");
    final int port = 9000;
    static MulticastSocket serverSocket;

    public Connection() throws IOException {
        System.out.println("Server is launched.");
    }

    public void run() {

        try {
            serverSocket = new MulticastSocket(8000);
            serverSocket.setInterface(InetAddress.getLocalHost());
            serverSocket.joinGroup(group);

            DatagramPacket receivePacket;
            DatagramPacket sendPacket;

            byte[] receiveData;
            byte[] sendData;

            while (true) {
                receiveData = new byte[1024];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                System.out.println(">>>Package received: " + new String(receivePacket.getData()));

                String message = new String(receivePacket.getData()).trim();
                if (message.equals("GET.NUMBER")) {
                    sendData = new byte[1024];
                    int response = randomNumber(1, 75);
                    sendData = String.valueOf(response).getBytes();
                    System.out.println("To client: " + response);
                    sendPacket = new DatagramPacket(sendData, sendData.length, group, port);
                    serverSocket.send(sendPacket);
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

    static public int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}
