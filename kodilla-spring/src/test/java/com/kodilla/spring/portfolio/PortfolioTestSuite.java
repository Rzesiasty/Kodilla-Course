package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioTestSuite {
    @Test
    public void testTasksAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        //When
        board.doneList.addTask("Task nr 1");
        board.doneList.addTask("Task nr 2");
        board.doneList.addTask("Task nr 3");
        board.inProgressList.addTask("Task nr 4");
        board.inProgressList.addTask("task nr 5");
        board.toDoList.addTask("Task nr 6");

        //Then
        Assert.assertEquals(3, board.doneList.getTasks().size());
        Assert.assertEquals(2, board.inProgressList.getTasks().size());
        Assert.assertEquals(1, board.toDoList.getTasks().size());
    }
}
