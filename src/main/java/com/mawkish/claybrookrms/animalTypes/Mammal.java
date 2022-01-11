package com.mawkish.claybrookrms.animalTypes;

import org.bson.Document;

public class Mammal extends Animal{
    private double bodyTemp;
    private String clade;
    private long gestation;

    public Mammal(Document animal) {
        super(animal);
        bodyTemp = animal.getDouble("_bodyTemp");
        clade = animal.getString("_clade");
        gestation = animal.getLong("_gestation");
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
        animalDoc.replace("_bodyTemp", bodyTemp);
    }

    public String getClade() {
        return clade;
    }

    public void setClade(String clade) {
        this.clade = clade;
        animalDoc.replace("_clade", clade);
    }

    public long getGestation() {
        return gestation;
    }

    public void setGestation(long gestation) {
        this.gestation = gestation;
        animalDoc.replace("_gestation", gestation);
    }
}
