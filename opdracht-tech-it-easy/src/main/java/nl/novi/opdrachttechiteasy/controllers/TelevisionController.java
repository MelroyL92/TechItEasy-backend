package nl.novi.opdrachttechiteasy.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/televisions")
@RestController
public class TelevisionController {


    @GetMapping()
    public ResponseEntity<String> television(){
        return ResponseEntity.ok("television");
    }

    @GetMapping("/type")
    public ResponseEntity<String> television(@RequestParam String type){
        return ResponseEntity.ok("Television " + type);
    }

    @PostMapping("")
    public ResponseEntity<String> addTelevisions(@RequestBody String television){
        System.out.println(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("")
    public ResponseEntity<String> putTelevisions(@RequestBody String television){
        System.out.println(television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteTelevisions(@RequestBody String television){
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