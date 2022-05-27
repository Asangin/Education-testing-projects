package com.skryl.edu.extensions;

import com.skryl.edu.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Skryl D.V. on 2022-05-27
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class UserParameterConverter implements ArgumentConverter {

    private static List<User> userList = Arrays.asList(
            new User().setAge(36).setName("Skryl").setState(User.State.ENABLE),
            new User().setAge(31).setName("Mary").setState(User.State.DISABLE)
    );

    @Override
    public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        Assertions.assertTrue(o.getClass() == User.State.class);
        Assertions.assertTrue(parameterContext.getParameter().getType() == User.class);

        return userList.stream()
                .filter(p -> p.getState() == o)
                .findFirst()
                .orElseThrow(() -> new ArgumentConversionException(""));
    }
}
