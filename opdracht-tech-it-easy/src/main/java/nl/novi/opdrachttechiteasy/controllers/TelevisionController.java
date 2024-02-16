package nl.novi.opdrachttechiteasy.controllers;


import nl.novi.opdrachttechiteasy.models.Television;
import nl.novi.opdrachttechiteasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/televisions")
@RestController
public class TelevisionController {

    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    @GetMapping()
    public ResponseEntity<List<Television>> television(){
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @GetMapping("/type")
    public ResponseEntity<String> television(@RequestParam String type){
        List<Television> television = televisionRepository.findByType(type);
        return ResponseEntity.ok("Television " + type);
    }

    @PostMapping("")
    public ResponseEntity<Void> addTelevisions(@RequestBody Television television){
        televisionRepository.save(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("")
    public ResponseEntity<String> putTelevisions(@RequestBody String television){
        System.out.println(television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteTelevisions(@RequestBody String television){
        televisionRepository.deleteByBrand(television);
        System.out.println(television);
        return ResponseEntity.noContent().build();
    }






}


    //De TelevisionsController bevat:
     //   een GET-request voor alle televisies
       // een GET-request voor 1 televisie
        //een POST-request voor 1 televisie
        //een PUT-request voor 1 televisie
        //een DELETE-request voor 1 televisie