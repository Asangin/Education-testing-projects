package com.skryl.edu.configs;

import org.aeonbits.owner.Config;

/**
 * @author Skryl D.V. on 2022-05-21
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:separate-configs/${environment}.properties",
        "classpath:separate-configs/dev.properties"
})
public interface DemonstrateConfig extends Config {
    @Key("base.url") // if no default value, null will return
    String baseUrl();

    @DefaultValue("111") // if we don't provide default values, NPE will be raise
    int port();
}
