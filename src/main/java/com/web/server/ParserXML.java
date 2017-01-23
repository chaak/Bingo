package com.web.server;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

/**
 * Created by JakubWitczak on 22.01.2017.
 */
public class ParserXML {

    private File fXmlFile = new File("server.xml");
    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    private Document doc = dBuilder.parse(fXmlFile);

    public ParserXML() throws ParserConfigurationException, IOException, SAXException {
    }

   public int getClientPort(){
        int clientPort = 0;
        try {
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("server");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    clientPort = Integer.parseInt(eElement.getElementsByTagName("clientPort").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return clientPort;
    }

    public String getIp(){
        String ip = null;
        try {
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("server");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    ip = eElement.getElementsByTagName("ip").item(0).getTextContent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    public int getServerPort(){
        int serverPort = 0;
        try {
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("randomNumberListener");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    serverPort = Integer.parseInt(eElement.getElementsByTagName("serverPort").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    public int getWinnerListenerPort(){
        int winnerListenerPort = 0;
        try {
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("winnerListener");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    winnerListenerPort = Integer.parseInt(eElement.getElementsByTagName("listenerPort").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return winnerListenerPort;
    }
}



