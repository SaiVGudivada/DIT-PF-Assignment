/*
* - name : String
* - area : int
* - animals : ArrayList<Animal>
* + <<constructor>> Enclosure(name : String, area : int, animals : ArrayList<Animal> )
* + countAnimals() : int
* + getUtilisedArea() : int
* + getUtilisedAreaPercentage() : double
* + countSpecies() : int
* + addAnimal( animal : Animal ) : bool
* */

import java.util.ArrayList;

public class Enclosure {
    private String Name;
    private int Area ;
    private ArrayList<Animal> Animals;

    //Constructor method
    Enclosure(){
        this.Animals = new ArrayList<Animal>();
    }
    Enclosure(String name, int area){
        this.Name = name;
        this.Area = area;
        this.Animals = new ArrayList<Animal>();
    }
    Enclosure(String name, int area, Animal objAnimal){
        this.Name = name;
        this.Area = area;
        this.Animals = new ArrayList<Animal>();
        this.Animals.add(objAnimal);
    }

    public void setName(String name){
        this.Name = name;
    }

    public String getName(){
        return this.Name;
    }
    public void setArea(int area){
        this.Area = area;
    }

    public int getArea(){
        return this.Area;
    }
    public ArrayList<Animal> getAnimals(){
        return this.Animals;
    }
    public void  setAnimals(ArrayList<Animal> animals){
        this.Animals = animals;
    }
    public int countAnimals(){
        return 0;
    }
    public int getUtilisedArea(){
        return 0;
    }
    public double getUtilisedAreaPercentage(){
        return 0;
    }
    public int countSpecies(){
        return 0;
    }
    public boolean addAnimal(){
        return false;
    }
}





