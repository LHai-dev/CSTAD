package co.istad.demo.api.entityAlbumActor.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "albums")
@Entity
@Table(name="actor")
public class ActorEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "actor_album",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    private List<AlbumEntity> albums;
}
