package com.skryl.edu;

import com.skryl.edu.configs.FirstLoadPolicyConfig;
import com.skryl.edu.configs.ServerConfig;
import com.skryl.edu.configs.SystemServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-05-21
 */
public class TestConfiguration {

    @Test
    void test_server_config_if_no_property_file_provide() {
        FirstLoadPolicyConfig cfg = ConfigFactory.create(FirstLoadPolicyConfig.class);
        assertThat(cfg.baseUrl()).as("empty, coz no properties find").isEqualTo(null);
        assertThat(cfg.port()).as("Default values is 80").isEqualTo(80);
    }

    @Test
    void test_server_config() {
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        assertThat(cfg.baseUrl()).isEqualTo("http://server.com.ua");
        assertThat(cfg.port()).isEqualTo(2000);
    }

    /**
     * We can provide System environment,
     * export base.url=http://system.com.ua
     * export port=4000
     */
    @Test
    void test_config_for_system_properties() {
        SystemServerConfig cfg = ConfigFactory.create(SystemServerConfig.class);
        assertThat(cfg.baseUrl()).isEqualTo("http://stage.com.ua");
        assertThat(cfg.port()).isEqualTo(90);
    }


}
