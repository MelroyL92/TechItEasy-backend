package nl.novi.opdrachttechiteasy.mappers;

import nl.novi.opdrachttechiteasy.dtos.TelevisionDto;
import nl.novi.opdrachttechiteasy.models.Television;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

    @Component
    public class TelevisionMapper {

        public TelevisionDto toTelevisionDto(Television television){
            TelevisionDto dto = new TelevisionDto();
            dto.setId(television.getId());
            dto.setName(television.getName());
            dto.setType(television.getType());
            dto.setBrand(television.getBrand());
            dto.setPrice(television.getPrice());
            dto.setAvailableSize(television.getAvailableSize());
            dto.setRefreshRate(television.getRefreshRate());
            dto.setScreenQuality(television.getScreenQuality());
            dto.setScreenType(television.getScreenType());
            dto.setSmartTv(television.getSmartTv());
            dto.setWifi(television.getWifi());
            dto.setVoiceControl(television.getVoiceControl());
            dto.setHdr(television.getHdr());
            dto.setBluetooth(television.getBluetooth());
            dto.setAmbiLight(television.getAmbiLight());
            dto.setOriginalStock(television.getOriginalStock());
            dto.setSold(television.getSold());
            return dto;
        }

        public List <TelevisionDto> toTelevisionDto(List<Television>televisions){
            List<TelevisionDto> result = new ArrayList<>();
            for (Television television : televisions){
                result.add(toTelevisionDto(television));
            }
            return result;
        }

        public Television toTelevisionEntity(TelevisionDto dto){
            var television = new Television();
            television.setId(dto.getId());
            television.setType(dto.getType());
            television.setBrand(dto.getBrand());
            television.setName(dto.getName());
            television.setType(dto.getType());
            television.setPrice(dto.getPrice());
            television.setAvailableSize(dto.getAvailableSize());
            television.setRefreshRate(dto.getRefreshRate());
            television.setScreenType(dto.getScreenType());
            television.setScreenQuality(dto.getScreenQuality());
            television.setSmartTv(dto.getSmartTv());
            television.setWifi(dto.getWifi());
            television.setVoiceControl(dto.getVoiceControl());
            television.setHdr(dto.getHdr());
            television.setBluetooth(dto.getBluetooth());
            television.setAmbiLight(dto.getAmbiLight());
            television.setOriginalStock(dto.getOriginalStock());
            television.setSold(dto.getSold());

            return television;
        }
    }
