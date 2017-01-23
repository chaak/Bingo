package com.web.client;

import java.io.IOException;
import java.net.*;
import java.util.TimerTask;

import static com.web.client.ClientBingo.randomNumber;

/**
 * Created by JakubWitczak on 05.01.2017.
 */
class ServerConnection extends TimerTask {
    final InetAddress group = InetAddress.getByName("237.0.0.1");
    final int port = 9000;

    ServerConnection() throws UnknownHostException {
    }

    @Override
    public void run() {

        try {
            MulticastSocket socket = new MulticastSocket(port);
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
                sendPacket = new DatagramPacket(sendData, sendData.length, group, 8000);
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
                    sendPacket = new DatagramPacket(sendData, sendData.length, group, 8500);
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
