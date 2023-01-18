package com.mukesh.headlines.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Mukesh on 15/11/22
 **/

public class CommonUtilTest {


    @Test
    public void add() {
        int a = 10;
        int b = 20;
        int result = CommonUtil.add(a,b);
        assertEquals(30, result);
    }

    @Test
    public void text_add_null_first_params() {
        Integer a = null;
        int b = 20;
        int result = CommonUtil.add(a,b);
        assertEquals(20, result);
    }

    @Test
    public void text_subtract() {
        CommonUtil cu = new CommonUtil();
        Integer a = null;
        int b = 20;
        int result = cu.subtract(a,b);
        assertEquals(20, result);
    }
}