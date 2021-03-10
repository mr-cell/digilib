package mr.cell.digilib.uploaderservice.storage;

import org.springframework.core.io.Resource;

public interface StorageService {
    String uploadFile(String originalFilename, String contentType, long size, Resource resource);
}
