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
import java.time.LocalDateTime;
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
    private LocalDateTime created;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;
    @ManyToOne//(cascade = CascadeType.MERGE)
    @JoinColumn(name = "advertisement_id")
    private AdvertisementModel advertisementModel;
}
