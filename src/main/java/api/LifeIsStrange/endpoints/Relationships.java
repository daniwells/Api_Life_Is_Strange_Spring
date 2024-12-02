package api.LifeIsStrange.endpoints;

// Libs
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
// Spring
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Classes
import api.LifeIsStrange.schemas.RelationshipsSchema;

@RestController
@RequestMapping("life_is_strange/relationships")
public class Relationships {
    private List<RelationshipsSchema> relationships = new ArrayList<>();

    public Relationships(){
        List<String> keyMoments = new ArrayList<>();
        keyMoments.add("O reencontro");
        keyMoments.add("A decisão no farol"); 
        relationships.add(new RelationshipsSchema(1, "Chloe and Max", "Girlfriends", "A relationship between friends and lovers.", keyMoments));
    }

    @GetMapping
    public ResponseEntity<List<RelationshipsSchema>> getAllRelationships() {
        if(relationships.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(relationships, HttpStatus.OK);
    }

    @GetMapping("life_is_strange/relationships/{id}")
    public ResponseEntity<RelationshipsSchema> getRelationships(@PathVariable Integer id) {
        Optional<RelationshipsSchema> relationship = relationships.stream().filter(C -> C.getId().equals(id)).findFirst();
        if(relationship.isPresent()){
            return new ResponseEntity<>(relationship.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createRelationship(@RequestBody RelationshipsSchema relationship){
        relationships.add(relationship);
        return new ResponseEntity<>("Relationship created succesfully", HttpStatus.CREATED);
    }
    
    @PutMapping("life_is_strange/relationships/{id}")
    public ResponseEntity<String> putRelationship(@PathVariable Integer id, @RequestBody RelationshipsSchema relationship) {
        
        for(int i = 0; i < relationships.size(); i++){
            if(relationships.get(i).getId().equals(id)){
                relationships.set(i, relationship);
                return new ResponseEntity<>("Relationship created succesfully", HttpStatus.OK);            
            }
        }
        return new ResponseEntity<>("Relationship not founded", HttpStatus.NO_CONTENT);    
    }

    @DeleteMapping("life_is_strange/relationships/{id}")
    public ResponseEntity<String> deleteRelationship(@PathVariable Integer id){

        for (int i = 0; i < relationships.size(); i++){
            if(relationships.get(i).getId().equals(id)){
                relationships.remove(i);
                return new ResponseEntity<>("Relationship deleted succesfully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Relationship not founded", HttpStatus.NO_CONTENT);
    }
    
}
