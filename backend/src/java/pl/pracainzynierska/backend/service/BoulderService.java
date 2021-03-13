
package pl.pracainzynierska.backend.service;

import pl.pracainzynierska.backend.model.Boulder;
import pl.pracainzynierska.backend.model.DTO.BoulderDto;
import pl.pracainzynierska.backend.model.Hold;

import java.util.List;
import java.util.Set;

public interface BoulderService {


    void deleteBoulder(Long idBoulder);
    void deleteAllBoulders();
    void createBoulder(String name, int grade, String author, Set<Hold> holds);
    List<BoulderDto> getAllBoulders();
    List<Boulder> getBoulderFromName(String name);
    List<Boulder> getBouldersFromGradeBetween(Integer grade1, Integer grade2);
    Boulder getBoulderByIdBoulder(Long idBoulder);
}
