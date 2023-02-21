package fr.quarkus.openshift.models;

public class God {

    // Attributes

    private String name;
    private String place;
    private String country;
    private String divinityGroup;

    // Constructors

    public God() {
    }

    public God(String name, String place, String country, String divinityGroup) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");

        this.name = name;
        this.place = place;
        this.country = country;
        this.divinityGroup = divinityGroup;
    }

    // Setters and getters

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDivinityGroup(String divinityGroup) {
        this.divinityGroup = divinityGroup;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getCountry() {
        return country;
    }

    public String getDivinityGroup() {
        return divinityGroup;
    }
}
