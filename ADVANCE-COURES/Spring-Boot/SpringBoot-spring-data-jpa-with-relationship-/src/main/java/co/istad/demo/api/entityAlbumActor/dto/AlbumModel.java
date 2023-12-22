package co.istad.demo.api.entityAlbumActor.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "album")
@Relation(collectionRelation = "albums")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumModel extends RepresentationModel<AlbumModel> {
    private Long id;
    private String title;
    private String description;
    private String releaseDate;

    private List<ActorModel> actors;
}
