package com.example.springboot4hateoas.api.order;

import com.example.springboot4hateoas.api.WebController;
import com.example.springboot4hateoas.api.product.Product;
import com.example.springboot4hateoas.api.product.ProductDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler extends RepresentationModelAssemblerSupport<Order,OrderDto> {

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     *
     * @param controllerClass must not be {@literal null}.
     * @param resourceType    must not be {@literal null}.
     */
    public OrderModelAssembler(Class<?> controllerClass, Class<OrderDto> resourceType) {
        super(controllerClass, resourceType);
    }
    public OrderModelAssembler() {
        super(WebController.class, OrderDto.class);
    }

    @Override
    public OrderDto toModel(Order entity) {
        OrderDto orderDto =  instantiateModel(entity);
        orderDto.add(linkTo(methodOn(WebController.class).getOrderById(entity.getId())).withRel("order_by_id"));
        orderDto.add(linkTo(methodOn(WebController.class).getAllOrder()).withRel(IanaLinkRelations.SELF));

        orderDto.setId(entity.getId());
        orderDto.setDataDelivered(entity.getDataReceived());
        orderDto.setDataReceived(entity.getDataReceived());
        return orderDto;
    }

    @Override
    public CollectionModel<OrderDto> toCollectionModel(Iterable<? extends Order> entities) {

//        CollectionModel<OrderDto> actorModels = super.toCollectionModel(entities);
//
//        actorModels.add(linkTo(methodOn(WebController.class).getAllProduct()).withRel(IanaLinkRelations.ORIGINAL));

        return super.toCollectionModel(entities);
    }

    private List<ProductDto> toProductDto(List<Product> products) {
        if (products.isEmpty())
            return Collections.emptyList();

        return products.stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .price(product.getPrice())
                        .color(product.getColor())
                        .name(product.getName())
                        .build()
                        .add(linkTo(
                                methodOn(WebController.class)
                                        .getProductById(product.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());
    }

}
