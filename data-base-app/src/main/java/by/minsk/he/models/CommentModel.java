package by.minsk.he.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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