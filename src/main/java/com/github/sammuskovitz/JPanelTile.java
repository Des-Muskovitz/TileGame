package com.github.sammuskovitz;

import javax.swing.*;
import java.awt.*;

public class JPanelTile extends JPanel {

    private Tile tile;

    public JPanelTile(Tile tile){
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
