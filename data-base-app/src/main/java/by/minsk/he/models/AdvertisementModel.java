package by.minsk.he.models;

import by.minsk.he.models.enums.AdvertStatus;
import by.minsk.he.models.enums.RegionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "advertisement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AdvertisementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID advertisementId;
    private LocalDate startDate;
    private String contactPhone;
    private BigDecimal price;
    private int rank;
    @Enumerated(EnumType.STRING)
    private RegionType regionType;
    @Enumerated(EnumType.STRING)
    private AdvertStatus advertStatus;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_id", nullable = false)
    private CarModel carModel;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;
}
