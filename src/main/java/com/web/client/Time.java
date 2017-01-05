package com.web.client;

import java.util.TimerTask;

/**
 * Created by JakubWitczak on 05.01.2017.
 */
class Time extends TimerTask{
    @Override
    public void run() {
        ClientBingo.randomNumber.setValue(String.valueOf(BingoBoard.randomNumber(1, 75)));
    }
}
