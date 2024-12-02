package api.LifeIsStrange.schemas;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipsSchema {
    private Integer id;
    private String names;
    private String relationshipType;
    private String description;
    private List<String> keyMoments;
}
