package api.LifeIsStrange.schemas;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSchema {
    private Integer id;
    private String name;
    private Integer age;
    private String description;
}