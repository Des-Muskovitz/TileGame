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
                int mouseX = e.getX();
                int mouseY = e.getY();

                Component[] tiles = field.getComponents();

                for(int i = 0; i < allTiles.size(); i++){

                    if(isWithinArea(mouseX, mouseY, tiles[i].getX(), tiles[i].getY(), tiles[i].getWidth(), tiles[i].getHeight())){
                        tiles[i].setBackground(allTiles.get(i).getTile().getPaintColor());
                    }
                }
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

