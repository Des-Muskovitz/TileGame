package com.github.sammuskovitz;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Tile {

    private Coordinate coordinates;
    private boolean isPainted;
    private Color paintColor;
    private char tileCode;

    public Tile(Coordinate coordinates, char tileCode){
        this.coordinates = coordinates;
        this.tileCode = tileCode;
        paintColor = Color.BLUE;
        isPainted = false;
    }

    public Tile(Coordinate coordinates, char tileCode, Color paintColor) {
        this.coordinates = coordinates;
        this.tileCode = tileCode;
        this.paintColor = paintColor;
        isPainted = false;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public Color getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(Color paintColor) {
        this.paintColor = paintColor;
    }

    public char getTileCode(){
        return tileCode;
    }

    public void setTileCode(char tileCode){
        this.tileCode = tileCode;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "coordinates=" + coordinates +
                ", isPainted=" + isPainted +
                ", paintColor=" + paintColor +
                ", tileCode=" + tileCode +
                '}';
    }

    public String simpleToString(){
        return "coordinates=" + coordinates +
                "tileCode=" + tileCode;
    }
}
