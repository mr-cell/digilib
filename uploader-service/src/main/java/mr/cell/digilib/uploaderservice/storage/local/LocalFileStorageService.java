package mr.cell.digilib.uploaderservice.storage.local;

import mr.cell.digilib.uploaderservice.storage.StorageService;
import mr.cell.digilib.uploaderservice.storage.StorageServiceException;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LocalFileStorageService implements StorageService {

    @Override
    public String uploadFile(String originalFilename, String contentType, long size, Resource resource) {
        final String destinationFileName = originalFilename + "-" + System.currentTimeMillis();
        final Path destination = Path.of("/tmp", destinationFileName).toAbsolutePath();
        try (var is = resource.getInputStream()) {
            Files.copy(is, destination);
            return destination.toString();
        } catch (final IOException ex) {
            throw new StorageServiceException("Could not copy file to " + destination.toString(), ex);
        }
    }
}
