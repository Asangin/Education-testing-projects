package com.skryl.edu.configs;

import org.aeonbits.owner.Config;

/**
 * @author Skryl D.V. on 2022-05-21
 * Copyright © 2022 Perenio. All rights reserved.
 */
public interface FirstLoadPolicyConfig extends Config {
    @Key("base.url") // if no default value, null will return
    String baseUrl();

    @DefaultValue("80") // if we don't provide default values, NPE will be raise
    int port();
}
