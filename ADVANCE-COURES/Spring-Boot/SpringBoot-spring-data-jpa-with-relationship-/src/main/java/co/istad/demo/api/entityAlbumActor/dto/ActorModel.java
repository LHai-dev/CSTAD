package co.istad.demo.api.entityAlbumActor.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "actor")
@Relation(collectionRelation = "actors")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorModel extends RepresentationModel<ActorModel> {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;

    private List<AlbumModel> albums;
}
