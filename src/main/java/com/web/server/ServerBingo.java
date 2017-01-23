//package com.web.server;

import com.web.server.Connection;
import com.web.server.ParserXML;
import com.web.server.WinnerListener;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ServerBingo {

    public static void main(String args[]) throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        new Connection().start();
        new WinnerListener().start();
    }

}



