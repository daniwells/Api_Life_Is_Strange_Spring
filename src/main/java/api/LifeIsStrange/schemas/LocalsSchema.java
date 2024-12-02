package api.LifeIsStrange.schemas;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalsSchema {
    private Integer id;
    private String name;
    private String description;
}