package com.web.client;

/**
 * Created by JakubWitczak on 02.01.2017.
 */
public class Combo {
    private Tile[] tiles;

    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }

    public boolean isBingo() {
        if(tiles[0].getValue().getText().isEmpty())
            return false;

        return tiles[0].getValue().getText().equals(tiles[1].getValue().getText())
                && tiles[0].getValue().getText().equals(tiles[2].getValue().getText())
                && tiles[0].getValue().getText().equals(tiles[3].getValue().getText())
                && tiles[0].getValue().getText().equals(tiles[4].getValue().getText());
    }
}
