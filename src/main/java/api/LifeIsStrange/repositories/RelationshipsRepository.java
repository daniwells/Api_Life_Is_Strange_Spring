package api.LifeIsStrange.repositories;

import api.LifeIsStrange.models.RelationshipsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipsRepository extends JpaRepository<RelationshipsModel, Long> {
}