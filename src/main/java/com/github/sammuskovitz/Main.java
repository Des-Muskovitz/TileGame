package com.github.sammuskovitz;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameMap gameMap = new GameMap(new char[][]{
                {'w','w','w','w','w'},
                {'w','e','e','e','w'},
                {'w','e','w','e','w'},
                {'w','e','e','e','w'},
                {'w','w','w','w','w'}
        });


        JFrame frame = Visualizer.setupJFrame(gameMap, 1000, 1000, "Game Window");
        frame.setVisible(true);
    }
}
