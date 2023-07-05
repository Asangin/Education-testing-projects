package com.skryl.edu;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Skryl D.V. on 2023-03-14
 */
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private int age;
}
