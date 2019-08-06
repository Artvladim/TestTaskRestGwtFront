package netcracker.homework.testTask.repository;

import netcracker.homework.testTask.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //класс который ходит в базу данных
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
    //some methods
}
