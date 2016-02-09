package com.pduda.gameoflife;

import com.pduda.myjava.MyBoolean;
import com.pduda.myjava.MyHashSet;
import com.pduda.myjava.MyInteger;
import com.pduda.myjava.MyObject;

import static com.pduda.myjava.MyHashSet.createHashSet;

public class Generation extends MyObject {
    private final MyHashSet<Cell> lifeCells;

    public Generation(MyHashSet<Cell> lifeCells) {
        this.lifeCells = lifeCells;
    }

    public static Generation withLife(Cell... cells) {
        return new Generation(createHashSet(cells));
    }

    public static Generation dead() {
        return new Generation(createHashSet());
    }

    public Generation evolve() {

        MyHashSet<Cell> survivors = createHashSet();
        createCandidates().forEach(c -> {
            calculateNeighbours(c).myEquals(new MyInteger(3))
                    .or(calculateNeighbours(c).myEquals(new MyInteger(2))
                            .and(isCellAlive(c)))
                    .ifTrue(() -> survivors.add(c));
        });

        return new Generation(survivors);
    }

    private MyBoolean isCellAlive(Cell cell) {
        return lifeCells.contains(cell);
    }

    private MyHashSet<Cell> createCandidates() {
        MyHashSet candidates = createHashSet();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                candidates.add(new Cell(x, y));
            }
        }
        return candidates;
    }

    private MyInteger calculateNeighbours(Cell potentialNeighbour) {
        return lifeCells.count(c -> c.isNeighbourWith(potentialNeighbour));
    }

    @Override
    public MyBoolean myEquals(MyObject that) {
        return lifeCells.myEquals(((Generation) that).lifeCells);
    }

    @Override
    public String toString() {
        return "Generation{" +
                "lifeCells=" + lifeCells +
                '}';
    }
}
