package api.LifeIsStrange.endpoints;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Classes
import api.LifeIsStrange.schemas.LocalsSchema;

@RestController
@RequestMapping("/life_is_strange/locals")
public class Locals {
    private List<LocalsSchema> locals = new ArrayList<>();

    public Locals(){
        locals.add(new LocalsSchema(1, "", ""));
    }
    
    @GetMapping
    public ResponseEntity<List<LocalsSchema>> getAllLocals(){
        if(locals.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locals, HttpStatus.OK);
    }

    @GetMapping("/life_is_strange/locals/{id}")
    public ResponseEntity<LocalsSchema> getLocal(@PathVariable Integer id){
        Optional<LocalsSchema> local = locals.stream().filter(C -> C.getId().equals(id)).findFirst();
        if(local.isPresent()){
            return new ResponseEntity<>(local.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createLocal(@RequestBody LocalsSchema local) {
        locals.add(local);
        return new ResponseEntity<>("local created succesfully", HttpStatus.CREATED);
    }

    @PutMapping("life_is_strange/locals/{id}")
    public ResponseEntity<String> putLocal(@PathVariable Integer id, @RequestBody LocalsSchema local) {

        for(int i = 0; i < locals.size(); i++){
            if(locals.get(i).getId().equals(id)){
                locals.set(i, local);
                return new ResponseEntity<>("local updated succefully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("local not founded",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("life_is_strange/locals/{id}")
    public ResponseEntity<String> deleteLocal(@PathVariable Integer id) {

        for(int i = 0; i < locals.size(); i++){
            if(locals.get(i).getId().equals(id)){
                locals.remove(i);
                return new ResponseEntity<>("local updated succefully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("local not founded",HttpStatus.NO_CONTENT);
    }
}
