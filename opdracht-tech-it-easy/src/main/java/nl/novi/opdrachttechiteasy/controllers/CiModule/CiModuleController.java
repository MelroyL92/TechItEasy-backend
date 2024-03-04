package nl.novi.opdrachttechiteasy.controllers.CiModule;


import nl.novi.opdrachttechiteasy.mappers.CiModuleMapper;
import nl.novi.opdrachttechiteasy.service.CiModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cimodules")
@RestController
public class CiModuleController {

    private final CiModuleMapper ciModuleMapper;
    private final CiModuleService ciModuleService;


    public CiModuleController (CiModuleService ciModuleService, CiModuleMapper ciModuleMapper){
        this.ciModuleMapper = ciModuleMapper;
        this.ciModuleService = ciModuleService;
    }

}
