package homework2;

import homework1.Movie;

import java.io.*;
import java.util.HashSet;
import java.util.Map;

public class Controller {
    Family family;
    public void createNewTree(String name){
        family = new Family(name);
    }
    public void saveToFile(String filename){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(family);
            objectOutputStream.close();
        }catch (IOException e){
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }
    }
    public void loadFromFile(String filename){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            family = (Family) objectInputStream.readObject();
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Что-то пошло не так");
            System.out.println("Файл базы не найден");
        }
    }
    public void showTree(){

    }
    public void findInTree(Map<String, String> person){

    }
    public void addRelationship(){

    }
}
