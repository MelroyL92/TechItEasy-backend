package nl.novi.opdrachttechiteasy.controllers;
import nl.novi.opdrachttechiteasy.models.Television;
import nl.novi.opdrachttechiteasy.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/televisions")
@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping()
    public ResponseEntity<List<Television>> television(){
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> television(@PathVariable Long id){
        Television television = televisionService.getTelevision(id);
        return ResponseEntity.ok(television);
    }

    @PostMapping("")
    public ResponseEntity<Void> addTelevisions(@RequestBody Television television){
        Television television1 = televisionService.saveTelevision(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("")
    public ResponseEntity<String> putTelevisions(@RequestBody String television){
        System.out.println(television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisions(@PathVariable Long id){
        televisionService.removeTelevision(id);
        return ResponseEntity.noContent().build();
    }






}


    //De TelevisionsController bevat:
     //   een GET-request voor alle televisies
       // een GET-request voor 1 televisie
        //een POST-request voor 1 televisie
        //een PUT-request voor 1 televisie
        //een DELETE-request voor 1 televisie