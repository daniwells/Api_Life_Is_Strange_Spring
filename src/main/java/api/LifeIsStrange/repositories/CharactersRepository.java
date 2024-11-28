package api.LifeIsStrange.repositories;

import api.LifeIsStrange.models.CharactersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharactersRepository extends JpaRepository<CharactersModel, Long> {
}