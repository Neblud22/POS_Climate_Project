package angi.posporjectdata.Service;

import angi.posporjectdata.dto.ClimateRoot;
import angi.posporjectdata.dto.Parameters;
import angi.posporjectdata.dto.RR;
import angi.posporjectdata.dto.RainDataDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
@Service
public class ClimateService {
    private final RestClient restClient;


    public ClimateService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://dataset.api.hub.geosphere.at")
                .build();
    }

    public String getClimatee(){
        return restClient.get()
                .uri("/v1/timeseries/historical/inca-v1-1h-1km?parameters=RR&start=2024-01-01T00:00&end=2024-01-02T00:00&lat_lon=47.07,15.44")
                .retrieve()
                .body(String.class);

    }

    public RainDataDto getClimate(){
        ClimateRoot climateRoot = restClient.get()
                .uri("/v1/timeseries/historical/inca-v1-1h-1km?parameters=RR&start=2024-01-01T00:00&end=2024-01-02T00:00&lat_lon=47.07,15.44")
                .retrieve()
                .body(ClimateRoot.class);



        RR rr = climateRoot.getFeatures()[0]
                .getProperties()
                .getParameters()
                .getRR();
        RainDataDto dto = new RainDataDto();
        dto.setId(1);
        dto.setTimestamps(climateRoot.getTimestamps());
        dto.setWeatherType("RR");
        dto.setWeatherData(rr.getData());
        dto.setUnit(rr.getUnit());

        return dto;
    }

}
