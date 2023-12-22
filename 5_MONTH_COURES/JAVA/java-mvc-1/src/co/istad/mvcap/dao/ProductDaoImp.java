package co.istad.mvcap.dao;
import co.istad.mvcap.datasource.StaticDataSource;
import co.istad.mvcap.dto.CreateProductDto;
import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.dto.UpdateProductDto;
import co.istad.mvcap.mapper.CreateProductDtoMapper;
import co.istad.mvcap.mapper.UpdateProductDtoMapper;
import co.istad.mvcap.model.Product;

import java.util.*;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductDaoImp implements ProductDao{
    private final StaticDataSource staticDataSource;
    private final CreateProductDtoMapper createProductDtoMapper;
    private final ProductDtoToMap productDtoMapper;
    private final UpdateProductDtoMapper productUpdateDtoMapper;
    public ProductDaoImp() {
        this.productDtoMapper = new ProductDtoToMap();
        this.createProductDtoMapper = new CreateProductDtoMapper();
        this.staticDataSource =new StaticDataSource();
        this.productUpdateDtoMapper=new UpdateProductDtoMapper();
    }
    @Override
    public List<ProductDto> select() {
        return  staticDataSource.getProductList().
                stream().map(productDtoMapper::apply).
                collect(Collectors.toList());
    }
    @Override
    public ProductDto insert(CreateProductDto createProductDto) {
        Product productForInsert = createProductDtoMapper.apply(createProductDto);
        staticDataSource.getProductList().add(productForInsert);
        return productDtoMapper.apply(productForInsert);
    }
    @Override
    public void removeById(UUID uuidRemove) {
        staticDataSource.setProductList(
                staticDataSource.getProductList().
                stream().
                filter(product -> !product.getId().equals(uuidRemove)).
                        collect(Collectors.toList()));
    }
    @Override
    public void updateProductById(UUID uuidUpdate, UpdateProductDto updateProduct) {

        Product productUpdate=productUpdateDtoMapper.apply(updateProduct);
        staticDataSource.getProductList().stream().map(
                product -> {
                    if(product.getId().equals(uuidUpdate)){
                        product.setName(updateProduct.name());
                        product.setPriceIn(updateProduct.priceIn());
                    }
                    return product;
                }
        ).collect(Collectors.toList());
    }


}
