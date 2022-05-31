package com.skryl.edu;

import com.skryl.edu.configs.DemonstrateConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

/**
 * @author Skryl D.V. on 2022-05-21
 */
public class TestDemonstration {

    @Test
    void printConfiguration() {
        DemonstrateConfig cfg = ConfigFactory.create(DemonstrateConfig.class);
        System.out.println("Base url: " + cfg.baseUrl() + " Port: " + cfg.port());
    }
}
