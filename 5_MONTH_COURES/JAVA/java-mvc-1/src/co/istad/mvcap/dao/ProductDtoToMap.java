package co.istad.mvcap.dao;

import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.model.Product;
import java.util.function.Function;
//done
public class ProductDtoToMap implements Function<Product, ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(product.getCode(), product.getName());
    }
}
