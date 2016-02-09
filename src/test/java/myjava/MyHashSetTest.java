package myjava;

import com.pduda.gameoflife.Cell;
import com.pduda.myjava.MyHashSet;
import org.junit.Test;
import testframework.Assertions;

public class MyHashSetTest {

    @Test
    public void emptySetDoesNotContainAnyElement() {
        MyHashSet<Cell> emptySet = MyHashSet.createHashSet();
        Assertions.assertFalse(emptySet.contains(new Cell(1, 1)));
    }

    @Test
    public void hashSetWithOneCellContainsThatCell() {
        MyHashSet<Cell> setWithOneCell = MyHashSet.createHashSet(new Cell(1, 1));
        Assertions.assertTrue(setWithOneCell.contains(new Cell(1, 1)));
    }
}
