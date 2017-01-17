package com.web.client;

import java.io.IOException;
import java.net.*;
import java.util.TimerTask;

import static com.web.client.ClientBingo.randomNumber;

/**
 * Created by JakubWitczak on 05.01.2017.
 */
class ServerConnection extends TimerTask {
    private static String IP = "230.0.0.1";
    private static int PORT = 4446;
    byte[] receiveData = new byte[256];
    byte[] sendData = new byte[256];

    @Override
    public void run() {

        try {
            MulticastSocket socket = new MulticastSocket(PORT);
            InetAddress address = InetAddress.getByName(IP);
            socket.joinGroup(address);
            DatagramPacket packet;

            while (true) {
                //geting response
                packet = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(packet);
                String response = new String(packet.getData(), 0, packet.getLength());
                System.out.println(response);
                randomNumber.setValue(response);
                ClientBingo.turn = false;

//                if(ClientBingo.checkState()){
//                    System.out.println("POST.WINNER");
//                    //randomNumber.setValue(serverInput.readLine());// kazdy client musi miec to ustawione
//                    socket.leaveGroup(address);
//                    socket.close();
//                    cancel();
//                }

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
