package com.kodilla.testing.forum.statistic;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    public List<String> generateListOfNUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for(int n = 1; n <= usersQuantity; n++){
            resultList.add("User Name" + n);
        }
        return resultList;
    }
}
