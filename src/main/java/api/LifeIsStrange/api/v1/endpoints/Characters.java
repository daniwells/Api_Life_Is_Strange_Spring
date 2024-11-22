package api.LifeIsStrange.api.v1.endpoints;

// Libs
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import api.LifeIsStrange.schemas.CharacterSchema;

@RestController
@RequestMapping("/life_is_strange/characters")
public class Characters {
    private List<CharacterSchema> characters = new ArrayList<>();

    public Characters(){
        characters.add(new CharacterSchema(1, "João", 14, "description"));
    }

    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping
    public ResponseEntity<List<CharacterSchema>> getAllCharacters(){
        if(characters.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping("/life_is_strange/characters/{id}")
    public ResponseEntity<CharacterSchema> getCharacter(@PathVariable Integer id){
        Optional<CharacterSchema> character = characters.stream().filter(C -> C.getId().equals(id)).findFirst();
        if(character.isPresent()){
            return new ResponseEntity<>(character.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCharacter(@RequestBody CharacterSchema character) {
        characters.add(character);
        return new ResponseEntity<>("Character created succesfully", HttpStatus.CREATED);
    }

    @PutMapping("life_is_strange/characters/{id}")
    public ResponseEntity<String> putCharacter(@PathVariable Integer id, @RequestBody CharacterSchema character) {

        for(int i = 0; i < characters.size(); i++){
            if(characters.get(i).getId().equals(id)){
                characters.set(i, character);
                return new ResponseEntity<>("Character updated succefully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Character not founded",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("life_is_strange/characters/{id}")
    public ResponseEntity<String> deleteCat(@PathVariable Integer id) {

        for(int i = 0; i < characters.size(); i++){
            if(characters.get(i).getId().equals(id)){
                characters.remove(i);
                return new ResponseEntity<>("Character updated succefully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Character not founded",HttpStatus.NO_CONTENT);
    }
}
