package com.mawkish.claybrookrms.animalTypes;

import org.bson.Document;

public class Reptile extends Animal{
    private String reproductionType;
    private long offSpringSize;


    public Reptile(Document animal) {
        super(animal);
        reproductionType = animal.getString("_reproductionType");
        offSpringSize = animal.getLong("_offspringSize");
    }

    public String getReproductionType() {
        return reproductionType;
    }

    public void setReproductionType(String reproductionType) {
        this.reproductionType = reproductionType;
        animalDoc.replace("_reproductionType", reproductionType);
    }

    public long getOffSpringSize() {
        return offSpringSize;
    }

    public void setOffSpringSize(long offSpringSize) {
        this.offSpringSize = offSpringSize;
        animalDoc.replace("_offspringSize", offSpringSize);
    }
}
