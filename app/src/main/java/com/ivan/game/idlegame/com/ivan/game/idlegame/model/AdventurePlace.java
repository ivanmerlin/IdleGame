package com.ivan.game.idlegame.com.ivan.game.idlegame.model;

/**
 * Created by fanlime24 on 2015/6/30.
 */
public class AdventurePlace {
    String name;
    int locationId;
    String description;

    public AdventurePlace(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
