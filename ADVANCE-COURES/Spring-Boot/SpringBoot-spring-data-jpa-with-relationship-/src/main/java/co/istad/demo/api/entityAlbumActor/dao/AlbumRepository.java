package co.istad.demo.api.entityAlbumActor.dao;

import co.istad.demo.api.entityAlbumActor.model.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
