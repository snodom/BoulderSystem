package pl.pracainzynierska.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pracainzynierska.backend.model.Boulder;
import pl.pracainzynierska.backend.model.DTO.BoulderDto;
import pl.pracainzynierska.backend.model.DTO.HoldDto;
import pl.pracainzynierska.backend.model.Hold;
import pl.pracainzynierska.backend.service.BoulderService;
import pl.pracainzynierska.backend.service.DisplayService;
import pl.pracainzynierska.backend.service.HoldService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BoulderService boulderService;

    @Autowired
    private HoldService holdService;

    @Autowired
    private DisplayService displayService;


    //***** tworzenie boulderu

    @PostMapping("boulder/addBoulder")
    public ResponseEntity<String> addBoulder(@Valid @RequestBody @RequestParam("boulder") String name, @RequestParam("grade") int grade,@RequestParam("author") String author, @RequestParam("xYString") String xYString){
        try{
            boulderService.createBoulder(name,grade,author,holdService.holdFromString(xYString));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nie udalo sie dodać boulderu, bad request");
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //***** usuwanie boulderu

    @PostMapping("boulder/deleteBoulder")
    public ResponseEntity<String> deleteBoulderByIdBoulder(@Valid @RequestBody @RequestParam("idBoulder") Long idBoulder){
        try{
            boulderService.deleteBoulder(idBoulder);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nie udalo sie usunac boulderu o id: "+ idBoulder);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("boulder/displayBoulder")
    public ResponseEntity<String> displayBoulder(@Valid @RequestBody @RequestParam("idBoulder") Long idBoulder){
        try{
            displayService.addNewDisplay(idBoulder);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nie udalo sie wyswietlic boulderu: "+ idBoulder);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @PostMapping("boulder/deleteAllBoulders")
    public ResponseEntity<String> deleteAllBoulders(@Valid @RequestBody @RequestParam("idBoulder") Long idBoulder){
        try{
            boulderService.deleteAllBoulders();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nie udalo sie usunac wszystkich boulderow");
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    //***** lista chwytów do boulderu

    @RequestMapping(value = "/hold/getHoldForBoulder",method = {RequestMethod.GET,RequestMethod.POST})
    public List<HoldDto> getHoldForBoulder(@Valid @RequestBody @RequestParam("idBoulder") Long idBoulder){
        return holdService.getHoldsForBoulderByIdBoulder(idBoulder);
    }

    //***** tworzenie sciany o odpowiedniej wielkosci

    @PostMapping("hold/createHoldWall")
    public ResponseEntity<String> createHoldWall(@Valid @RequestBody @RequestParam("x") Integer x, @RequestParam("y") Integer y){
        try{
            holdService.createHoldWall(x, y);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nie udalo sie utworzyc sciany chwytow");
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //***** otrzymywanie listy wszystkich boulderów

    @GetMapping("/boulder/getAllBoulders")
    public List<BoulderDto> getAllBoulders(){
        return boulderService.getAllBoulders();
    }

    //***** otrzymyanie listy boulderow w odpowiedniej skali

    @RequestMapping(value = "/boulder/getBouldersFromGradeBetween",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Boulder> getBouldersFromGradeBetween(@Valid @RequestBody @RequestParam("grade1") Integer grade1, @RequestParam("grade2") Integer grade2){
        return boulderService.getBouldersFromGradeBetween(grade1,grade2);
    }


    //***** otrzymywanie listy boulderow o wybranej nazwie

    @RequestMapping(value = "/boulder/getBouldersFromName",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Boulder> getBouldersFromName(@Valid @RequestBody @RequestParam("boulderName") String boulderName){
        return boulderService.getBoulderFromName(boulderName);
    }

}
