package geek.arch1.mappers;

import geek.arch1.entities.Product;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

@Component
public class ProductMapper {

    public ProductMapper() {
    }

    private Connection connect() throws SQLException {

        return getConnection("jdbc:h2:mem:mydatabase", "sa", "");
    }

    public Product findById(final int productId) throws SQLException {
        final Connection connection = connect();
        final PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM products WHERE id = ?");
        statement.setInt(1, productId);
        try (final ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                final Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setTitle(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setPrice(resultSet.getBigDecimal(4));
                return product;
            }
        }

        throw new SQLException(String.valueOf(productId));
    }

    public int insert(final Product product) throws SQLException {
        final int result;
        final Connection connection = connect();
        final PreparedStatement statement = connection.prepareStatement(
                "insert into products " +
                "(id, title, description, price) values " +
                "(?,?,?,?)");
        statement.setLong(1, product.getId());
        statement.setString(2, product.getTitle());
        statement.setString(3, product.getDescription());
        statement.setBigDecimal(4, product.getPrice());
        result = statement.executeUpdate();
        return result;
    }

    public int update(final Product product) throws SQLException {
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
        return result;
    }

    public int delete(int id) throws SQLException {
        final int result;
        final Connection connection = connect();
        final PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM products " +
                "WHERE id = ?");
        statement.setLong(1, id);
        result = statement.executeUpdate();
        return result;
    }

}
