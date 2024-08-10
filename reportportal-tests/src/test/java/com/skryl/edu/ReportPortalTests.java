package com.skryl.edu;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Skryl D.V. on 2024-08-10
 */
@ExtendWith(ReportPortalExtension.class)
public class ReportPortalTests {

    private Logger log = LoggerFactory.getLogger(ReportPortalTests.class);

    @Test
    void sendLogToReportPortal() {
        log.info("log in to report portal");
    }

}
