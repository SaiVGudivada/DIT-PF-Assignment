/*
- name : String
- description : String
- enclosures : ArrayList<Enclosure>
+ <<constructor>> Zoo(name : String, description : String,enclosures : ArrayList<Enclosure>)
+ getTotalEnclosureArea() : int
+ countEnclosures() : int
* */
import java.util.ArrayList;

public class Zoo{
    private String name;
    private  String description;
    private ArrayList<Enclosure> enclosures;

    public Zoo(String name,String description){
        this.name = name;
        this.description = description;
        this.enclosures = new ArrayList<Enclosure>();
    }

    public Zoo(String name,String description,ArrayList<Enclosure> enclosures){
        this.name=name;
        this.description=description;
        this.enclosures=enclosures;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return  description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public ArrayList<Enclosure> getEnclosure() {
        return enclosures;
    }
    public void setEnclosures(ArrayList<Enclosure>enclosures){
        this.enclosures=enclosures;
    }

    public void addEnclosure(Enclosure newEnclosure) {
        this.enclosures.add(newEnclosure);
    }

    public int getTotalEnclosureArea(){
        int totalEnclosuresArea=0;
        for(Enclosure enclosureLoop: enclosures){
            totalEnclosuresArea += enclosureLoop.getUtilisedArea();
        }
        return  totalEnclosuresArea;
    }

    public int countEnclosures(){
        int countEnclosures = enclosures.size();
        return countEnclosures;
    }
    public Zoo() {
    }
}


