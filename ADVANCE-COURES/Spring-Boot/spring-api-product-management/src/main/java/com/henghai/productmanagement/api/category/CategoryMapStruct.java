package com.henghai.productmanagement.api.category;

import com.henghai.productmanagement.api.category.web.CategoryCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapStruct {
    Categories toEntity(CategoryCreateDto categoryCreateDto);
    CategoryCreateDto toDto(Categories categories);
}
