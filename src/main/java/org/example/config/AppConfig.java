package org.example.config;

import org.aeonbits.owner.Config;

public interface AppConfig extends Config {

    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    @Key("baseURL")
    String baseURL();

    @DefaultValue("http://127.0.0.1:{port}/wd/hub")
    @Key("baseURL")
    String baseURLWithParam(String port);

    @DefaultValue("apk/android.wdio.native.app.v1.0.8.apk")
    @Key("pathToApk")
    String pathToApk();
}