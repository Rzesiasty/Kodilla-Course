package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(598624587, "user1", 'M', 1969, 11, 11, 10));
        theUserList.add(new ForumUser(587463214, "user2", 'F', 1989, 4, 25, 0));
        theUserList.add(new ForumUser(789654231, "user3", 'M', 2003, 7, 15, 100));
        theUserList.add(new ForumUser(894874536, "user4", 'F', 2007, 8, 30, 5));
        theUserList.add(new ForumUser(238624487, "user5", 'M', 1962, 9, 7, 4));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
