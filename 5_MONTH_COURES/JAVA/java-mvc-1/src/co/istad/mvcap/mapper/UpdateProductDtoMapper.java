package co.istad.mvcap.mapper;

import co.istad.mvcap.dto.UpdateProductDto;
import co.istad.mvcap.model.Product;

import java.util.function.Function;

public class UpdateProductDtoMapper implements Function<UpdateProductDto , Product> {
    @Override
    public Product apply(UpdateProductDto updateProductDto) {
        return new Product(
                updateProductDto.name(),
                updateProductDto.priceIn()
        );
    }
}
