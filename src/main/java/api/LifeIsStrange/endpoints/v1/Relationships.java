package api.LifeIsStrange.endpoints.v1;

// Libs
import java.util.List;
import java.util.Optional;

// Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Classes
import api.LifeIsStrange.models.RelationshipsModel;
import api.LifeIsStrange.services.RelationshipsService;

@RestController
@RequestMapping("/life_is_strange/Relationships")
public class Relationships {

    @Autowired
    private RelationshipsService relationshipsService;

    @PostMapping
    public RelationshipsModel createRelationship(@RequestBody RelationshipsModel relationship) {
        return this.relationshipsService.saveRelationship(relationship);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationshipsModel> getRelationship(@PathVariable Long id) {
        Optional<RelationshipsModel> relationship = this.relationshipsService.getRelationshipById(id);
        if (relationship.isPresent()) {
            return new ResponseEntity<>(relationship.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public List<RelationshipsModel> getAllRelationships() {
        return this.relationshipsService.getAllRelationships();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRelationship(@PathVariable Long id, @RequestBody RelationshipsModel relationship) {
        Optional<RelationshipsModel> existingRelationship = this.relationshipsService.getRelationshipById(id);
        if (existingRelationship.isPresent()) {
            relationship.setId(id);
            RelationshipsModel updatedRelationship = relationshipsService.saveRelationship(relationship);
            return new ResponseEntity<>("Relationship updated succefully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Relationship not found!", HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelationship(@PathVariable Long id) {
        Optional<RelationshipsModel> relationship = this.relationshipsService.getRelationshipById(id);
        if (relationship.isPresent()) {
            this.relationshipsService.deleteRelationship(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
