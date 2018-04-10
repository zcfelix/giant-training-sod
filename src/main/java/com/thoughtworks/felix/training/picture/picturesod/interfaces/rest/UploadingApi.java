package com.thoughtworks.felix.training.picture.picturesod.interfaces.rest;

import com.thoughtworks.felix.training.picture.picturesod.Routes;
import com.thoughtworks.felix.training.picture.picturesod.domain.*;
import com.thoughtworks.felix.training.picture.picturesod.interfaces.rest.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.thoughtworks.felix.training.picture.picturesod.domain.UploadingConstant.UPLOAD_FOLDER;

@RestController
@RequestMapping("/uploading")
public class UploadingApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadingApi.class);

    @Autowired
    UploadingPathRepository uploadingPathRepository;

    @Autowired
    UploadingRepository uploadingRepository;

    @Autowired
    ImageService service;

    @PostMapping
    public ResponseEntity uploadImage(@RequestParam("file") MultipartFile file,
                                      @RequestParam(value = "group_id", required = false) Long groupId) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        final String filePath = UPLOAD_FOLDER + file.getOriginalFilename();
        final Uploading uploading = new Uploading(filePath, groupId);

        uploadingRepository.saveUploading(file);
        uploadingPathRepository.save(uploading);

        return ResponseEntity.created(Routes.uploadingURI(uploading)).build();
    }

    @PostMapping("/{id}/approval")
    public ResponseEntity approval(@PathVariable("id") Long id) {
        final Optional<Uploading> optionalUploading = uploadingPathRepository.findById(id);
        if (!optionalUploading.isPresent()) {
            throw new NotFoundException(new ErrorDTO("404", "uploading not found"));
        }

        final Uploading uploading = optionalUploading.get();
        uploading.addApproval();
        uploadingPathRepository.save(uploading);
        return ResponseEntity.created(Routes.approvalURI(uploading)).build();
    }
}
