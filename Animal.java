public class Animal {
    //Name of the Animal species, for ex. Lion/Tiger/Monkey
    private String species;

    // Enclosure in which this animal lives
    //private Enclosure enclosure;

    // Space needed for this animal to live in the enclosure in square meters
    private int areaNeeded;

    private boolean gotCompanion;

    //Constructor Method
    Animal() {
    }

    Animal(String species, int areaNeeded) {
        this.species = species;
        //this.enclosure = enclosure;
        this.areaNeeded = areaNeeded;
        this.gotCompanion = false;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAreaNeeded() {
        return areaNeeded;
    }

    public void setAreaNeeded(int areaNeeded) {
        this.areaNeeded = areaNeeded;
    }

    public boolean hasCompanion() {
        // if (enclosure.getName() ==) {
        return this.gotCompanion;

    }
    public void hasCompanion(boolean gotCompanion) {
        // if (enclosure.getName() ==) {
        this.gotCompanion = gotCompanion;

    }
}


