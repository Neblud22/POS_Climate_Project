package angi.posporjectdata.entity;

import jakarta.persistence.*;

@Entity
@Table("rain_data_LB")
public class RainData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
