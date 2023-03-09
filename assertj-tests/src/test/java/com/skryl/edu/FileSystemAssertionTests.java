package com.skryl.edu;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    void verifyThatChildDirectoryExistInRootDirectoryRecursively() {
        var folder = new File("src");
        assertThat(folder)
                .isDirectoryRecursivelyContaining(p -> p.getName().equals("edu"));
        assertThat(folder)
                .isDirectoryRecursivelyContaining("glob:**test*");
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

    /**
     * Should fail to verify assertion is correct
     */
    @Test
    void verifyThatChildDirectoryDoesNotExistInRootRecursively() throws IOException {
        var paths = listOfPaths("src");
        assertThat(paths)
                .map(Path::toFile)
                .map(File::getName)
                .doesNotContain("edu");
    }

    private List<Path> listOfPaths(String path) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(path))) {
            return stream.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
    }

}
