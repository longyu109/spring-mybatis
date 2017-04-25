package com.linkstec.mybatis.conf;

/**
 * Created by sh on 2017/4/25.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hystrix")
public class HyStrixProperties {
    private int timeoutInMillions;
}
