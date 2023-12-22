package co.istad.demo.api.entityAlbumActor.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "actors")
@Table(name="album")
public class AlbumEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String releaseDate;

    @ManyToMany(mappedBy = "albums",fetch = FetchType.EAGER)
    private List<ActorEntity> actors;
}
