package com.skryl.edu;

import com.skryl.edu.configs.EnvironmentConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-09-13
 */
public class TestEnvironmentConfig {

    @Test
    void printEnvironment() {
        EnvironmentConfig env = ConfigFactory.create(EnvironmentConfig.class);
        printEnvs(env);
        assertThat(env.env()).isEqualTo("Local");

        EnvironmentConfig env2 = ConfigFactory.create(
                EnvironmentConfig.class,
                Map.of("env", "Stage")
        );
        printEnvs(env2);
        assertThat(env2.env()).isEqualTo("Stage");

    }

    private static void printEnvs(EnvironmentConfig env) {
        System.out.printf(
                "Grpc host: %s, Postgre host: %s, Postgre user: %s%n",
                env.grpcHost(),
                env.postgreHost(),
                env.postgreUser()
        );
    }

}
