package com.thoughtworks.felix.training.picture.picturesod.domain;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@Service
public class ImageService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://localhost:8081/images";

    public boolean saveImage(String path) {
        final HttpEntity<MultiValueMap<String, Object>> requestEntity = generateRequestEntity(path);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, ResponseEntity.class);
        return true;
    }

    private HttpEntity<MultiValueMap<String, Object>> generateRequestEntity(String path) {
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("file", fileAsResource(path));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        return new HttpEntity<>(bodyMap, headers);
    }

    private FileSystemResource fileAsResource(String path) {
        final File file = new File(path);
        return new FileSystemResource(file);
    }
}
