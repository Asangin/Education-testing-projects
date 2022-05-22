package com.skryl.edu;

import com.skryl.edu.configs.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-05-21
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class TestConfigurationWithJVMProperties {

    @Test
    void test_server_config_for_jvm_properties() {
        System.setProperty("base.url", "http://jvm.com.ua");
        System.setProperty("port", "3000");

        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        assertThat(cfg.baseUrl()).isEqualTo("http://jvm.com.ua");
        assertThat(cfg.port()).isEqualTo(3000);
    }
}
