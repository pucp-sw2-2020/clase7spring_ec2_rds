package sw2.clase7spring_ec2_rds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw2.clase7spring_ec2_rds.entity.Category;
import sw2.clase7spring_ec2_rds.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByCategory(Category category);
}

