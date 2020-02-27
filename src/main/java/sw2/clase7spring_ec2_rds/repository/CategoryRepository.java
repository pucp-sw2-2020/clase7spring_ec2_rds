package sw2.clase7spring_ec2_rds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw2.clase7spring_ec2_rds.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

