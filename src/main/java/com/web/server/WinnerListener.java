package com.web.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/**
 * Created by JakubWitczak on 22.01.2017.
 */
public class WinnerListener extends Thread {

    final InetAddress group = InetAddress.getByName("237.0.0.1");
    final int port = 9000;

    public WinnerListener() throws IOException {
        System.out.println("Winner listener is launched.");
    }

    public void run() {

        try {
            MulticastSocket winnerListenerSocket = new MulticastSocket(8500);
            winnerListenerSocket.setInterface(InetAddress.getLocalHost());
            winnerListenerSocket.joinGroup(group);

            DatagramPacket receivePacket;
            DatagramPacket sendPacket;

            byte[] receiveData;
            byte[] sendData;

            while (true) {
                System.out.println(">>>Waiting for the winner..");
                receiveData = new byte[1024];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                winnerListenerSocket.receive(receivePacket);
                System.out.println(">>>Package received: " + new String(receivePacket.getData()));

                String message = new String(receivePacket.getData()).trim();
                if (message.equals("WINNER")) {
                    sendData = new byte[1024];
                    String winnerMessage = "YOU LOSE";
                    sendData = winnerMessage.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, group, port);
                    winnerListenerSocket.send(sendPacket);
                    winnerListenerSocket.close();
                    Connection.serverSocket.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
