package lv.kalashnikov.insurance.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lv.kalashnikov.insurance.core")
public class SpringCoreConfig {
}