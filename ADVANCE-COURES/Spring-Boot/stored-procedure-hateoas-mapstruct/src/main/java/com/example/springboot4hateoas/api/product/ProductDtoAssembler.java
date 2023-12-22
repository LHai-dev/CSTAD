package com.example.springboot4hateoas.api.product;

import com.example.springboot4hateoas.api.WebController;
import com.example.springboot4hateoas.api.order.Order;
import com.example.springboot4hateoas.api.order.OrderDto;
import org.assertj.core.api.recursive.assertion.RecursiveAssertionConfiguration;
import org.mapstruct.Mapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
//@Mapper(componentModel = "spring")
public class ProductDtoAssembler extends RepresentationModelAssemblerSupport<Product, ProductDto> {


    public ProductDtoAssembler(Class<?> controllerClass, Class<ProductDto> resourceType) {
        super(controllerClass, resourceType);
    }
    public ProductDtoAssembler() {
        super(WebController.class, ProductDto.class);
    }

    @Override
    public ProductDto toModel(Product entity) {
    ProductDto productDto  = instantiateModel(entity);
    productDto.add(linkTo(methodOn(WebController.class).getProductById(entity.getId())).withSelfRel());
    productDto.add(linkTo(methodOn(WebController.class).getOrderById(entity.getId())).withSelfRel());


    productDto.setColor(entity.getColor());
    productDto.setName(entity.getName());
    productDto.setSize(entity.getSize());
    productDto.setPrice(entity.getPrice());
    productDto.setOrders(entity.getOrders());
//    productDto.setOrders(toOrderDto(entity.orders));

        return productDto;
    }



    @Override
    public CollectionModel<ProductDto> toCollectionModel(Iterable<? extends Product> entities) {

        CollectionModel<ProductDto> actorModels = super.toCollectionModel(entities);

        actorModels.add(linkTo(methodOn(WebController.class).getAllProduct()).withSelfRel());
        actorModels.add(linkTo(methodOn(WebController.class).getAllOrder()).withRel(IanaLinkRelations.ITEM));

        return actorModels;
    }



    private List<OrderDto> toOrderDto(List<Order> orders) {
        if (orders.isEmpty())
            return Collections.emptyList();

        return orders.stream()
                .map(order -> OrderDto.builder()
                        .id(order.getId())
                        .dataDelivered(order.getDataDelivered())
                        .dataReceived(order.getDataReceived())
                        .build()
                        .add(linkTo(
                                methodOn(WebController.class)
                                        .getProductById(order.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());
    }
}




