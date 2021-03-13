package pl.pracainzynierska.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pracainzynierska.backend.model.Hold;

import java.util.List;

@Repository
public interface HoldRepository extends JpaRepository<Hold, Long> {

    Hold findByIdHold(Long idHold);
    List<Hold> findHoldsByBoulders_IdBoulder(Long idBoulder);
    Hold findHoldByXAndY(Integer x, Integer y);
}






