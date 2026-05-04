package angi.posporjectdata.Controller;

import angi.posporjectdata.Service.ClimateService;
import angi.posporjectdata.dto.RainDataDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimateController {
    private final ClimateService climateService;


    public ClimateController(ClimateService climateService) {
        this.climateService = climateService;
    }

    @GetMapping("/climate")
    public RainDataDto getClimate(){
        return climateService.getClimate();
    }

}
