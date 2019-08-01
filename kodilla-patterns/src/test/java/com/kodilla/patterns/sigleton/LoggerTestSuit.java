package com.kodilla.patterns.sigleton;

import com.kodilla.patterns.singleton.Logger;
import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuit {
    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("First daily log");
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("First daily log", log);
    }
}
