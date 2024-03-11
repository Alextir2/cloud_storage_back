package alex.tir.cloud_storage_back.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@Getter
@Setter
public class FilesProperties {

    String baseFolder;
    Long baseLimit;
    String fileTokenSecret;
    Long fileTokenValidity;

}
