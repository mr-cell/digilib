package mr.cell.digilib.uploaderservice;

import mr.cell.digilib.uploaderservice.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploaderRestController {
    private static final Logger LOG = LoggerFactory.getLogger(UploaderRestController.class);

    private final StorageService storageService;

    public UploaderRestController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public void uploadImage(@RequestParam("image") final MultipartFile image) {
        // file validation
        var fileDestination = storageService.uploadFile(image.getOriginalFilename(), image.getContentType(), image.getSize(),
                image.getResource());
        // some response (job id?)
    }
}
