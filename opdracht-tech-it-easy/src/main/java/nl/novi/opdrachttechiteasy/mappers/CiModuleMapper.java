package nl.novi.opdrachttechiteasy.mappers;

import nl.novi.opdrachttechiteasy.dtos.CiModule.CiModuleInputDto;
import nl.novi.opdrachttechiteasy.dtos.CiModule.CiModuleResponseDto;
import nl.novi.opdrachttechiteasy.dtos.RemoteController.RemoteControllerResponseDto;
import nl.novi.opdrachttechiteasy.models.CiModule;
import nl.novi.opdrachttechiteasy.models.RemoteController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CiModuleMapper {

    public CiModuleResponseDto toCiModuleDto(CiModule ciModule) {
        CiModuleResponseDto dto = new CiModuleResponseDto();
        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setPrice(ciModule.getPrice());
        dto.setType(ciModule.getType());
        return dto;
    }

    public List<CiModuleResponseDto> toCiModuleDtos(List<CiModule>ciModules){
        List<CiModuleResponseDto> result = new ArrayList<>();
         for(CiModule ciModule : ciModules) {
             result.add(toCiModuleDto(ciModule));
         }
         return result;

    }

    public CiModule createCiModule(CiModuleInputDto dto){
        var ciModule = new CiModule();
        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());
        return ciModule;
    }


}
