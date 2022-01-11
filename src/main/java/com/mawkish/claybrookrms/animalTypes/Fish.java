package com.mawkish.claybrookrms.animalTypes;

import org.bson.Document;

public class Fish extends Animal{
    private double bodyTemp;
    private String colours;
    private String waterType;

    public Fish(Document animal) {
        super(animal);
        bodyTemp = animal.getDouble("_bodyTemp");
        colours = animal.getString("_colours");
        waterType = animal.getString("_waterType");
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
        animalDoc.replace("_bodyTemp", bodyTemp);
    }

    public String getColours() {
        return colours;
    }

    public void setColours(String colours) {
        this.colours = colours;
        animalDoc.replace("_colours", colours);
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
        animalDoc.replace("_waterType", waterType);

    }
}
