package nl.novi.opdrachttechiteasy.service;


import jakarta.persistence.EntityNotFoundException;
import nl.novi.opdrachttechiteasy.exceptions.RecordNotFoundException;
import nl.novi.opdrachttechiteasy.models.Television;
import nl.novi.opdrachttechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    @Autowired
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    public List<Television> getTelevisions(){
        return televisionRepository.findAll();
    }

    public Television getTelevision (Long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            return optionalTelevision.get();
        }
    }

    public Television saveTelevision (Television television) {
        Television addTelevision = televisionRepository.save(television);
        if (addTelevision == null) {
            throw new EntityNotFoundException("Failed to save television");
        } else {
            return addTelevision;
        }
    }

    public void removeTelevision(Long televisionId) {
        if (!televisionRepository.existsById(televisionId)) {
            throw new EntityNotFoundException("Television with ID " + televisionId + " not found");
        }
        televisionRepository.deleteById(televisionId);
    }

    public void updateTelevision (Long id, Television television) {

        Optional<Television> televisionFound = televisionRepository.findById(id);
        if (televisionFound == null) {
            throw new RecordNotFoundException("This tv does not excist");
        } else {
            return televisionFound.;
        }
    }

}
