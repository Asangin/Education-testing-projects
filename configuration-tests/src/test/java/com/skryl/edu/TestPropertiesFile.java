package com.skryl.edu;

import com.skryl.edu.utils.TestProperties;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-10-14
 */
public class TestPropertiesFile {

    @Test
    public void getConfigFromPropertiesFileTest() {
        // Arrange
        TestProperties properties = new TestProperties();

        // Act
        var result = properties.getValue("base.url");

        // Assert
        assertThat(result).isEqualTo("http://localhost:8080/test");
    }

    @Test
    public void getDefaultConfigTest() {
        // Arrange
        TestProperties properties = new TestProperties();

        // Act
        var result = properties.getValueOrDefault("not.exist.property", "defaultValue");

        // Assert
        assertThat(result).isEqualTo("defaultValue");
    }


}
