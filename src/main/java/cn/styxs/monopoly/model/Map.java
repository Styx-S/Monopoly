package cn.styxs.monopoly.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class Map {
    private ArrayList<MapNode> mapNodes = new ArrayList<>();
    List<PropertyGroup> groups;

    public Map() {
        MapNode startNode = MapNode.builder().property(new BaseProperty("GO")).build();
        startNode.nextNode = startNode;
        mapNodes.add(startNode);

    }

    // 按顺序加
    public void addProperty(Property property) {
        MapNode mapNode = MapNode.builder().property(property).build();
        MapNode lastNode = mapNodes.get(mapNodes.size() - 1);
        mapNode.nextNode = lastNode.nextNode;
        lastNode.nextNode = mapNode;
        mapNodes.add(mapNode);
    }

}
