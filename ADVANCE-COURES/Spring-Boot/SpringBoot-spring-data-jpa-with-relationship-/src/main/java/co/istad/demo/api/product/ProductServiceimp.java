package co.istad.demo.api.product;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceimp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> product = productRepository.findAll();


        return product;
    }

    @Override
    public Product getById(Long id) {
       Product product = productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"id :"+id));
        return product;
    }


}
