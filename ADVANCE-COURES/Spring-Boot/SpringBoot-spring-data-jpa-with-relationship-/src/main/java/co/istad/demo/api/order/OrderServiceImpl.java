package co.istad.demo.api.order;

import co.istad.demo.api.order.web.OrderController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Override
    public List<Order> getAll() {
      List<Order>  order =   orderRepository.findAll();
        for (Order order1: order

        ) {

            order1.add(linkTo(methodOn(OrderController.class).orderGetById(order1.getId())).withRel("order_id"));
        }
//        order.add(linkTo(methodOn(OrderController.class).orderGetById(order1.getId())).withRel("order_id"));
        return order;
    }

    @Override
    public Order getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found id :{}"+id));
        return order;
    }
}
