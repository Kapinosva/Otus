package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:ServerConfig.properties")
public interface ServerConfig extends org.aeonbits.owner.Config {
    @DefaultValue("Chrome")
    @Key("browser")
    String browser();
}
