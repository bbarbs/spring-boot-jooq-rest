package com.jooq.core.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Profile("prod")
public class ProdWebMvcConfig extends WebMvcConfigurerAdapter {
}
