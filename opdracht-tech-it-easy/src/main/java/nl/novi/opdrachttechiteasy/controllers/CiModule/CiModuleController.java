package nl.novi.opdrachttechiteasy.controllers.CiModule;

import nl.novi.opdrachttechiteasy.dtos.CiModule.CiModuleInputDto;
import nl.novi.opdrachttechiteasy.dtos.CiModule.CiModuleResponseDto;
import nl.novi.opdrachttechiteasy.mappers.CiModuleMapper;
import nl.novi.opdrachttechiteasy.models.CiModule;
import nl.novi.opdrachttechiteasy.service.CiModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cimodules")
@RestController
public class CiModuleController {

    private final CiModuleMapper ciModuleMapper;
    private final CiModuleService ciModuleService;


    public CiModuleController(CiModuleService ciModuleService, CiModuleMapper ciModuleMapper) {
        this.ciModuleMapper = ciModuleMapper;
        this.ciModuleService = ciModuleService;
    }


    @GetMapping()
    public ResponseEntity<List<CiModuleResponseDto>> CiModule() {
        List<CiModule> ciModule = ciModuleService.getCiModules();
        return ResponseEntity.ok(ciModuleMapper.toCiModuleDtos(ciModule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiModuleResponseDto> television(@PathVariable Long id) {
        CiModule specificCiModule = ciModuleService.getCimodule(id);
        return ResponseEntity.ok(ciModuleMapper.toCiModuleDto(specificCiModule));
    }

    @PostMapping("")
    public ResponseEntity<CiModuleResponseDto> createCiModule(@RequestBody CiModuleInputDto CiModule) {
        CiModule savedCiModule = ciModuleService.saveCiModule(ciModuleMapper.createCiModule(CiModule));
        return ResponseEntity.status(HttpStatus.CREATED).body(ciModuleMapper.toCiModuleDto(savedCiModule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleInputDto> putCiModule(@PathVariable Long id, @RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModule ciModule = ciModuleMapper.createCiModule(ciModuleInputDto);
        ciModuleService.updateCiModule(id, ciModule);
        return ResponseEntity.noContent().build();
    }

}
