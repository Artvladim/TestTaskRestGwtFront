package netcracker.homework.testTask.repository;

import netcracker.homework.testTask.dao.ClientDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientDao, Long>, Serializable {
    List<ClientDao> findByName(String name);
    List<ClientDao> findByAge(Integer age);

    void delete(Integer id);
}
