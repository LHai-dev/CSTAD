package com.example.spring4mbankingapisasu.file.web;

import lombok.Builder;
@Builder
public record FileDto(String name,
                      String extension,
                      String download,
                      Long size,
                      String url) {
}
