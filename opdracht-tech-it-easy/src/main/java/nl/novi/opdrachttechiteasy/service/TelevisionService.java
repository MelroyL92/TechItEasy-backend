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
        return  televisionRepository.save(television);

    }

    public void removeTelevision(Long televisionId) {
        System.out.println("the value of the id = " + televisionId);
        if (!televisionRepository.existsById(televisionId)) {
            throw new EntityNotFoundException("Television with ID " + televisionId + " not found");
        }
        televisionRepository.deleteById(televisionId);
    }

    public void updateTelevision (Long id, Television television) {

        Optional<Television> televisionFound = televisionRepository.findById(id);
        if (televisionFound.isPresent()) {
            // not sure if there is a better way for doing this? Now I have to do this for each of them. Maybe a loop to make it easier?)
            // also... writing in english somehow because coding is too
            Television existingTelevision = televisionFound.get();
            existingTelevision.setBrand(television.getBrand());
            existingTelevision.setType(television.getType());
            existingTelevision.setName(television.getName());
            existingTelevision.setPrice(television.getPrice());
            existingTelevision.setAvailableSize(television.getAvailableSize());
            televisionRepository.save(existingTelevision);
        } else {
            throw new RecordNotFoundException("Television with ID " + id + " does not exist");
        }
    }

}
