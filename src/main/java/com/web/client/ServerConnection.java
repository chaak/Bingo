package com.web.client;

import java.io.IOException;
import java.net.*;
import java.util.TimerTask;

import static com.web.client.ClientBingo.randomNumber;

/**
 * Created by JakubWitczak on 05.01.2017.
 */
class ServerConnection extends TimerTask {

    private final String IP = "237.0.0.1";
    private final int clientPort = 9000;
    private final int serverPort = 8000;
    private final int winnerListenerPort = 8500;
    private final InetAddress group = InetAddress.getByName(IP);

    ServerConnection() throws UnknownHostException {
    }

    @Override
    public void run() {

        try {
            MulticastSocket socket = new MulticastSocket(clientPort);
            socket.setInterface(InetAddress.getLocalHost());
            socket.joinGroup(group);

            DatagramPacket receivePacket;
            DatagramPacket sendPacket;

            byte[] sendData;
            byte[] receiveData;

            while (true) {
                sendData = new byte[1024];
                String getNumber = "GET.NUMBER";
                sendData = getNumber.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, group, serverPort);
                socket.send(sendPacket);

                System.out.println("Waiting for a reply..");
                receiveData = new byte[1024];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData()).trim();

                System.out.println("FROM SERVER: " + message);
                randomNumber.setValue(message);
                ClientBingo.turn = false;

                if (ClientBingo.checkState()) {
                    randomNumber.setValue("WINNER");
                    sendData = "WINNER".getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, group, winnerListenerPort);
                    System.out.println(new String(sendPacket.getData()).trim());
                    socket.send(sendPacket);

                    socket.leaveGroup(group);
                    socket.close();
                    cancel();
                    break;
                }
            }

        } catch (SocketTimeoutException s) {
            System.out.println("Time out");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
