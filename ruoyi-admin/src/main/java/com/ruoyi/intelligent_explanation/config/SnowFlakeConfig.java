package com.ruoyi.intelligent_explanation.config;

import com.ruoyi.intelligent_explanation.utils.SnowFlakeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowFlakeConfig {
    @Bean
    public SnowFlakeUtils snowFlakeUtils(){
     return   new SnowFlakeUtils(0, 0);
    }
}
