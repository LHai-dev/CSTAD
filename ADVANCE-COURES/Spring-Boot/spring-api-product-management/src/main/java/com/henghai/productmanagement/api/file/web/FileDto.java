package com.henghai.productmanagement.api.file.web;

import lombok.Builder;

@Builder
public record FileDto(
        String extension,
        String name,
        Long size,
        String url,
        String downloadUrl
) {
}
