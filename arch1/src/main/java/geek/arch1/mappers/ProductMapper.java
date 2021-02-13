package geek.arch1.mappers;

import geek.arch1.entities.Product;
import geek.arch1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;

@Component
public class ProductMapper {
    @Autowired
    private final ProductRepository productRepository;
    private final Map<Long, Product> map;

    public ProductMapper(final ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.map = new HashMap<>();
    }

    private Connection connect() throws SQLException {
        return getConnection("jdbc:h2:mem:mydatabase", "sa", "");
    }

    public Product findById(final long productId){
        if (map.containsKey(productId)) {
            return map.get(productId);
        }
        final Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    public Product insert(final Product product){

        final Product  savedPropduct = productRepository.save(product);
        if (savedPropduct != null){
            map.put(product.getId(), product);
            return savedPropduct;
        } else{
            return null;
        }

    }

        public int update ( final Product product) throws SQLException {
            final int result;
            final Connection connection = connect();
            final PreparedStatement statement = connection.prepareStatement(
                    "UPDATE products " +
                    "SET title = ?, description = ?, price = ? WHERE " +
                    "id = ?");
            statement.setLong(4, product.getId());
            statement.setString(1, product.getTitle());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            result = statement.executeUpdate();
            if (result == 1) {
                map.put(product.getId(), product);
            }
            return result;
        }

        public int delete (final long id) throws SQLException {
            final int result;
            final Connection connection = connect();
            final PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM products " +
                    "WHERE id = ?");
            statement.setLong(1, id);
            result = statement.executeUpdate();
            if (result == 1) {
                map.remove(id);
            }
            return result;
        }

    }
