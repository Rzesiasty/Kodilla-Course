package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList1 = new TaskList("tasklist1", "description of first task");
        TaskList taskList2 = new TaskList("tasklist2", "description of second task");
        //when
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        //Then
        String listName2 = taskList2.getListName();
        List<TaskList> readTaskList = taskListDao.findByListName(listName2);
        Assert.assertEquals(1, readTaskList.size());
        Assert.assertEquals(listName2, readTaskList.get(0).getListName());

        //CleanUp
        taskListDao.delete(taskList1);
        taskListDao.delete(taskList2);
    }

    @Test
    public void testTaskListDaoSaveWithTasks(){
        //Given
        Task task = new Task("Test: learn hibernate", 14);
        Task task2 = new Task("Test: learn hibernate", 5);
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(150), false);
        TaskFinancialDetails taskFinancialDetails1 = new TaskFinancialDetails(new BigDecimal(180), false);
        task.setTaskFinancialDetails(taskFinancialDetails);
        task2.setTaskFinancialDetails(taskFinancialDetails1);
        TaskList taskList = new TaskList("LISTNAME", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        taskListDao.delete(taskList);
    }
}
