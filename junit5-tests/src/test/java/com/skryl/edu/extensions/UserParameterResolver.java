package com.skryl.edu.extensions;

import com.skryl.edu.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import javax.inject.Inject;

/**
 * @author Skryl D.V. on 2022-05-27
 */
public class UserParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getRequiredTestMethod().isAnnotationPresent(Inject.class) &&
                parameterContext.getParameter().getType().isAssignableFrom(User.class);
    }

    @Override
    public User resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        TestCase testCase = extensionContext.getRequiredTestMethod().getAnnotation(TestCase.class);
        if(testCase == null) {
            throw new ParameterResolutionException("Test case annotation must be on test case method");
        }
        return new User().setAge(10).setName("Skryl");
    }
}
