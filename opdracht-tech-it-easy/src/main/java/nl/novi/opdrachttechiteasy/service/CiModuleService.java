package nl.novi.opdrachttechiteasy.service;
import jakarta.persistence.EntityNotFoundException;
import nl.novi.opdrachttechiteasy.exceptions.RecordNotFoundException;
import nl.novi.opdrachttechiteasy.models.CiModule;
import nl.novi.opdrachttechiteasy.repositories.CiModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CiModuleService {

    @Autowired
    private final CiModuleRepository ciModuleRepository;


    public CiModuleService(CiModuleRepository ciModuleRepository){
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModule> getCiModule() {
        return ciModuleRepository.findAll();
    }

    public CiModule getCimodule(long id){
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(id);
        if (optionalCiModule.isEmpty()) {
            throw new RuntimeException();
        } else {
            return optionalCiModule.get();
        }
    }

    public CiModule ciModule(CiModule ciModule){
        return ciModuleRepository.save(ciModule);
    }


    public void updateCiModule(Long id, CiModule ciModule) {
        Optional<CiModule>CiModuleFound = ciModuleRepository.findById(id);
        if(CiModuleFound.isPresent()){
            CiModule excistingCiModule = CiModuleFound.get();
            excistingCiModule.setPrice(ciModule.getPrice());
            excistingCiModule.setName(ciModule.getName());
            excistingCiModule.setType(ciModule.getType());
            excistingCiModule.setId(ciModule.getId());
            ciModuleRepository.save(excistingCiModule);
        } else {
            throw new RecordNotFoundException("CI module with ID " + id + " does not exist");
        }
    }

    public void removeCiModule (Long ciModuleId) {
        System.out.println("the value of the id = " + ciModuleId);
        if (!ciModuleRepository.existsById(ciModuleId)) {
            throw new EntityNotFoundException("Television with ID " + ciModuleId + " not found");
        }
        ciModuleRepository.deleteById(ciModuleId);
    }


}
