package homework3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class Controller {
    private final String workDirectory = "src/homework3/";
    private final Deque<Person> relationshipStack = new ArrayDeque<>();
    private Family family;
    private FamilyResearch familyResearch;

    public Controller() {
        if (!loadFromFile("default.tree"))
            family = new Family();
        familyResearch = new FamilyResearch(family);
    }

    public void createNewTree(){
        family = new Family();
    }
    public void saveToFile(String filename){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(workDirectory + filename));
            objectOutputStream.writeObject(family.getFamilyRelationships());
            objectOutputStream.close();
        }catch (IOException e){
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }
    }
    public boolean loadFromFile(String filename){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(workDirectory + filename));
            family = new Family((Map<Person, Set<Relationship>>) objectInputStream.readObject());
            objectInputStream.close();
            return true;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Что-то пошло не так");
            System.out.println("Файл базы не найден");
            return false;
        }
    }
    public void showTree(){
        familyResearch.composeAndShowFamilyTree();
    }
    public void findInTree(String firstName, String secondName){
        for (Person person: family.getFamilyRelationships().keySet()){
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(secondName)){
                familyResearch.showFamilyTree(person, "");
            }
        }
    }
    public void addPerson(Person person){
        relationshipStack.addLast(person);
        family.addMember(person);
    }
    public void addRelationship(Integer r){
        switch (r) {
            case 1 -> {
                Person husband = relationshipStack.pollFirst();
                Person wife = relationshipStack.pollFirst();
                if (husband != null && wife != null)
                    family.marriage(husband, wife);
            }
            case 2 -> {
                Person mother = relationshipStack.pollFirst();
                Person baby = relationshipStack.pollFirst();
                if (mother != null && baby != null)
                    family.childBirth(mother, baby);
            }
        }
        relationshipStack.clear();
    }
    public Person[] getWoman(){
        return familyResearch.getWomen();
    }
    public Person[] getSingleMen(){
        return familyResearch.getSingle(true);
    }
    public Person[] getSingleWomen(){
        return familyResearch.getSingle(false);
    }

    public void clearPersonStack() {
        relationshipStack.clear();
    }
}
