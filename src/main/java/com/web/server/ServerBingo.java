//package com.web.server;

import com.web.server.Connection;

import java.io.IOException;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ServerBingo {

    public static void main(String args[]) throws InterruptedException, IOException {

        int connectionNumber = 1;
        int counter = 0;

        while (true) {
            System.out.print(counter++ + " ");
            Thread.sleep(1000);
            //dodawanie clientow
            if (counter == 10) break;
        }

        new Connection(connectionNumber++).start();
    }

}



