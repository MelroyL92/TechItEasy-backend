package nl.novi.opdrachttechiteasy.mappers;

import nl.novi.opdrachttechiteasy.dtos.WallBracket.WallBracketInputDto;
import nl.novi.opdrachttechiteasy.dtos.WallBracket.WallBracketResponseDto;
import nl.novi.opdrachttechiteasy.models.WallBracket;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class WallBracketMapper {

    public WallBracketResponseDto toWallBracketDto(WallBracket wallBracket){
        WallBracketResponseDto dto = new WallBracketResponseDto();
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setName(wallBracket.getName());
        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        return dto;
    }

    public List<WallBracketResponseDto> toWallbracketDtos(List<WallBracket>wallBrackets){
        List<WallBracketResponseDto> result = new ArrayList<>();
        for (WallBracket wallBracket: wallBrackets) {
            result.add(toWallBracketDto(wallBracket));
        }
        return result;
    }

    public WallBracket createWallBracket(WallBracketInputDto dto){
        var wallBracket =  new WallBracket();
        wallBracket.setAdjustable(dto.getAdjustable());
        wallBracket.setName(dto.getName());
        wallBracket.setPrice(dto.getPrice());
        wallBracket.setId(dto.getId());
        return wallBracket;
    }
}

