package com.skryl.edu;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * @author Skryl D.V. on 2022-05-04
 * Copyright © 2022 Perenio. All rights reserved.
 */
@Suite
@SuiteDisplayName("Concurrent junit 5 suite")
@SelectPackages("com.skryl.edu.concurrent")
public class ConcurrentSuites {
}
