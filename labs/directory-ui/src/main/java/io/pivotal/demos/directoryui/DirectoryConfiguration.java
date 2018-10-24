package io.pivotal.demos.directoryui;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(DirectoryProperties.class)
@Configuration
public class DirectoryConfiguration {
}
