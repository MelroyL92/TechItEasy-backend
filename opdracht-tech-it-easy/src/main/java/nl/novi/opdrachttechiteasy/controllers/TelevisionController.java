package nl.novi.opdrachttechiteasy.controllers;
import nl.novi.opdrachttechiteasy.dtos.TelevisionInputDto;
import nl.novi.opdrachttechiteasy.dtos.TelevisionResponseDto;
import nl.novi.opdrachttechiteasy.mappers.TelevisionMapper;
import nl.novi.opdrachttechiteasy.models.Television;
import nl.novi.opdrachttechiteasy.service.TelevisionService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<TelevisionResponseDto>> television(){
        List<Television>television = televisionService.getTelevisions();
        return ResponseEntity.ok(televisionMapper.toTelevisionDtos(television));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> television(@PathVariable Long id){
        Television specificTelevision = televisionService.getTelevision(id);
        return ResponseEntity.ok(televisionMapper.toTelevisionDto(specificTelevision));
    }

    @PostMapping("")
    public ResponseEntity<TelevisionResponseDto> createTelevision(@RequestBody TelevisionInputDto television){
        Television savedTelevision = televisionService.saveTelevision(televisionMapper.createTelevision(television));
        return ResponseEntity.status(HttpStatus.CREATED).body(televisionMapper.toTelevisionDto(savedTelevision));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putTelevisions(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto){
        Television television = televisionMapper.createTelevision(televisionInputDto);
        televisionService.updateTelevision(id, television);
        return ResponseEntity.noContent().build();
    }

    // niet af, van alles geprobeerd, maar ik krijg de ID maar niet terug, waarde blijft Null;
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteTelevision(@RequestBody TelevisionResponseDto televisionResponseDto) {
//        Television television = televisionMapper.toTelevisionDtos(television);
//        System.out.println(television.getType());
//        long id = television.getId();
//        System.out.println("Deleting television with ID: " + id);
//        televisionService.removeTelevision(id);
//        return ResponseEntity.noContent().build();
//    }
}
