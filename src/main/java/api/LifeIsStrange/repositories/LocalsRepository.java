package api.LifeIsStrange.repositories;

import api.LifeIsStrange.models.LocalsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalsRepository extends JpaRepository<LocalsModel, Long> {
}