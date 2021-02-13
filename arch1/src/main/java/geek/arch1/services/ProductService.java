package geek.arch1.services;

import geek.arch1.entities.Product;
import geek.arch1.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public Product getById(final Long id){
             return productMapper.findById(id);
    }

    public Product save(final Product product){
        return productMapper.insert(product);
    }

}
