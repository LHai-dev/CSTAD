package co.istad.demo.api.product;

import org.springframework.hateoas.CollectionModel;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getById(Long id);
}
