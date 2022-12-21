package homework2;

import java.io.*;
import java.util.*;

public class Controller {
    private final String workDirectory = "src/homework2/";
    private final Deque<Person> personStack = new ArrayDeque<>();
    private Family family;

    public Controller() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(workDirectory + "default.tree"));
            family = new Family((Map<Person, Set<Relationship>>) objectInputStream.readObject());
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("new");
            family = new Family();
        }
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
    public void loadFromFile(String filename){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(workDirectory + filename));
             family = new Family((Map<Person, Set<Relationship>>) objectInputStream.readObject());
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Что-то пошло не так");
            System.out.println("Файл базы не найден");
        }
    }
    public void showTree(){
        family.composeTree();
    }
    public void findInTree(String firstName, String secondName){
        for (Person person: family.getFamilyRelationships().keySet()){
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(secondName)){
                family.showTree(person, "");
            }
        }
    }
    public void addPerson(Person person){
        personStack.addLast(person);
        family.addMember(person);
    }
    public void addRelationship(Integer r){
        switch (r) {
            case 1 -> {
                Person husband = personStack.pollFirst();
                Person wife = personStack.pollFirst();
                if (husband != null && wife != null)
                    family.marriage(husband, wife);
            }
            case 2 -> {
                Person mother = personStack.pollFirst();
                Person baby = personStack.pollFirst();
                if (mother != null && baby != null)
                    family.childBirth(mother, baby);
            }
        }
        personStack.clear();
    }
    public Person[] getWoman(){
        return family.getWomen();
    }
    public Person[] getSingleMen(){
        return family.getSingle(true);
    }
    public Person[] getSingleWomen(){
        return family.getSingle(false);
    }

    public void clearPersonStack() {
        personStack.clear();
    }
}
