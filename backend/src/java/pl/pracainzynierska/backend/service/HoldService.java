package pl.pracainzynierska.backend.service;

import pl.pracainzynierska.backend.model.DTO.HoldDto;
import pl.pracainzynierska.backend.model.Hold;

import java.util.List;
import java.util.Set;

public interface HoldService {

    void createHoldWall(Integer x, Integer y);
    Long getHoldIdByXY(int x, int y);
    Set<Hold> getHoldsFromXandYHoldsDtos(List<HoldDto> holdsDtos);
    Hold getHoldById(Long idHold);
    List<HoldDto> getHoldsForBoulderByIdBoulder(Long idBoulder);
    Set<Hold> holdFromString(String holdXYString);
}
