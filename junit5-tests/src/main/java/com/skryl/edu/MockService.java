package com.skryl.edu;

/**
 * @author Skryl D.V. on 2022-05-27
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class MockService implements SiteService {
    @Override
    public String say() {
        return "This is a test";
    }
}
