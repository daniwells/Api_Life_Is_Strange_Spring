package api.LifeIsStrange.services;

import api.LifeIsStrange.models.RelationshipsModel;
import api.LifeIsStrange.repositories.RelationshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteRelationship(Long id) {
        relationshipsRepository.deleteById(id);
    }
}
