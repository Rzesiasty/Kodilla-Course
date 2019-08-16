package com.kodilla.tasklist.dao;


import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
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
        TaskList taskList = new TaskList("LISTNAME", "DESCRIPTION");
        taskListDao.save(taskList);
        String list = taskList.getListName();

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(list);

        //Then
        Assert.assertEquals(1, readTaskList.size());

        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
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
        taskListDao.deleteById(id);
    }
}
