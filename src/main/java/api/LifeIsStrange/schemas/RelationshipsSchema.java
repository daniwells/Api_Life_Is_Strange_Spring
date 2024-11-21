package api.LifeIsStrange.schemas;

import lombok.Getter;
import lombok.Setter;

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

    public RelationshipsSchema(Integer id, String names, String relationshipType, String description){
        this.id = id;
        this.names = names;
        this.relationshipType = relationshipType;
        this.description = description;
    }
}
