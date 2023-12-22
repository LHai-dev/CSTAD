package com.henghai.productmanagement.api.image;

import com.henghai.productmanagement.api.image.web.ImageDto;

import java.util.List;

public interface ImageService {
    List<ImageDto> getAll();
}
