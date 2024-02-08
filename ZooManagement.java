import java.util.*;

public class ZooManagement {
    private static ArrayList<Zoo> zooList = new ArrayList<Zoo>();
    private static String[] inputInstruction = new String[2];

    private  void manageZoo() {
        Scanner sc = new Scanner(System.in);
        int userInput = -1;

        while (true) {
            System.out.println("Zoo Management - Manage Zoos");
            System.out.println("1. Create new Zoos");
            System.out.println("2. Delete existing Zoos");
            System.out.println("3. Calculate and output the total area of all enclosures in the Zoo");
            System.out.println("4. Count and output the total number of enclosures");
            System.out.println("5. List Zoos");
            System.out.println("6. Back to the main menu");

            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()){
                userInput = sc.nextInt();
            } else {
                String userTextIn = sc.nextLine();
                userInput = -1;
            }

            switch (userInput) {
                case 1: {
                    System.out.println("Enter Zoo name: ");
                    String name = sc.next();
                    System.out.println("Enter description: ");
                    String description = sc.next();
                    Zoo zoo = new Zoo(name, description);
                    zooList.add(zoo);
                    System.out.println("\nZoo created Successfully");
                    break;
                }
                case 2: {
                    int optIn = -1;
                    int numOfZoos = zooList.size();
                    Zoo objZoo;
                    if (numOfZoos > 0) {
                        for (int n = 0; n < numOfZoos; n++) {
                            objZoo = zooList.get(n);
                            System.out.println(n + 1 + ". " + objZoo.getName());
                        }
                        System.out.print("Enter the Zoo number to delete: ");

                        if (sc.hasNextInt()) {
                            optIn = sc.nextInt();
                        } else {
                            String userTextIn = sc.nextLine();
                            System.out.print("Invalid zoo number selected");
                            break;
                        }

                        if (optIn > numOfZoos) {
                            System.out.print("Invalid zoo number selected");
                            break;
                        } else {
                            optIn = optIn - 1;
                        }

                        System.out.print("If you want to delete " + zooList.get(optIn) + " [y/n]: ");
                        String userInputYesOrNo = sc.next();
                        if (userInputYesOrNo.equalsIgnoreCase("y")) {
                            zooList.remove(optIn);
                            System.out.println("Zoo has been deleted");
                        } else if (userInputYesOrNo.equalsIgnoreCase("n")) {
                            System.out.println("Cancelled");
                        } else
                            System.out.println("Wrong answer");

                    } else {
                        System.out.println("There isn't Zoo, please create");
                    }

                    break;
                }
                case 3: {

                    int totalOccupiedByEnclosure = 0;
                    if (zooList.isEmpty()) {
                        System.out.println("There is no zoo, please create it");
                    } else if (zooList.size() == 1) {
                        if (zooList.get(0).getEnclosure().isEmpty()) {
                            System.out.println("There is no Enclosure, please create it");
                        } else {
                            for (Enclosure enclosure : zooList.get(0).getEnclosure()) {
                                totalOccupiedByEnclosure += enclosure.getUtilisedArea();
                            }

                            System.out.println("\nTotal area of all enclosure in the zoo"
                                                    + totalOccupiedByEnclosure + "square units");
                        }
                    } else {
                        System.out.println("Which zoo are you talking about, there are more than 1?");
                    }
                    break;
                }
                case 4: {
                    if (zooList.isEmpty()) {
                        System.out.println("There is no zoo, please create it");
                    } else if (zooList.size() == 1) {
                        if (!zooList.get(0).getEnclosure().isEmpty()) {
                            System.out.println("There is no Enclosure, please create it");
                        } else {
                            int enclosureSize = zooList.get(0).countEnclosures();
                            System.out.println("\nTotal number of enclosures: " + enclosureSize);
                        }
                    } else {
                        System.out.println("Which zoo are you talking about, there are more than 1?");
                    }
                    break;
                }
                case 5: {
                    int numOfZoos = zooList.size();
                    Zoo objZoo;
                    if (numOfZoos > 0) {
                        for (int i = 0; i < numOfZoos; i++) {
                            objZoo = zooList.get(i);
                            System.out.println(i + 1 + ". " + objZoo.getName());
                        }

                    } else {
                        System.out.println("No Zoo exist!");
                    }
                }
                case 6: {
                    return;
                }
                default: {
                    System.out.println("Invalid option entered, enter value between 1 and 6");
                }
            }
        }
    }

    private static void manageEnclosures() {
        ArrayList<Enclosure> enclosureArrays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();
        int userInput = -1;

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

            System.out.println("Enter your choice: ");
            if (sc.hasNextInt()){
                userInput = sc.nextInt();
            } else {
                String userTextIn = sc.nextLine();
                userInput = -1;
            }

            switch (userInput) {
                // Add enclosure
                case 1: {
                    if (zooList.size() != 0) {
                        System.out.println("\nEnter Enclosure details:");
                        System.out.print("Enter name: ");
                        String name = sc.next();
                        System.out.print("Enter area: ");
                        int area = 0;

                        if (sc.hasNextInt()){
                            area = sc.nextInt();
                        } else {
                            String userTextIn = sc.nextLine();
                            area = -1;
                            System.out.println("\nPlease provide area in numbers:");
                            break;
                        }

                        Enclosure enclosure = new Enclosure(name, area);
                        //enclosureArrays.add(enclosure);
                        zoo.addEnclosure(enclosure);
                        //zooList.get(0).setEnclosures(enclosureArrays);
                        System.out.println("\n" + name + " successfully created in " + zooList.get(0).getName() + "\n");
                    } else {
                        System.out.println("\nThere isn't a zoo, please create");
                    }
                    break;
                }
                case 2: {
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
                }
                case 3: {
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
                }
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

                case 5: {
                    int x = 0;
                    for (Enclosure enclosure : zooList.get(0).getEnclosure()) {
                        ++x;
                        System.out.println(x + "." + enclosure.getName());
                    }
                    System.out.print("Enter you choice: ");
                    int EnclosureDetailsCheck = checkingUserInput();
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
                }
                case 6: {
                    return;
                }
                default: {
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

    public  void managementSystem (){
        System.out.println("Welcome to the Zoo Management System!");
        int userInput;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Zoo Management System");
            System.out.println("1.Manage Zoo");
            System.out.println("2.Manage Enclosure");
            System.out.println("3.Manage Animals");
            System.out.println("4.Exit");

            System.out.println("Enter your choice: ");

            if (sc.hasNextInt()){
                userInput = sc.nextInt();
            } else {
                String userTextIn = sc.nextLine();
                userInput = -1;
            }

            switch (userInput) {
                case 1:
                    //System.out.println("Manage zoo");
                    manageZoo();
                    break;
                case 2:
                    //System.out.println("Manage Enclosures");
                    manageEnclosures();
                    break;
                case 3:
                    System.out.println("Manage Animals");
                    //manageAnimals();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid input, Enter number between 1 to 4");
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

}



