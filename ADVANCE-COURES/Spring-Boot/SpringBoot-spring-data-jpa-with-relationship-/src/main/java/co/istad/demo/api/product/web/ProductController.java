package co.istad.demo.api.product.web;

import co.istad.demo.api.order.Order;
import co.istad.demo.api.order.web.OrderController;
import co.istad.demo.api.product.Product;
import co.istad.demo.api.product.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.nio.file.NoSuchFileException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<?>> productAll() {

        List<Product> products = productService.getAll();
        if (products.equals(null)){
            return ResponseEntity.noContent().build();
        }
        Order order = new Order();
        for (Product product : products) {
            product.add(linkTo(methodOn(ProductController.class).productAll()).withRel(IanaLinkRelations.SELF));
            product.add(linkTo(methodOn(ProductController.class).productGetById(product.getId())).withRel("product_id"));
            product.add(linkTo(methodOn(OrderController.class).orderGetById(order.getId())).withRel("order"));
            product.add(linkTo(methodOn(OrderController.class).orderAll()).withRel("orderAll"));
        }


        return new ResponseEntity<>(products,HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> productGetById(@PathVariable("id") Long id) {


        Product product =  productService.getById(id);

        product.add(linkTo(methodOn(ProductController.class).productGetById(product.getId())).withRel("product_id"));
        product.add(linkTo(ProductController.class).slash(product.getId()).withSelfRel());


        return new ResponseEntity<>(product,HttpStatus.OK);

    }








}
