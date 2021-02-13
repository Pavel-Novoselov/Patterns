package geek.arch1;

import geek.arch1.entities.Product;
import geek.arch1.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.jdbc.datasource.ConnectionProxy;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

@SpringBootApplication
public class Arch1Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Arch1Application.class, args);

		final ProductMapper productMapper = new ProductMapper();

		Product product = productMapper.findById(1L);
		System.out.println(product);
		int insert = productMapper.insert(new Product(5L, "NewProduct", "Super", new BigDecimal(1000.0)));
		System.out.println("Insert=" + insert);
		int update = productMapper.update(new Product(1L, "1NewProduct", "1Super", new BigDecimal(1.0)));
		System.out.println("Update="+ update);
		int delete = productMapper.delete(1);
		System.out.println("Delete="+ delete);
		product = productMapper.findById(5L);
	}
}
