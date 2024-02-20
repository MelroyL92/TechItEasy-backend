package nl.novi.opdrachttechiteasy.controllers;
import nl.novi.opdrachttechiteasy.dtos.TelevisionDto;
import nl.novi.opdrachttechiteasy.mappers.TelevisionMapper;
import nl.novi.opdrachttechiteasy.models.Television;
import nl.novi.opdrachttechiteasy.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/televisions")
@RestController
public class TelevisionController {

    private final TelevisionService televisionService;
    private final TelevisionMapper televisionMapper;

    public TelevisionController(TelevisionService televisionService, TelevisionMapper televisionMapper) {
        this.televisionService = televisionService;
        this.televisionMapper = televisionMapper;
    }


    @GetMapping()
    public ResponseEntity<List<TelevisionDto>> television(){
        List<Television>television = televisionService.getTelevisions();
        return ResponseEntity.ok(televisionMapper.toTelevisionDto(television));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> television(@PathVariable Long id){
        Television television = televisionService.getTelevision(id);
        return ResponseEntity.ok(televisionMapper.toTelevisionDto(television));
    }

    @PostMapping("")
    public ResponseEntity<Void> addTelevisions(@RequestBody Television television){
        televisionService.saveTelevision(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putTelevisions(@PathVariable Long id, @RequestBody Television television){
        televisionService.updateTelevision(id, television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisions(@PathVariable Long id){
        televisionService.removeTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
