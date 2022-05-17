package com.skryl.edu.concurrent;

import org.junit.jupiter.api.Test;

/**
 * @author Skryl D.V. on 2022-05-04
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class SecondParallelUnitTest {
    @Test
    public void first() throws Exception{
        System.out.println("SecondParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("SecondParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("SecondParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("SecondParallelUnitTest second() end => " + Thread.currentThread().getName());
    }
}
