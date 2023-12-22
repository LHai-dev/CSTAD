package co.istad.demo.api.product;

import co.istad.demo.api.order.Order;
import co.istad.demo.api.order.web.OrderController;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Table(name = "products")
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product extends RepresentationModel <Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private String color;
    private String size;

    @OneToMany(mappedBy = "products")
    List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        Order order = new Order();
        order.add(linkTo(methodOn(OrderController.class).orderGetById(order.getId())).withRel("order_id"));
        return orders;
    }
}
