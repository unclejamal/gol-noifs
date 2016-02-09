package com.pduda.gameoflife;

import org.junit.Test;
import testframework.Assertions;

public class GameOfLifeTest {
    @Test
    public void deadGenerationEvolvesIntoADeadGeneration() {
        Generation generation = Generation.dead();
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.dead(), nextGeneration);
    }

    @Test
    public void oneCellGenerationEvolvesIntoADeadGeneration() {
        Generation generation = Generation.withLife(new Cell(0, 0));
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.dead(), nextGeneration);
    }

    @Test
    public void oneCellGenerationDoesNotEvolveIntoADeadGeneration() {
        Generation generation = Generation.withLife(new Cell(0, 0));
        Generation nextGeneration = generation.evolve();
        Assertions.assertNotEquals(Generation.withLife(new Cell(0, 0)), nextGeneration);
    }

    @Test
    public void triangleGenerationEvolvesIntoAOneCellGeneration() {
        Generation generation = Generation.withLife(new Cell(0, 2), new Cell(2, 0), new Cell(0, 0));
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.withLife(new Cell(1, 1)), nextGeneration);
    }

    @Test
    public void distantTriangleGenerationEvolvesIntoADeadGeneration() {
        Generation generation = Generation.withLife(new Cell(0, 5), new Cell(5, 0), new Cell(0, 0));
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.dead(), nextGeneration);
    }

    @Test
    public void triangleGenerationEvolvesIntoAOneCellGeneration_case2() {
        Generation generation = Generation.withLife(new Cell(1, 3), new Cell(3, 1), new Cell(1, 1));
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.withLife(new Cell(2, 2)), nextGeneration);
    }

    @Test
    public void twoIndependentTrianglesEvolveIntoA2CellGeneration() {
        Generation generation = Generation.withLife(new Cell(0, 2), new Cell(2, 0), new Cell(0, 0), new Cell(5, 7), new Cell(7, 5), new Cell(5, 5));
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.withLife(new Cell(1, 1), new Cell(6, 6)), nextGeneration);
    }

    @Test
    public void verticalBlinkerEvolvesIntoAHorizontalBlinker() {
        Generation generation = Generation.withLife(new Cell(1, 0), new Cell(1, 1), new Cell(1, 2));
        Generation nextGeneration = generation.evolve();
        Assertions.assertEquals(Generation.withLife(new Cell(0, 1), new Cell(1, 1), new Cell(2, 1)), nextGeneration);
    }


}
