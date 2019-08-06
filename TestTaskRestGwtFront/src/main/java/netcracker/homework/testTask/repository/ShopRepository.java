package netcracker.homework.testTask.repository;

import netcracker.homework.testTask.dao.ShopDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopDao, Long> {
    //some methods
}

