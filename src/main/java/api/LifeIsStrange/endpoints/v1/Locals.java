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
import api.LifeIsStrange.models.LocalsModel;
import api.LifeIsStrange.services.LocalsService;

@RestController
@RequestMapping("/life_is_strange/locals")
public class Locals {

    @Autowired
    private LocalsService localsService;

    @PostMapping
    public LocalsModel createLocal(@RequestBody LocalsModel local) {
        return this.localsService.saveLocal(local);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalsModel> getLocal(@PathVariable Long id) {
        Optional<LocalsModel> local = this.localsService.getLocalById(id);
        if (local.isPresent()) {
            return new ResponseEntity<>(local.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public List<LocalsModel> getAllLocals() {
        return this.localsService.getAllLocals();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocal(@PathVariable Long id, @RequestBody LocalsModel local) {
        Optional<LocalsModel> existingLocal = this.localsService.getLocalById(id);
        if (existingLocal.isPresent()) {
            local.setId(id);
            LocalsModel updatedLocal = localsService.saveLocal(local);
            return new ResponseEntity<>("Local updated succefully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Local not found!", HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
        Optional<LocalsModel> local = this.localsService.getLocalById(id);
        if (local.isPresent()) {
            this.localsService.deleteLocal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
