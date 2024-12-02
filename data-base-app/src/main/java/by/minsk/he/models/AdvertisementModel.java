package by.minsk.he.models;

import by.minsk.he.models.enums.AdvertStatus;
import by.minsk.he.models.enums.RegionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
