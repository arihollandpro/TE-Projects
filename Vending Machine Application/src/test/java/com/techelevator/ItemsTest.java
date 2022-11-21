package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemsTest {
    @Test

    public void test_For_Negatives (){
        Items testthing = new Items("a3", "candybar", BigDecimal.valueOf(0.05), "Candy", 5);
        BigDecimal actual = testthing.purchase(BigDecimal.valueOf(0));

        //assert

        Assert.assertEquals(0, actual);

    }
    @Test

    public void test_For_Correct_balance (){
        Items testthing = new Items("a3", "candybar", BigDecimal.valueOf(1.25), "Candy", 5);
        BigDecimal actual = testthing.purchase(BigDecimal.valueOf(2.00));

        //assert

        Assert.assertEquals(0.75, actual);

    }

    @Test

    public void is_it_really_sold_out (){
        Items testthing = new Items("a3", "candybar", BigDecimal.valueOf(0.05), "Candy", 1);
        boolean actual = testthing.isSoldOut();

        //assert

        Assert.assertEquals(false, actual);

    }
    @Test

    public void totally_definitely_sold_out () {
        Items testthing = new Items("a3", "candybar", BigDecimal.valueOf(0.05), "Candy", 0);
        boolean actual = testthing.isSoldOut();

        //assert

        Assert.assertEquals(true, actual);
    }




    }
