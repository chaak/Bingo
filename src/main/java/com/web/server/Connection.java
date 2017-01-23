package com.web.server;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.*;
import java.util.Random;

/**
 * Created by JakubWitczak on 15.01.2017.
 */
public class Connection extends Thread {

    ParserXML parser = new ParserXML();
    private final String IP = parser.getIp();
    private final int clientPort = parser.getClientPort();
    private final int serverPort = parser.getServerPort();
    private final int delay = 3000;
    static MulticastSocket serverSocket;
    private final InetAddress group = InetAddress.getByName(IP);

    public Connection() throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Server is launched.");
    }

    public void run() {

        try {
            serverSocket = new MulticastSocket(serverPort);
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
                    sendPacket = new DatagramPacket(sendData, sendData.length, group, clientPort);
                    serverSocket.send(sendPacket);
                }

                try {
                    Thread.sleep(delay);
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
