//package com.web.server;

import com.web.server.Connection;
import com.web.server.WinnerListener;

import java.io.IOException;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ServerBingo {

    public static void main(String args[]) throws InterruptedException, IOException {
        new Connection().start();
        new WinnerListener().start();
    }

}



