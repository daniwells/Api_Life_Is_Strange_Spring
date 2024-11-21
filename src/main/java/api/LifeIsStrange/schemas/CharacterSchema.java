package api.LifeIsStrange.schemas;

import lombok.Getter;
import lombok.Setter;

public class CharacterSchema {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private String description;

    public CharacterSchema(Integer id, String name, Integer age, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
    }
}