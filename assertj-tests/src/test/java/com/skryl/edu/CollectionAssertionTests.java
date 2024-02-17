package com.skryl.edu;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-05-07
 */
public class CollectionAssertionTests {

    @Test
    void oneCollectionContainsAnotherCollection() {
        var actualCollection = Arrays.asList("1", "2", "3", "4");
        assertThat(actualCollection).contains("2", "3");
    }

    @Test
    void assertStringCollectionWithMatching() {
        var list = Arrays.asList("Hello", "World");
        assertThat(list.stream().allMatch(p -> StringUtils.containsIgnoreCase(p, "He")))
                .as("match substring in string collections")
                .isTrue();
    }


    //TODO how to assert List 1 in List 2, that List 1 contains expected String
    /**
     * [
     *  {
     *      "types": ["type1", "type2"]
     *  },
     *  {
     *      "types": ["type1"]
     *  },
     *  {
     *      "types": ["type1", "type2", "type3"]
     *  }
     * ]
     * Need to verify that every object in a list has a collection types with type 1
     */
}
