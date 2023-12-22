package co.istad.demo.api.order.web;

import co.istad.demo.api.order.Order;
import co.istad.demo.api.order.OrderService;
import co.istad.demo.api.product.web.ProductController;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<?> orderAll() {
        List<Order> orders = orderService.getAll();

        for (Order order: orders) {
            order.add(linkTo(methodOn(OrderController.class).orderAll()).withRel(IanaLinkRelations.SELF));
            order.add(linkTo(methodOn(ProductController.class).productAll()).withRel(IanaLinkRelations.ITEM));
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> orderGetById(@PathVariable("id") Long id) {
        Order order = orderService.getById(id);
        order.add(linkTo(methodOn(OrderController.class).orderGetById(order.getId())).withRel(IanaLinkRelations.SELF));
        order.add(linkTo(methodOn(OrderController.class).orderAll()).withRel("orderAll"));

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
