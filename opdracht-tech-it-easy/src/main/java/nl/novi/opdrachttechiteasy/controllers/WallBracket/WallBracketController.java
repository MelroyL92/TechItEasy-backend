package nl.novi.opdrachttechiteasy.controllers.WallBracket;

import nl.novi.opdrachttechiteasy.mappers.WallBracketMapper;
import nl.novi.opdrachttechiteasy.service.WallBracketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wallbrackets")
@RestController
public class WallBracketController {

    private final WallBracketMapper wallBracketMapper;
    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketMapper wallBracketMapper, WallBracketService wallBracketService){
        this.wallBracketMapper = wallBracketMapper;
        this.wallBracketService = wallBracketService;
    }

}
