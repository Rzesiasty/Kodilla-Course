package com.kodilla.testing.forum.statistic;

public class StatisticCalculator {
    private Statistics statistics;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPosts;

    public StatisticCalculator(Statistics statistic) {
        this.statistics = statistic;

    }
    public int getSize() {
        return statistics.usersNames().size();
    }
    public double getPostCount(){
        return statistics.postsCount();
    }
    public double getCommentsCount(){
        return statistics.commentsCount();
    }

    public void calculateAdvStatistics(Statistics statistics) {
        if(getSize()!=0){
            if(getPostCount() != 0 && getCommentsCount() != 0){
                averagePostsPerUser = getPostCount() / getSize();
                averageCommentsPerUser = getCommentsCount() / getSize();
                averageCommentsPerPosts = getPostCount() / getCommentsCount();
            }else if(getPostCount()==0){
                averagePostsPerUser = 0;
                averageCommentsPerUser = 0;
                averageCommentsPerPosts = 0;
            }else if(getCommentsCount()==0){
                averagePostsPerUser = getPostCount() / getSize();
                averageCommentsPerUser = 0;
                averageCommentsPerPosts = 0;
            }
        }else {
            System.out.println("Users list is empty");
        }
    }
    public void showStatistics(){
        System.out.println("Number of users: " + getSize() + "\n" +
                            "Average posts per user: " + averagePostsPerUser + "\n" +
                            "Average comments per user: " + averageCommentsPerUser + "\n" +
                            "Average comments per posts: " + averageCommentsPerPosts + "\n");
    }
}
