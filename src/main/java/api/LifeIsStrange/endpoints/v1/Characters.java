package api.LifeIsStrange.endpoints.v1;

// Libs
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;

// Classes
import api.LifeIsStrange.models.CharactersModel;
import api.LifeIsStrange.services.CharactersService;

@RestController
@RequestMapping("/life_is_strange/characters")
public class Characters {

    @Autowired
    private CharactersService charactersService;

    @PostMapping
    public CharactersModel createCharacter(@RequestBody CharactersModel character) {
        return this.charactersService.saveCharacter(character);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharactersModel> getCharacter(@PathVariable Long id) {
        Optional<CharactersModel> character = this.charactersService.getCharacterById(id);
        if (character.isPresent()) {
            return new ResponseEntity<>(character.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public List<CharactersModel> getAllCharacters() {
        return this.charactersService.getAllCharacters();
    }

    @GetMapping("/ordering")
    public List<CharactersModel> getAllCharactersOrdering() {
        return this.charactersService.getAllCharacters("ordering");
    }

    @GetMapping("/pagination/{page}")
    public List<CharactersModel> getAllCharactersPagination(@PathVariable Integer page) {
        Page<CharactersModel> charactersPage = this.charactersService.getCharactersPagination(page, 5);
        return charactersPage.getContent(); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCharacter(@PathVariable Long id, @RequestBody CharactersModel character) {
        Optional<CharactersModel> existingCharacter = this.charactersService.getCharacterById(id);
        if (existingCharacter.isPresent()) {
            character.setId(id);
            CharactersModel updatedCharacter = charactersService.saveCharacter(character);
            return new ResponseEntity<>("Character updated succefully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Character not found!",HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        Optional<CharactersModel> character = this.charactersService.getCharacterById(id);
        if (character.isPresent()) {
            this.charactersService.deleteCharacter(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
