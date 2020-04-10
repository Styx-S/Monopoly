package cn.styxs.monopoly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class MapNode {
    @JsonIgnore
    @ToString.Exclude
    MapNode nextNode; // TODO: 考虑分叉
    BaseProperty property;
}
