package com.henghai.productmanagement.api.image;

import com.henghai.productmanagement.api.image.web.ImageDto;
import org.mapstruct.Mapper;

import java.awt.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapStruct {
    List<ImageDto> toListDto(List<Images> images);
}
