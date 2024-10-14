package com.example.projetoesports.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class ConvertUtils {

    private static final List<String> ACCEPTED_FORMATS = Arrays.asList("jpg", "png", "tiff", "bmp");

    public static String convertImageToBase64(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File must not be null or empty");
        }

        String formatFile = file.getOriginalFilename().split("\\.")[1];
        if (!ACCEPTED_FORMATS.contains(formatFile)) {
            throw new IllegalArgumentException("Invalid file format. Accepted formats are " + ACCEPTED_FORMATS);
        }

        try {
            byte[] fileBytes = file.getBytes();
            String dataPrefix = "data:image/" + formatFile + ";base64,";
            String encodedString = Base64.getEncoder().encodeToString(fileBytes);
            return dataPrefix + encodedString;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file content", e);
        }
    }
}
