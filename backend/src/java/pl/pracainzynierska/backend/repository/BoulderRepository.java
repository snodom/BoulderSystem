package pl.pracainzynierska.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pracainzynierska.backend.model.Boulder;

import java.util.List;

@Repository
public interface BoulderRepository extends JpaRepository<Boulder, Long> {

    Boulder findBoulderByIdBoulder(Long idBoulder);
    List<Boulder> findAll();
}
