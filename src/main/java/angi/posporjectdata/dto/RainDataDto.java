package angi.posporjectdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RainDataDto {
    private int id;
    private String[] timestamps;
    private String weatherType;
    private double[] weatherData;
    private String unit;

}
