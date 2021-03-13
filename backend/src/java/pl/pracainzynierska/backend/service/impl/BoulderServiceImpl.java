package pl.pracainzynierska.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pracainzynierska.backend.model.Boulder;
import pl.pracainzynierska.backend.model.DTO.BoulderDto;
import pl.pracainzynierska.backend.model.Hold;
import pl.pracainzynierska.backend.repository.BoulderRepository;
import pl.pracainzynierska.backend.service.BoulderService;
import pl.pracainzynierska.backend.service.HoldService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BoulderServiceImpl implements BoulderService {

    @Autowired
    public BoulderRepository boulderRepository;

    @Autowired
    public HoldServiceImpl holdService;


    @Override
    public void createBoulder(String name, int grade, String author, Set<Hold> holds){

        Boulder boulder = new Boulder();

        boulder.setName(name);
        boulder.setGrade(grade);
        boulder.setAuthor(author);
        boulder.setHolds(holds);
        boulderRepository.save(boulder);
    }

    @Override
    public void deleteBoulder(Long idBoulder) {
        boulderRepository.deleteById(idBoulder);
    }

    @Override
    public void deleteAllBoulders() {
        boulderRepository.deleteAll();
    }

    @Override
    public List<BoulderDto> getAllBoulders() {

        List<Boulder> boulderList = boulderRepository.findAll();
        List<BoulderDto> boulderDtoList = new ArrayList<>();

        for (Boulder boulder : boulderList) {
            BoulderDto boulderDto = new BoulderDto();
            boulderDto.setHoldDtoList(holdService.getHoldsForBoulderByIdBoulder(boulder.getIdBoulder()));
            boulderDto.setAuthor(boulder.getAuthor());
            boulderDto.setName(boulder.getName());
            boulderDto.setGrade(boulder.getGrade());
            boulderDto.setiD(boulder.getIdBoulder());
            boulderDtoList.add(boulderDto);
        }

        return boulderDtoList;
    }


    @Override
    public List <Boulder> getBoulderFromName(String name) {

        List<Boulder> boulderList =boulderRepository.findAll();

        return boulderList.stream()
                .filter(boulder -> Objects.equals(boulder.getName(), name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Boulder> getBouldersFromGradeBetween(Integer grade1, Integer grade2) {

        List<Boulder> boulderList = boulderRepository.findAll();
        List<Boulder> boulders = new ArrayList<>();

        if(grade1 == null){
            grade1 =0;
        }

        if(grade2 == null){
            grade2 =20;
        }
        if(grade1<grade2){
            for (Boulder boulder : boulderList) {
                if (boulder.getGrade() >= grade1 & boulder.getGrade() >= grade2) {
                    boulders.add(boulder);
                }
            }
        }
        return boulders;
    }

    @Override
    public Boulder getBoulderByIdBoulder(Long idBoulder) {
        return boulderRepository.findBoulderByIdBoulder(idBoulder);
    }
}
