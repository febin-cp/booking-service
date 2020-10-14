package com.sportsbooking.intdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleControllerTest {

    @Test
    public void testSample(){
        SampleController sampleController = new SampleController();
        sampleController.hello();
    }
}
