package com.henghai.productmanagement.api.image;

import com.henghai.productmanagement.api.image.web.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private final ImageMapper imageMapper;
    private final ImageMapStruct imageMapStruct;
    @Override
    public List<ImageDto> getAll() {
        List<Images> image = imageMapper.SelectAll();
        return imageMapStruct.toListDto(image);
    }
}
