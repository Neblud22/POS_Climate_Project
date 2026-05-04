package angi.posporjectdata.dto;

import lombok.Data;

@Data
public class ClimateRoot {
    private String[] timestamps;
    private Feature[] features;
}
