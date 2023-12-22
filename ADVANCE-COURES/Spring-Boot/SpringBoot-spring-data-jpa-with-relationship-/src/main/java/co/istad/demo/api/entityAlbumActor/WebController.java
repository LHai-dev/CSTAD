package co.istad.demo.api.entityAlbumActor;

import co.istad.demo.api.entityAlbumActor.dao.ActorRepository;
import co.istad.demo.api.entityAlbumActor.dao.AlbumRepository;
import co.istad.demo.api.entityAlbumActor.dto.ActorModel;
import co.istad.demo.api.entityAlbumActor.dto.ActorModelMapStruct;
import co.istad.demo.api.entityAlbumActor.dto.AlbumModel;
import co.istad.demo.api.entityAlbumActor.dto.AlbumModelMapStruct1;
import co.istad.demo.api.entityAlbumActor.model.ActorEntity;
import co.istad.demo.api.entityAlbumActor.model.AlbumEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class WebController {
    private final AlbumRepository albumRepository;
    private final ActorRepository actorRepository;

    private final ActorModelMapStruct actorModelAssembler;

//    private final  ;
private final AlbumModelMapStruct1 albumModelAssembler;
//    @GetMapping("/api/actors")
//    public ResponseEntity<CollectionModel<ActorModel>> getAllActors()
//    {
//        List<ActorEntity> actorEntities = actorRepository.findAll();
//        return new ResponseEntity<>(
//                actorModelAssembler.toCollectionModel(actorEntities),
//                HttpStatus.OK);
//    }

//    @GetMapping("/api/actors/{id}")
//    public ResponseEntity<ActorModel> getActorById(@PathVariable("id") Long id)
//    {
//        return actorRepository.findById(id)
//                .map(actorModelAssembler::toCollectionModel)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/api/albums")
    public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums()
    {
        List<AlbumEntity> albumEntities = albumRepository.findAll();

        return new ResponseEntity<>(
                albumModelAssembler.toCollectionModel(albumEntities),
                HttpStatus.OK);
    }

    @GetMapping("/api/albums/{id}")
    public ResponseEntity<AlbumModel> getAlbumById(@PathVariable("id") Long id)
    {

        return albumRepository.findById(id)
                .map(albumModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
