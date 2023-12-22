package co.istad.demo.api.entityAlbumActor.dao;

import co.istad.demo.api.entityAlbumActor.model.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity,Long> {

}
