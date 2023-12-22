package com.henghai.productmanagement.api.image;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImageMapper {

    @SelectProvider(type = ImageProvider.class,method = "buildSelectSql")
    @Results(id = "id",value = {
            @Result(column = "image_url",property = "imageUrl")
    })
    List<Images> SelectAll();
}
