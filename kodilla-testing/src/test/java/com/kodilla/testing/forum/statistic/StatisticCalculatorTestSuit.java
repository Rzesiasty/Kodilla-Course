package com.kodilla.testing.forum.statistic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticCalculatorTestSuit {
    private static int testCounter = 0;

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing o execute test #" + testCounter);
    }

    @Test
    public void testCalculateStatisticWithPosts0() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(2);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(0);
        when(statisticMock.commentsCount()).thenReturn(100);

        double numberOfPosts = statisticMock.postsCount();

        //When
        double quantityOfPosts = statisticCalculator.getPostCount();
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(numberOfPosts, quantityOfPosts, 0);
        statisticCalculator.showStatistics();
    }

    @Test
    public void testCalculateStatisticWithPosts1000() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(10);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(1000);
        when(statisticMock.commentsCount()).thenReturn(2000);

        double numberOfPosts = statisticMock.postsCount();

        //When
        double quantityOfPosts = statisticCalculator.getPostCount();
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(numberOfPosts, quantityOfPosts, 0);
        statisticCalculator.showStatistics();
    }

    @Test
    public void testCalculateStatisticWithComments0() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(8);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(100);
        when(statisticMock.commentsCount()).thenReturn(0);

        double numberOfComments = statisticMock.commentsCount();

        //When
        double quantityOfComments = statisticCalculator.getCommentsCount();
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(numberOfComments, quantityOfComments, 0);
        statisticCalculator.showStatistics();
    }

    @Test
    public void testCalculateStatisticWithQuantityOfCommentsSmallerThenQuantityOfPosts() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(5);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(100);
        when(statisticMock.commentsCount()).thenReturn(50);

        double numberOfComments = statisticMock.commentsCount();
        double numberOfPosts = statisticMock.postsCount();
        boolean numberOfCommentsSmallerThenPosts = numberOfComments < numberOfPosts;

        //When
        double quantityOfPosts = statisticCalculator.getPostCount();
        double quantityOfComments = statisticCalculator.getCommentsCount();
        boolean quantityOfCommentsSmallerThenPosts = quantityOfComments < quantityOfPosts;
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertTrue(numberOfCommentsSmallerThenPosts);
        Assert.assertTrue(quantityOfCommentsSmallerThenPosts);
        statisticCalculator.showStatistics();
    }

    @Test
    public void testCalculateStatisticWithQuantityOfCommentsBiggerThenQuantityOfPosts() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(20);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(398);
        when(statisticMock.commentsCount()).thenReturn(5589);

        double numberOfComments = statisticMock.commentsCount();
        double numberOfPosts = statisticMock.postsCount();
        boolean numberOfCommentsBiggerThenPosts = numberOfComments > numberOfPosts;

        //When
        double quantityOfPosts = statisticCalculator.getPostCount();
        double quantityOfComments = statisticCalculator.getCommentsCount();
        boolean quantityOfCommentsBiggerThenPosts = quantityOfComments > quantityOfPosts;
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertTrue(numberOfCommentsBiggerThenPosts);
        Assert.assertTrue(quantityOfCommentsBiggerThenPosts);
        statisticCalculator.showStatistics();
    }

    @Test
    public void testCalculateStatisticWithUsers0() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(0);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(398);
        when(statisticMock.commentsCount()).thenReturn(2754);
        int quantityOfUsers = statisticMock.usersNames().size();

        //When
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(quantityOfUsers, statisticCalculator.getSize());
        statisticCalculator.showStatistics();
    }

    @Test
    public void testCalculateStatisticWithUsers100() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        StatisticCalculator statisticCalculator = new StatisticCalculator(statisticMock);

        UserGenerator userGenerator = new UserGenerator();
        List<String> usersMap = userGenerator.generateListOfNUsers(100);

        when(statisticMock.usersNames()).thenReturn(usersMap);
        when(statisticMock.postsCount()).thenReturn(398);
        when(statisticMock.commentsCount()).thenReturn(2754);
        int quantityOfUsers = statisticMock.usersNames().size();

        //When
        statisticCalculator.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(quantityOfUsers, statisticCalculator.getSize());
        statisticCalculator.showStatistics();
    }
}
