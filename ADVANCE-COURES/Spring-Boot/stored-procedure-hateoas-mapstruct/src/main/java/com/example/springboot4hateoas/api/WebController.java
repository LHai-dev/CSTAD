package com.example.springboot4hateoas.api;

import com.example.springboot4hateoas.api.order.Order;
import com.example.springboot4hateoas.api.order.OrderDto;
import com.example.springboot4hateoas.api.order.OrderModelAssembler;
import com.example.springboot4hateoas.api.order.OrderRepository;
import com.example.springboot4hateoas.api.product.Product;
import com.example.springboot4hateoas.api.product.ProductDto;
import com.example.springboot4hateoas.api.product.ProductDtoAssembler;
import com.example.springboot4hateoas.api.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class WebController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderModelAssembler orderModelAssembler;

    private final ProductDtoAssembler productDtoAssembler;

    @GetMapping("/api/orders")
    public ResponseEntity<CollectionModel<OrderDto>> getAllOrder()
    {
        List<Order> actorEntities = orderRepository.findAll();
        CollectionModel<OrderDto> order = orderModelAssembler.toCollectionModel(actorEntities);
        order.add(linkTo(methodOn(WebController.class).getAllProduct()).withRel(IanaLinkRelations.ITEM));
        return new ResponseEntity<>(
                order,
                HttpStatus.OK);
    }
    @GetMapping("/api/orders/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long id)
    {
        return orderRepository.findById(id)
                .map(orderModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/api/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id)
    {
        return productRepository.findById(id)
                .map(productDtoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/products")
    public ResponseEntity<CollectionModel<ProductDto>> getAllProduct()
    {
        List<Product> productList = productRepository.findAll();
        CollectionModel<ProductDto> product = productDtoAssembler.toCollectionModel(productList);
        return new ResponseEntity<>(
                product,
                HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Optional<?>> getAllProductSimple()
    {
        Optional<Product>  product  = productRepository.findAllProduct();
        return new ResponseEntity<>(
                product,
                HttpStatus.OK);
    }
}
