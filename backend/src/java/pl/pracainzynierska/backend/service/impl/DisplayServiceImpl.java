package pl.pracainzynierska.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pracainzynierska.backend.model.Display;
import pl.pracainzynierska.backend.repository.BoulderRepository;
import pl.pracainzynierska.backend.repository.DisplayRepository;
import pl.pracainzynierska.backend.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {

    @Autowired
    public DisplayRepository displayRepository;


    @Override
    public void addNewDisplay(Long idBoulder) {

        Display display = new Display();
        display.setIdBoulder(idBoulder); 
        displayRepository.save(display);
    }
}
