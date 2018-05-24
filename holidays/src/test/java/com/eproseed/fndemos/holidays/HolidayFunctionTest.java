package com.eproseed.fndemos.holidays;

import com.fnproject.fn.testing.*;
import org.junit.*;

import static org.junit.Assert.*;

public class HolidayFunctionTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

   
    @Test
    public void shouldReturnWithInput() {
        testing.givenEvent().withBody("NETHERLANDS").enqueue();
        testing.thenRun(HolidayFunction.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        assertEquals("10", result.getBodyAsString());
    }

}