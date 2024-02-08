import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZooOldManagement {
    private static ArrayList<Zoo> zooList = new ArrayList<>();
    private static String[] inputInstruction = new String[2];

    private static void manageZoo() {
        Zoo zoo = new Zoo();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Zoo Management - Manage Zoos");
            System.out.println("1. Create new Zoos");
            System.out.println("2. Delete existing Zoos");
            System.out.println("3. Calculate and output the total area of all enclosures in the Zoo");
            System.out.println("4. Count and output the total number of enclosures");
            System.out.println("5. Back to the main menu");

            if (inputInstruction[0] != null) {
                System.out.print(inputInstruction[0]);
                inputInstruction[0] = null;
            } else if (inputInstruction[1] != null) {
                System.out.print(inputInstruction[1]);
                inputInstruction[1] = null;
            } else
                System.out.print("Enter your choice: ");

            int userInput = checkingUserInput();
            if (userInput != 0) {
                switch (userInput) {
                    case 1:
                        System.out.print("Enter Zoo name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter description: ");
                        String description = sc.nextLine();
                        zoo.setName(name);
                        zoo.setDescription(description);
                        zooList.add(zoo);
                        System.out.println("\nZoo created Successfully");
                        break;

                    case 2:
                        int i = 0;
                        if (zooList.size() != 0) {
                            System.out.print("If you want to delete Zoo [y/n]: ");
                            String userInputYesOrNo = sc.next();
                            if (userInputYesOrNo.equalsIgnoreCase("y")) {
                                zooList.remove(0);
                                System.out.println("Zoo has been deleted");
                            } else if (userInputYesOrNo.equalsIgnoreCase("n")) {
                                System.out.println("Cancelled");
                            } else
                                System.out.println("Wrong answer");
                        } else
                            System.out.println("There isn't Zoo, please create");
                        break;

                    case 3:

                        int totalOccupiedByEnclosure = 0;
                        if (zooList.size() != 0) {
                            if (zooList.get(0).getEnclosure().size() != 0) {
                                for (Enclosure enclosure : zooList.get(0).getEnclosure()) {
                                    totalOccupiedByEnclosure += enclosure.getUtilisedArea();
                                }
                                System.out.println("\nTotal area of all enclosure in the zoo"
                                        + totalOccupiedByEnclosure + "square units");
                            } else
                                System.out.println("There is no Enclosure, please create it");
                        } else
                            System.out.println("There is no zoo,please create it");
                        break;

                    case 4:
                        if (zooList.size() != 0) {
                            if (zooList.get(0).getEnclosure().size() != 0) {
                                int enclosureSize = zooList.get(0).getEnclosure().size();
                                System.out.println("\nTotal number of enclosure is: " + enclosureSize);
                            } else
                                System.out.println("There is no Enclosure, please create it");
                        } else
                            System.out.println("There is no zoo, please create it");
                        break;
                    case 5:
                        return;
                    default:
                        inputInstruction[0] = "Please enter below the option only:";

                }
            }
        }
    }

    private static void manageEnclosures() {
        ArrayList<Enclosure> enclosureArrays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();
        while (true) {
            System.out.println("""
                    \nZoo Management - Manage Enclosures
                    1. Add an Enclosure to a Zoo
                    2. Delete an existing Enclosure from a Zoo
                    3. Get utilised area in a given enclosure
                    4. Get percentage of utilised area in a given enclosure
                    5. Count number of species in an enclosure
                    6. Back to main menu
                    """);

            if (inputInstruction[0] != null) {
                System.out.print(inputInstruction[0]);
                inputInstruction[0] = null;
            } else if (inputInstruction[1] != null) {
                System.out.print(inputInstruction[1]);
                inputInstruction[1] = null;
            } else
                System.out.println("Enter your choice");

            int userInput = checkingUserInput();
            if (userInput != 0) {
                switch (userInput) {
                    case 1:
                        if (zooList.size() != 0) {
                            System.out.println("\nEnter Enclosure details:");
                            System.out.print("Enter name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter area: ");
                            int area = 0;
                            try {
                                area = sc.nextInt();
                                sc.nextLine();
                                Enclosure enclosure = new Enclosure();
                                enclosure.setName(name);
                                enclosure.setArea(area);
                                enclosureArrays.add(enclosure);
                                zoo.setEnclosures(enclosureArrays);
                                zooList.get(0).setEnclosures(enclosureArrays);
                                System.out.println("\n" + name + " successfully created in " + zooList.get(0).getName() + "\n");
                            } catch (InputMismatchException e) {
                                System.out.println("\nPlease provide area in numbers:");
                            }
                        } else
                            System.out.println("\nThere isn't a zoo, please create");
                        break;
                    case 2:
                        int i = 0;
                        if (zooList.size() != 0) {
                            System.out.println("\nSelect an enclosure:");
                            for (Enclosure enclosureLoop : zooList.get(0).getEnclosure()) {
                                ++i;
                                System.out.println(i + "." + enclosureLoop.getName());
                            }
                            System.out.print("\nEnter your choice: ");

                            userInput = checkingUserInput();
                            if (userInput != 0) {
                                if (userInput <= zoo.getEnclosure().size() && userInput >= 1) {
                                    System.out.print("\n If you want to delete Zoo[y/n]: ");
                                    String userInputYesOrNo = sc.next();
                                    if (userInputYesOrNo.equalsIgnoreCase("y")) {
                                        zooList.get(0).getEnclosure().remove(userInput - 1);
                                        System.out.println("\nEnclosure successfully deleted from " + zooList.get(0).getName());
                                    } else if (userInputYesOrNo.equalsIgnoreCase("n")) {
                                        System.out.println("\nCancelled.");
                                    } else
                                        System.out.println("\nWrong answer.");
                                } else
                                    System.out.print("\n Please provide below the option only");
                            } else
                                System.out.print("\n" + inputInstruction[1]);
                        } else
                            System.out.print("\n There isn't Zoo,please create");
                        break;
                    case 3:
                        boolean flag = false;
                        int x = 0;
                        for (Enclosure enclosures : zooList.get(0).getEnclosure()) {
                            ++x;
                            System.out.println(x + "." + enclosures.getName());
                        }
                        System.out.println("Enter you choice: ");
                        int EnclosureDetailsCheck = checkingUserInput();
                        if (EnclosureDetailsCheck > 1) {
                            if (EnclosureDetailsCheck <= zooList.get(0).getEnclosure().size() && EnclosureDetailsCheck >= 1) {
                                int countTotalSpecies = zooList.get(0).getEnclosure()
                                        .get(EnclosureDetailsCheck - 1)
                                        .getAnimals().size();
                                if (countTotalSpecies != 0)
                                    flag = true;
                            } else
                                System.out.println("\nPlease provide below the option only");
                        } else
                            System.out.println(inputInstruction[1]);
                        System.out.println(flag);
                        break;

                    case 4:
                        int m = 0;
                        for (Enclosure enclosure : zooList.get(0).getEnclosure()) {
                            ++m;
                            System.out.println(m + "." + enclosure.getName());
                        }
                        System.out.print("Enter your choice:");
                        int EnclosureDetail = checkingUserInput();
                        if (EnclosureDetail != 0) {
                            if (EnclosureDetail <= zooList.get(0).getEnclosure().size() && EnclosureDetail >= 1) {
                                int area = zooList.get(0).getEnclosure()
                                        .get(EnclosureDetail - 1)
                                        .getUtilisedArea();
                                int areaForAnimal = zooList.get(0).getEnclosure()
                                        .get(EnclosureDetail - 1)
                                        .getAnimals()
                                        .get(0)
                                        .getAreaNeeded();
                                double getTotalAreaPercentage = ((double) areaForAnimal / area);
                                System.out.println("percentage of utilised area in enclosure" + getTotalAreaPercentage);
                            } else
                                System.out.println("\n please provide below the option only");
                        } else
                            System.out.println(inputInstruction[1]);
                        break;

                    case 5:
                        x = 0;
                        for (Enclosure enclosure : zooList.get(0).getEnclosure()) {
                            ++x;
                            System.out.println(x + "." + enclosure.getName());
                        }
                        System.out.print("Enter you choice: ");
                        EnclosureDetailsCheck = checkingUserInput();
                        if (EnclosureDetailsCheck != 0) {
                            if (EnclosureDetailsCheck <= zooList.get(0).getEnclosure().size() && EnclosureDetailsCheck >= 1) {
                                int countTotalSpecies = zooList.get(0).getEnclosure()
                                        .get(EnclosureDetailsCheck - 1)
                                        .getAnimals().size();
                                System.out.println("Total number of species is: " + countTotalSpecies);
                            } else
                                System.out.println("\nPlease provide below the option only");
                        } else
                            System.out.println(inputInstruction[1]);
                        break;
                    case 6:
                        return;
                    default:
                        inputInstruction[0] = "Please enter below the option only: ";
                        break;
                }
            }
        }
    }


    private static void manageAnimals() {
        ArrayList<Animal> animalsList = new ArrayList<>();
        Enclosure enclosure = new Enclosure();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    \nZoo Management - Manage Animals
                    1. Add animals to an enclosure
                    2. Remove animals from an enclosure
                    3. Check if an animal has a companion in its enclosure
                    4. Back to the main menu
                    """);

            if (inputInstruction[0] != null) {
                System.out.print(inputInstruction[0]);
                inputInstruction[0] = null;
            } else if (inputInstruction[1] != null) {
                System.out.print(inputInstruction[1]);
                inputInstruction[1] = null;
            } else {
                System.out.print("Enter your choice: ");
            }

            int userInput = checkingUserInput();
            if (userInput != 0) {
                switch (userInput) {
                    case 1:
                        if (zooList.size() != 0) {
                            int i = 0;
                            if (zooList.get(0).getEnclosure().size() != 0) {
                                System.out.println("\nEnclosure details: ");
                                for (Enclosure enclosureLoop : zooList.get(0).getEnclosure()) {
                                    ++i;
                                    System.out.println(i + ".Name: " + enclosureLoop.getName() + "Area:" + enclosureLoop.getUtilisedArea());
                                }
                                System.out.print("Enter you choice: ");
                                int EnclosureDetails = checkingUserInput();
                                if (EnclosureDetails != 0) {
                                    if (EnclosureDetails <= zooList.get(0).getEnclosure().size() && EnclosureDetails >= 1) {
                                        System.out.println("\nEnter animal details");
                                        System.out.print("Enter species name: ");
                                        String species = sc.nextLine();
                                        System.out.print("Enter area need for species:");
                                        userInput = checkingUserInput();
                                        if (userInput != 0) {
                                            if (userInput <= zooList.get(0).getEnclosure().get(EnclosureDetails - 1).getUtilisedArea()) {
                                                Animal animal = new Animal();
                                                animal.setSpecies(species);
                                                animal.setAreaNeeded(userInput);
                                                animalsList.add(animal);
                                                enclosure.setAnimals(animalsList);
                                                zooList.get(0).getEnclosure().get(EnclosureDetails - 1)
                                                        .setAnimals(animalsList);
                                                System.out.println("\n" + species + " has been Saved in" + zooList.get(0)
                                                        .getEnclosure()
                                                        .get(EnclosureDetails - 1)
                                                        .getUtilisedArea());
                                            } else
                                                System.out.println("\nThere is not much space for this");
                                        } else
                                            System.out.print(inputInstruction[1]);
                                    } else
                                        System.out.println("\nPlease provide below  options only");

                                } else
                                    System.out.print(inputInstruction[1]);

                            } else
                                System.out.println("\nThere isn't Enclosure, please create");

                        } else
                            System.out.println("\nThere isn't Zoo, please create");
                        break;

                    case 2:
                        if (zooList.size() != 0) {
                            int i = 0;
                            System.out.println("\nList Of animals: ");
                            if (zooList.get(0).getEnclosure().size() != 0) {
                                int enclosureSize = zooList.get(0).getEnclosure().size() - 1;
                                for (Animal animalLoop : zooList.get(0).getEnclosure().get(enclosureSize).getAnimals()) {
                                    ++i;
                                    System.out.println(i + "." + animalLoop.getSpecies());
                                }
                                System.out.print("\nEnter your choice: ");
                                int animalDetails = checkingUserInput();
                                if (animalDetails != 0) {
                                    if (animalDetails <= zooList.get(0).getEnclosure().get(enclosureSize).getAnimals().size()
                                            && animalDetails != 1) {
                                        System.out.print("\nIf you want to delete Zoo [y/n]: ");
                                        String userInputYesOrNo = sc.next();
                                        if (userInputYesOrNo.equalsIgnoreCase("y")) {
                                            zooList.get(0).getEnclosure()
                                                    .get(enclosureSize)
                                                    .getAnimals()
                                                    .remove(animalDetails - 1);
                                            System.out.println("\n animals has been removed from " + zooList.get(0).getName());
                                        } else if (userInputYesOrNo.equalsIgnoreCase("n")) {
                                            System.out.println("\nCancelled");
                                        } else
                                            System.out.println("\n Wrong answer");
                                    } else
                                        System.out.println("please provide below the option only: ");
                                } else
                                    System.out.println(inputInstruction[1]);
                            } else
                                System.out.println("\n There isn't Enclosure, please create");
                        } else
                            System.out.println("\nThere isn't Zoo,please create");
                        break;

                    case 3:
                        boolean flag = false;
                        int x = 0;
                        for (Enclosure enclosures : zooList.get(0).getEnclosure()) {
                            ++x;
                            System.out.println(x + "." + enclosures.getName());
                        }
                        System.out.print("Enter your choice: ");
                        int EnclosureDetailsCheck = checkingUserInput();
                        if (EnclosureDetailsCheck > 1) {
                            if (EnclosureDetailsCheck <= zooList.get(0).getEnclosure().size() && EnclosureDetailsCheck >= 1) {
                                int countTotalSpecies = zooList.get(0).getEnclosure()
                                        .get(EnclosureDetailsCheck - 1)
                                        .getAnimals().size();
                                if (countTotalSpecies != 0)
                                    flag = true;

                            } else
                                System.out.println("\nPlease provide below the option only");
                        } else
                            System.out.println(inputInstruction[1]);
                        System.out.println(flag);
                        break;
                    case 4:
                        return;
                    default:
                        inputInstruction[0] = "Please enter below the option only: ";
                }
            }
        }
    }

    private static void managementSystem (){
        System.out.println("Welcome to the Zoo Management System!");
        while (true) {
            System.out.println("""
                        \nZoo Management System\r
                        1.Manage Zoo\r
                        2.Manage Enclosure\r
                        3.Manage Animals\r
                        4.Exit
                        """);
            if (inputInstruction[0] != null) {
                System.out.println(inputInstruction[0]);
                inputInstruction[0] = null;
            } else if (inputInstruction[1] != null) {
                System.out.println(inputInstruction[1]);
                inputInstruction[1] = null;
            } else
                System.out.println("Enter your choice: ");
            int userInput = checkingUserInput();
            if (userInput != 0) {
                switch (userInput) {
                    case 1:
                        manageZoo();
                        break;
                    case 2:
                        manageEnclosures();
                        break;
                    case 3:
                        manageAnimals();
                        break;
                    case 4:
                        return;
                    default:
                        inputInstruction[0] = "Please enter below the option only: ";
                }
            }
        }
    }

    private static int checkingUserInput () {
        int userInput = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            userInput = sc.nextInt();
        } else
            inputInstruction[1] = "You must be enter number only: ";
        return userInput;
    }

//    public static void main(String[] args){
//        managementSystem();
//    }
}



