package api.LifeIsStrange.schemas;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

public class RelationshipsSchema {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String names;
    @Getter
    @Setter
    private String relationshipType;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private List<String> keyMoments;

    public RelationshipsSchema(Integer id, String names, String relationshipType, String description, List<String> keyMoments){
        this.id = id;
        this.names = names;
        this.relationshipType = relationshipType;
        this.description = description;
        this.keyMoments = keyMoments;
    }
}
