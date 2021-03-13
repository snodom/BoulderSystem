package pl.pracainzynierska.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pracainzynierska.backend.model.Boulder;
import pl.pracainzynierska.backend.model.DTO.HoldDto;
import pl.pracainzynierska.backend.model.Hold;
import pl.pracainzynierska.backend.repository.HoldRepository;
import pl.pracainzynierska.backend.service.HoldService;

import java.util.*;


@Service
public class HoldServiceImpl implements HoldService {

    @Autowired
    public HoldRepository holdRepository;


    // czy nie trzeba odrazu bedzie dodawac boulderow
    // tworzy sciane i dodaje do bazy danych
    @Override
    public void createHoldWall(Integer x, Integer y) {

        for(int i=0;i<=x;i++) {
            for (int j=0;j<=y;j++) {
                Hold hold = new Hold();
                hold.setX(i);
                hold.setY(j);
                holdRepository.save(hold);
            }
        }
    }

    @Override
    public Long getHoldIdByXY(int x, int y) {
        return holdRepository.findHoldByXAndY(x,y).getIdHold();
    }

    @Override
    public Set<Hold> getHoldsFromXandYHoldsDtos(List<HoldDto> holdDto){

    Set<Hold> holds = new HashSet<>();

        for (HoldDto dto : holdDto) {
            holds.add(getHoldById(getHoldIdByXY(dto.getX(), dto.getY())));
        }
        return holds;
    }


    @Override
    public Hold getHoldById(Long idHold) {
        return holdRepository.findByIdHold(idHold);
    }

    @Override
    public List<HoldDto> getHoldsForBoulderByIdBoulder(Long idBoulder) {

        List<HoldDto> holdDtoList = new ArrayList<>();

        System.out.println(holdRepository.findHoldsByBoulders_IdBoulder(idBoulder).size() );

        System.out.println("holdRepository.findHoldsByBoulders_IdBoulder(idBoulder).size()" );

        for(int i=0; i<holdRepository.findHoldsByBoulders_IdBoulder(idBoulder).size(); i++){
            HoldDto h = new HoldDto(holdRepository.findHoldsByBoulders_IdBoulder(idBoulder).get(i).getX(), holdRepository.findHoldsByBoulders_IdBoulder(idBoulder).get(i).getY());
            holdDtoList.add(h);
        }

        return holdDtoList;
    }

    @Override
    public Set<Hold> holdFromString(String holdXYString) {
        List<Integer> list = new ArrayList<>();


       String[] parts = holdXYString.split("-");


        Set<Hold> holds = new HashSet<>();
        for(int i=0; i<parts.length;){
            holds.add(getHoldById(getHoldIdByXY(Integer.parseInt(parts[i]), Integer.parseInt(parts[i+1]))));

           Long w = getHoldIdByXY(1,1);
            System.out.println(w);
            i+=2;
        }
        return holds;
    }


}
