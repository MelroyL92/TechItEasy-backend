package nl.novi.opdrachttechiteasy.mappers;

import nl.novi.opdrachttechiteasy.dtos.RemoteController.RemoteControllerInputDto;
import nl.novi.opdrachttechiteasy.dtos.RemoteController.RemoteControllerResponseDto;
import nl.novi.opdrachttechiteasy.models.RemoteController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteControllerMapper {

    public RemoteControllerResponseDto toRemotecontrollerDto(RemoteController remoteController) {
        RemoteControllerResponseDto dto = new RemoteControllerResponseDto();
        dto.setId(remoteController.getId());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setName(remoteController.getName());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setPrice(remoteController.getPrice());
        dto.setOriginalStock(remoteController.getOriginalStock());
        return dto;
    }

    public List<RemoteControllerResponseDto> toRemoteControllerDtos(List<RemoteController> remoteControllers){
        List<RemoteControllerResponseDto> result = new ArrayList<>();
        for(RemoteController remoteController : remoteControllers){
            result.add(toRemotecontrollerDto(remoteController));
        }
        return result;
    }


    public RemoteController createRemoteController(RemoteControllerInputDto dto){
        var remoteController = new RemoteController();
        remoteController.setName(dto.getName());
        remoteController.setId(dto.getId());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setPrice(dto.getPrice());
        remoteController.setOriginalStock(dto.getOriginalStock());
        return remoteController;
    }
}
