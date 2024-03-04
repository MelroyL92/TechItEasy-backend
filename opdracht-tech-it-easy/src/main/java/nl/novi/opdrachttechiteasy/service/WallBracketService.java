package nl.novi.opdrachttechiteasy.service;


import jakarta.persistence.EntityNotFoundException;
import nl.novi.opdrachttechiteasy.exceptions.RecordNotFoundException;
import nl.novi.opdrachttechiteasy.models.WallBracket;
import nl.novi.opdrachttechiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService (WallBracketRepository wallBracketRepository){
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracket> getWallbracket(){

        return wallBracketRepository.findAll();
    }

    public WallBracket getWallbracket(long id) {
        Optional<WallBracket> optionalWallbracket= wallBracketRepository.findById(id);
        if(optionalWallbracket.isEmpty()){
            throw new RecordNotFoundException();
        } else {
            return optionalWallbracket.get();
        }

    }

    public WallBracket saveWallbracket (WallBracket wallBracket) {
        return wallBracketRepository.save(wallBracket);
    }

    public void updateWallbracket(Long id, WallBracket wallBracket) {
        Optional<WallBracket>WallbracketFound = wallBracketRepository.findById(id);
        if(WallbracketFound.isPresent()){
            WallBracket excistingWallbracket = WallbracketFound.get();
            excistingWallbracket.setPrice(wallBracket.getPrice());
            excistingWallbracket.setName(wallBracket.getName());
            excistingWallbracket.setId(wallBracket.getId());
            excistingWallbracket.setAdjustable(wallBracket.getAdjustable());
            wallBracketRepository.save(excistingWallbracket);
        } else {
            throw new RecordNotFoundException("wallbracket with ID " + id + " does not exist");
        }
    }

    public void removeWallbracket (Long wallbracketId) {
        System.out.println("the value of the id = " + wallbracketId);
        if (!wallBracketRepository.existsById(wallbracketId)) {
            throw new EntityNotFoundException("Television with ID " + wallbracketId + " not found");
        }
        wallBracketRepository.deleteById(wallbracketId);
    }


}
