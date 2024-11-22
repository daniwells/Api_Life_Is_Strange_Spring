package api.LifeIsStrange.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CharactersModel {
    @Id
    private Long id;
    private String name;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
