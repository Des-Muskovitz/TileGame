package com.github.sammuskovitz;

import junit.framework.TestCase;
import org.junit.Test;

public class CoordinateTest extends TestCase{

    @Test
    public void testToString(){
        Coordinate coordinate = new Coordinate();
        Coordinate coordinate1 = new Coordinate(99,99);

        assertTrue("Expected result: 0,0, Actual Result: " + coordinate.toString(),coordinate.toString().equals("0,0"));
        assertTrue("Expected result: 99,99, Actual Result: " + coordinate1.toString(), coordinate1.toString().equals("99,99"));
    }
}