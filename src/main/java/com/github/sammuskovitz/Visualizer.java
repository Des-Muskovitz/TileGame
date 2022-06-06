package com.github.sammuskovitz;

import javax.swing.*;
import java.awt.*;

public class Visualizer {

    public static JPanel convertTileToJPanel(Tile tile){
        JPanel jPanel = new JPanel();

        switch(tile.getTileCode()){
            case 'w':
                jPanel.setBackground(Color.BLACK);
                break;
            case 'e':
                jPanel.setBackground(Color.GRAY);
                break;
            case 'p':
                jPanel.setBackground(tile.getPaintColor());
                break;
            default:
                jPanel.setBackground(Color.WHITE);
        }

        return jPanel;
    }

    public static JFrame setupJFrame(GameMap gameMap, int width, int height, String windowTitle){
        JPanel field = new JPanel(new GridLayout(gameMap.getMapWidth(), gameMap.getMapHeight()));

        for(Tile tile : gameMap.getAllTiles()){
            field.add(Visualizer.convertTileToJPanel(tile));
        }

        JFrame frame = new JFrame(windowTitle);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(field);
        frame.setSize(new Dimension(width, height));

        return frame;
    }


}

