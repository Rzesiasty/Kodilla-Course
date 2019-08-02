package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuit {
    @Test
    public void testToString() {
        //Given
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task Number " + n)));

        Board board = new Board("Project nr 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        System.out.println(board);

        //When
        //Then
        Assert.assertEquals(3, board.getLists().size());
    }

}
