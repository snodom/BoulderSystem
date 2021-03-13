package pl.pracainzynierska.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pracainzynierska.backend.model.Display;

@Repository
public interface DisplayRepository extends JpaRepository<Display, Long> {

}
