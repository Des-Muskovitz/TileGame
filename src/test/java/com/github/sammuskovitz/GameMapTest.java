package com.github.sammuskovitz;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameMapTest extends TestCase {

    @Test
    public void testGameMapConstructor(){
        GameMap gameMap1 = new GameMap(new char[][]{
                {'a', 'b', 'c'},
                {'c', 'b', 'a'},
                {'a', 'b', 'c', 'd'}
        });

        boolean listsEqual = true;
        Tile erroredTile = null;
        Tile gameMapTile = null;

        List<Tile> gameMapList = gameMap1.getAllTiles();

        List<Tile> testList = new ArrayList<>();

        testList.add(new Tile(new Coordinate(0,0), 'a'));
        testList.add(new Tile(new Coordinate(0,1), 'b'));
        testList.add(new Tile(new Coordinate(0,2), 'c'));

        testList.add(new Tile(new Coordinate(1,0), 'c'));
        testList.add(new Tile(new Coordinate(1,1), 'b'));
        testList.add(new Tile(new Coordinate(1,2), 'a'));

        testList.add(new Tile(new Coordinate(2,0), 'a'));
        testList.add(new Tile(new Coordinate(2,1), 'b'));
        testList.add(new Tile(new Coordinate(2,2), 'c'));
        testList.add(new Tile(new Coordinate(2,3), 'd'));

        for(int i = 0; i < gameMapList.size(); i++){
            listsEqual = gameMapList.get(i).simpleToString().equals(testList.get(i).simpleToString()) && gameMapList.get(i).getTileCode() == testList.get(i).getTileCode();
            if(!listsEqual){
                gameMapTile = gameMapList.get(i);
                erroredTile = testList.get(i);
                break;
            }
        }

        assertTrue("Expected mapHeight: 3 Actual mapHeight: " + gameMap1.getMapHeight(),gameMap1.getMapHeight() == 3);
        assertTrue("Expected mapWidth: 4 Actual mapWidth: " + gameMap1.getMapWidth(), gameMap1.getMapWidth() == 4);
        assertTrue("Expected Tile: " + gameMapTile + "Actual Tile: " + erroredTile, listsEqual);


    }

}