package com.pduda.gameoflife;

import org.junit.Test;
import testframework.Assertions;

public class GenerationTest {

    @Test
    public void deadGenerationsAreEqual() {
        Assertions.assertEquals(Generation.dead(), Generation.dead());
    }

    @Test
    public void generationsWithSameCellAreEqual() {
        Cell cell = new Cell(1, 1);
        Assertions.assertEquals(Generation.withLife(cell), Generation.withLife(cell));
    }

    @Test
    public void generationsWithSameCellsAreEqual() {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(2, 2);
        Assertions.assertEquals(Generation.withLife(cell1, cell2), Generation.withLife(cell1, cell2));
    }

    @Test
    public void deadGenerationIsNotEqualToAOneCellGeneration() {
        Cell someCell = new Cell(1, 1);
        Assertions.assertNotEquals(Generation.dead(), Generation.withLife(someCell));
    }
}
