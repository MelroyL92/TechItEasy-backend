package nl.novi.opdrachttechiteasy.mappers;

import nl.novi.opdrachttechiteasy.dtos.TelevisionResponseDto;
import nl.novi.opdrachttechiteasy.dtos.TelevisionInputDto;
import nl.novi.opdrachttechiteasy.models.Television;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

    @Component
    public class TelevisionMapper {

        public TelevisionResponseDto toTelevisionDto(Television television){
            TelevisionResponseDto dto = new TelevisionResponseDto();
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

        public List <TelevisionResponseDto> toTelevisionDtos(List<Television>televisions){
            List<TelevisionResponseDto> result = new ArrayList<>();
            for (Television television : televisions){
                result.add(toTelevisionDto(television));
            }
            return result;
        }

        public Television createTelevision(TelevisionInputDto dto){
            var television = new Television();
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
