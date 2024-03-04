package nl.novi.opdrachttechiteasy.service;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.opdrachttechiteasy.exceptions.RecordNotFoundException;
import nl.novi.opdrachttechiteasy.models.RemoteController;
import nl.novi.opdrachttechiteasy.repositories.RemoteControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    @Autowired
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<RemoteController> getRemoteController() {
        return remoteControllerRepository.findAll();
    }

    public RemoteController getRemoteController(long id){
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(id);
        if (optionalRemoteController.isEmpty()) {
            throw new RuntimeException();
        } else {
            return optionalRemoteController.get();
        }
    }

    public RemoteController remoteController(RemoteController remoteController){
        return remoteControllerRepository.save(remoteController);
    }

    public void updateRemoteController(Long id, RemoteController remoteController) {
        Optional<RemoteController>RemoteFound = remoteControllerRepository.findById(id);
        if(RemoteFound.isPresent()){
            RemoteController excistingRemoteController = RemoteFound.get();
            excistingRemoteController.setPrice(remoteController.getPrice());
            excistingRemoteController.setName(remoteController.getName());
            excistingRemoteController.setId(remoteController.getId());
            excistingRemoteController.setOriginalStock(remoteController.getOriginalStock());
            excistingRemoteController.setBatteryType(remoteController.getBatteryType());
            excistingRemoteController.setCompatibleWith(remoteController.getCompatibleWith());
            remoteControllerRepository.save(remoteController);
        } else {
            throw new RecordNotFoundException("Remotecontroller with ID : " + id + " does not exist");
        }
    }

    public void removeRemoteController (Long remoteControllerId) {
        System.out.println("the value of the id = " + remoteControllerId);
        if (!remoteControllerRepository.existsById(remoteControllerId)) {
            throw new EntityNotFoundException("Television with ID " + remoteControllerId + " not found");
        }
        remoteControllerRepository.deleteById(remoteControllerId);
    }
}
