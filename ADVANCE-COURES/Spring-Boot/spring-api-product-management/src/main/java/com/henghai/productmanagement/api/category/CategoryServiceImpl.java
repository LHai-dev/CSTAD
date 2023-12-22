package com.henghai.productmanagement.api.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private  final CategoryMapper categoryMapper;
    @Override
    public List<Categories> findAll() {
      List<Categories> categories = categoryMapper.selectAll();
      return categories;
    }
}
