package co.istad.mvcap.dao;
import co.istad.mvcap.dto.CreateProductDto;
import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.dto.UpdateProductDto;

import java.util.*;
import java.util.UUID;

// done
public interface ProductDao {
     List<ProductDto> select();
     ProductDto insert(CreateProductDto createProductDto);
     void removeById(UUID uuidRemove);
     void updateProductById(UUID uuidUpdate, UpdateProductDto updateProduct);
}

