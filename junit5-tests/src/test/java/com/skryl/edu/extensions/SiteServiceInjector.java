package com.skryl.edu.extensions;

import com.skryl.edu.MainService;
import com.skryl.edu.SiteService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import javax.inject.Inject;
import java.lang.reflect.Field;

/**
 * @author Skryl D.V. on 2022-05-27
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class SiteServiceInjector implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext extensionContext) throws Exception {
        Field[] fields = testInstance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Inject.class) &&
                    field.getType().isAssignableFrom(SiteService.class)) {
                field.setAccessible(true);
                field.set(testInstance, new MainService());

            }
        }
    }
}
