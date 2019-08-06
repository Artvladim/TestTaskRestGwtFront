package netcracker.homework.testTask.repository;

import netcracker.homework.testTask.dao.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //класс который ходит в базу данных
public interface OrderRepository extends JpaRepository<OrderDao, Long> {
//some methods (find by etc.)
}
