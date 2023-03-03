package com.skryl.edu;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-03-02
 */
public class FileSystemAssertionTests {
    @Test
    void assertThatFolderIsNotEmpty() {
        var path = Paths.get(System.getProperty("user.dir"));
        assertThat(path)
                .isNotEmptyDirectory();
    }

    @Test
    void assertThatFolderIsEmpty() {
        var file = new File("src/test/resources");
        assertThat(file)
                .isEmptyDirectory();
    }

    @Test
    void fileDoesNotExist() {
        var file = new File(System.getProperty("user.home") + System.lineSeparator() + "not_exist.file");
        assertThat(file)
                .doesNotExist();
    }

    @Test
    void verifyThatChildDirectoryExistInRootDirectory() {
        var folder = new File("src");
        assertThat(folder)
                .isDirectory();
        assertThat(folder)
                .isDirectoryContaining("glob:**test*");
    }

    @Test
    void checkThatAssertJActuallyVerifyFolderRecursively() {
        var folder = new File("src");
        assertThat(folder)
                .isDirectoryContaining("glob:**unexistdir*");
    }

    @Test
    void verifyThatChildDirectoryDoesNotExistInRootDirectory() {
        var folder = new File("src");
        assertThat(folder)
                .isDirectoryNotContaining("glob:**unexistdir*");
    }

}
