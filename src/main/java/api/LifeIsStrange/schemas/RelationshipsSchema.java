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
    private Long id;
    private String name;
    private String relationshipType;
    private List<String> keyMoments;
    private String description;
}
