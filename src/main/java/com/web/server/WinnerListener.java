package com.web.server;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by JakubWitczak on 22.01.2017.
 */
public class WinnerListener extends Thread {

    ParserXML parser = new ParserXML();
    private final String IP = parser.getIp();
    private final int clientPort = parser.getClientPort();
    private final int serverPort = parser.getWinnerListenerPort();
    private final InetAddress group = InetAddress.getByName(IP);

    public WinnerListener() throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Winner listener is launched.");
    }

    public void run() {

        try {
            MulticastSocket winnerListenerSocket = new MulticastSocket(serverPort);
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
                    sendPacket = new DatagramPacket(sendData, sendData.length, group, clientPort);
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
