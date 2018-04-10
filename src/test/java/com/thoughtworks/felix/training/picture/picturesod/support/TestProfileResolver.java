package com.thoughtworks.felix.training.picture.picturesod.support;

import org.springframework.test.context.ActiveProfilesResolver;

public class TestProfileResolver implements ActiveProfilesResolver {
    @Override
    public String[] resolve(Class<?> aClass) {
        return new String[]{"dev"};
    }
}
