package io.pivotal.demos.directoryui;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="directory")
public class DirectoryProperties {

    private String serviceUri;
    private String findByEmail;

}
