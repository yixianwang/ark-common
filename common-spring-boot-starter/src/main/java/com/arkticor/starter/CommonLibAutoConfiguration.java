package com.arkticor.starter.config;

import com.arkticor.core.CommonService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(CommonService.class)
@EnableConfigurationProperties(CommonLibProperties.class)
public class CommonLibAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean // Allows the app to override this bean if they want
    @ConditionalOnProperty(prefix = "common.lib", name = "enabled", havingValue = "true", matchIfMissing = true)
    public CommonService commonService(CommonLibProperties properties) {
        return new CommonService();
    }
}