package nl.novi.opdrachttechiteasy.controllers.Television;
import nl.novi.opdrachttechiteasy.dtos.Television.TelevisionInputDto;
import nl.novi.opdrachttechiteasy.dtos.Television.TelevisionResponseDto;
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
    public ResponseEntity<TelevisionInputDto> putTelevisions(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto){
        Television television = televisionMapper.createTelevision(televisionInputDto);
        televisionService.updateTelevision(id, television);
        return ResponseEntity.noContent().build();
    }

//     niet af, van alles geprobeerd, maar ik krijg de ID maar niet terug, waarde blijft Null;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@RequestBody TelevisionResponseDto televisionResponseDto) {
        // Extract the necessary information (e.g., ID) from the DTO
        Long televisionId = televisionResponseDto.getId();
        System.out.println(televisionId);
        System.out.println("Received TelevisionDto object: " + televisionResponseDto.getId());
        System.out.println("Received TelevisionDto object: " + televisionResponseDto.getType());
        System.out.println("Received TelevisionDto object: " + televisionResponseDto.getName());

        return ResponseEntity.noContent().build();
    }
}
