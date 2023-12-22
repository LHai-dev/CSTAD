package co.istad.demo.api.order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getById(Long id);
}
