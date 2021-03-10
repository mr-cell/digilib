package mr.cell.digilib.uploaderservice;

import mr.cell.digilib.uploaderservice.storage.StorageService;
import mr.cell.digilib.uploaderservice.storage.local.LocalFileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploaderServiceConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(UploaderServiceConfiguration.class);

    @Bean
    @ConditionalOnProperty(name = "app.image.storage", havingValue = "local")
    public StorageService localFileStorageService() {
        LOG.info("Using {} as implementation of {}", LocalFileStorageService.class.getSimpleName(),
                StorageService.class.getSimpleName());
        return new LocalFileStorageService();
    }
}
