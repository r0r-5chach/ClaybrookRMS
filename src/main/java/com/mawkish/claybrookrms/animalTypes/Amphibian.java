package com.mawkish.claybrookrms.animalTypes;

import org.bson.Document;

public class Amphibian extends Animal {
    private long offSpringSize;
    private String reproductionType;

    public Amphibian(Document animal) {
        super(animal);
        offSpringSize = animal.getLong("_offspringSize");
        reproductionType = animal.getString("_reproductionType");

    }

    public long getOffSpringSize() {
        return offSpringSize;
    }

    public void setOffSpringSize(long offSpringSize) {
        this.offSpringSize = offSpringSize;
        animalDoc.replace("_offspringSize", offSpringSize);
    }

    public String getReproductionType() {
        return reproductionType;
    }

    public void setReproductionType(String reproductionType) {
        this.reproductionType = reproductionType;
        animalDoc.replace("_reproductionType", reproductionType);
    }
}
