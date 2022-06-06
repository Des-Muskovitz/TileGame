package com.github.sammuskovitz;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TileTest extends TestCase {

    @Test
    public void testTile(){
        Tile tile = new Tile(new Coordinate(), 'e');

        assertFalse(tile.isPainted());
        assertTrue(tile.getCoordinates().toString().equals("0,0"));
        assertTrue(tile.getPaintColor().equals(Color.BLUE));
    }

}