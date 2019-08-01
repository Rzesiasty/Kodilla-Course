package com.kodilla.patterns.sigleton;

import com.kodilla.patterns.singleton.Logger;
import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuit {

    Logger logger = new Logger();

    @Test
    public void testGetLastLog() {
        //Given
        logger.log("First daily log");
        //When
        String log = logger.getLastLog();

        //Then
        Assert.assertEquals("First daily log", log);

    }
}
