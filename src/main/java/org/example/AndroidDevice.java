package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.example.config.AppConfig;

@Getter
@AllArgsConstructor
public enum AndroidDevice {
    PIXEL_FOLD_API_32("Pixel Fold API 32", "12.0", "4725", ""),
    PIXEL_8_PRO_API_30("Pixel Fold API 32", "11.0", "4724", ""),
    DEVICE_TEST_API_34("Device test API 34", "14.0", "4723", "");

    final String deviceName;
    final String androidVersion;
    final String port;
    final String URL;

    public String getURL() {
        return ConfigFactory.create(AppConfig.class).baseURLWithParam(port);
    }
}
