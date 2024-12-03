package api.LifeIsStrange.services;

// Libs
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

// Classes
import api.LifeIsStrange.models.RelationshipsModel;
import api.LifeIsStrange.repositories.RelationshipsRepository;

@Service
public class RelationshipsService {
    @Autowired
    private RelationshipsRepository relationshipsRepository;

    public RelationshipsModel saveRelationship(RelationshipsModel relationship) {
        return relationshipsRepository.save(relationship);
    }

    public Optional<RelationshipsModel> getRelationshipById(Long id) {
        return relationshipsRepository.findById(id);
    }

    public List<RelationshipsModel> getAllRelationships() {
        return relationshipsRepository.findAll();
    }

    public Page<RelationshipsModel> getRelationshipsPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return relationshipsRepository.findAll(pageable);
    }

    public void deleteRelationship(Long id) {
        relationshipsRepository.deleteById(id);
    }
}
