package by.minsk.he.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID commentId;
    private ZonedDateTime created;
    private String content;
    private UUID userId;
    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private AdvertisementModel advertisementModel;
}