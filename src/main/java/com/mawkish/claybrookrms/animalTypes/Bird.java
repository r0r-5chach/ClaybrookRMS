package com.mawkish.claybrookrms.animalTypes;

import org.bson.Document;

public class Bird extends Animal{
    private String nestMethod;
    private long clutchSize;
    private double wingSpan;
    private boolean canFly;
    private String plumage;

    public Bird(Document animal) {
        super(animal);
        nestMethod = animal.getString("_nestMethod");
        clutchSize = animal.getLong("_clutchSize");
        wingSpan = animal.getDouble("_wingSpan");
        canFly = animal.getBoolean("_canFly");
        plumage = animal.getString("_plumage");
    }

    public String getNestMethod() {
        return nestMethod;
    }

    public void setNestMethod(String nestMethod) {
        this.nestMethod = nestMethod;
        animalDoc.replace("_nestMethod", nestMethod);
    }

    public long getClutchSize() {
        return clutchSize;
    }

    public void setClutchSize(long clutchSize) {
        this.clutchSize = clutchSize;
        animalDoc.replace("_clutchSize", clutchSize);
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
        animalDoc.replace("_wingSpan", wingSpan);
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
        animalDoc.replace("_canFly", canFly);
    }

    public String getPlumage() {
        return plumage;
    }

    public void setPlumage(String plumage) {
        this.plumage = plumage;
        animalDoc.replace("_plumage", plumage);
    }
}
