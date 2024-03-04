package nl.novi.opdrachttechiteasy.controllers.RemoteController;

import nl.novi.opdrachttechiteasy.mappers.RemoteControllerMapper;
import nl.novi.opdrachttechiteasy.service.RemoteControllerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/remotecontrollers")
@RestController
public class RemoteControllerController {

    private final RemoteControllerMapper remoteControllerMapper;
    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController (RemoteControllerMapper remoteControllerMapper, RemoteControllerService remoteControllerService){
        this.remoteControllerMapper = remoteControllerMapper;
        this.remoteControllerService = remoteControllerService;
    }
}
