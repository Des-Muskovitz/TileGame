package com.github.sammuskovitz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

public class Visualizer {

    private static List<JPanelTile> allTiles = new ArrayList<>();


    public static JPanelTile convertTileToJPanel(Tile tile){
        JPanelTile jPanel = new JPanelTile(tile);

        switch(jPanel.getTile().getTileCode()){
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

        allTiles.add(jPanel);

        return jPanel;
    }

    private static boolean isWithinArea(int x1, int y1, int x2, int y2, int width, int height){
        return x1 >= x2 && x1 <= x2 + width && y1 >= y2 && y1 <= y2 + height;
    }

    public static JFrame setupJFrame(GameMap gameMap, int width, int height, String windowTitle){
        JPanel field = new JPanel(new GridLayout(gameMap.getMapWidth(), gameMap.getMapHeight()));

        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

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

