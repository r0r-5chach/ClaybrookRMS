package com.mawkish.claybrookrms.animalTypes;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;

public class Animal {
    private String name;
    private String species;
    private Date dob;
    private char gender;
    private double lifeSpan;
    private String classification;
    private ArrayList<String> diet;
    private String habitat;
    private ArrayList<String> gpd;
    private Date dateReceived;
    private double weight;
    private double length;
    private String imageURL;
    private String sponsor;
    private String location;
    protected Document animalDoc;


    public Animal(Document animal) {
        animalDoc = animal;
        name = animal.getString("_name");
        species = animal.getString("_species");
        dob = animal.getDate("_dob");
        gender = animal.getString("_gender").charAt(0);
        lifeSpan = animal.getDouble("_lifespan");
        classification = animal.getString("_classification");
        habitat = animal.getString("_habitat");
        diet = (ArrayList<String>) animal.get("_diet");
        gpd = (ArrayList<String>) animal.get("_gpd");
        dateReceived = animal.getDate("_dateReceived");
        weight = animal.getDouble("_weight");
        length = animal.getDouble("_length");
        imageURL = animal.getString("_imageURL");
        location = animal.getString("_location");
        sponsor = animal.getString("_sponsor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        animalDoc.replace("_name",name);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
        animalDoc.replace("_species",species);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
        animalDoc.replace("_dob",dob);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
        animalDoc.replace("_gender",gender);
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
        animalDoc.replace("_lifespan",lifeSpan);
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
        animalDoc.replace("_classification",classification);
    }

    public ArrayList<String> getDiet() {
        return diet;
    }

    public void setDiet(ArrayList<String> diet) {
        this.diet = diet;
        animalDoc.replace("_diet", diet);
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
        animalDoc.replace("_habitat",habitat);
    }

    public ArrayList<String> getGpd() {
        return gpd;
    }

    public void setGpd(ArrayList<String> gpd) {
        this.gpd = gpd;
        animalDoc.replace("_gpd",gpd);
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
        animalDoc.replace("_dateReceived",dateReceived);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        animalDoc.replace("_weight",weight);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
        animalDoc.replace("_length",length);
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}