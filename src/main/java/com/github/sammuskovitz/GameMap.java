package com.github.sammuskovitz;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private List<Tile> allTiles;
    private int mapHeight;
    private int mapWidth;

    public GameMap(char[][] tileCodes){
        initialize(tileCodes);
    }

    private void initialize(char[][] tileCodes){
        mapHeight = tileCodes.length;

        mapWidth = calculateMapWidth(tileCodes);

        allTiles = createTileList(tileCodes);
    }

    private int calculateMapWidth(char[][] tileCodes){
        int maxMapWidth = tileCodes[0].length;
        maxMapWidth = tileCodes[0].length;
        for(int i = 1; i < tileCodes.length; i++){
            if(tileCodes[i].length > maxMapWidth){
                maxMapWidth = tileCodes[i].length;
            }
        }
        return maxMapWidth;
    }

    private List<Tile> createTileList(char[][] tileCodes){
        List<Tile> allTiles = new ArrayList<>();

        for(int i = 0; i < tileCodes.length; i++){
            for(int j = 0; j < tileCodes[i].length; j++){
                allTiles.add(new Tile(new Coordinate(i,j),tileCodes[i][j]));
            }
        }

        return allTiles;
    }

    public List<Tile> getAllTiles() {
        return allTiles;
    }

    public void setAllTiles(char[][] tileCodes) {
        initialize(tileCodes);
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }
}
