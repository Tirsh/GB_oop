package homework2;

import java.util.*;
import java.util.stream.Collectors;

public class Family {
    private final Map<Person, Set<Relationship>> familyRelationships;

    public Family() {
        familyRelationships = new HashMap<>();
    }

    public Family(Map<Person, Set<Relationship>> familyRelationships) {
        this.familyRelationships = familyRelationships;
    }

    public Person[] getWomen(){
        return familyRelationships.keySet().stream().filter(i -> !i.isMale()).toArray(Person[]::new);
    }
    public Person[] getSingle(boolean male){
        List<Person> men = new ArrayList<>();
        for (Person person:familyRelationships.keySet().stream().filter(i -> male == i.isMale()).toArray(Person[]::new))
            if (familyRelationships.get(person).stream()
                    .noneMatch(i -> i.getRelationshipsKind() == RelationshipsKind.Spouse))
                men.add(person);
        return men.toArray(Person[]::new);
    }

    public void addMember(Person person){
        if (!familyRelationships.containsKey(person))
            familyRelationships.put(person, new HashSet<>());
    }
    public void marriage(Person husband, Person wife){
        Relationship newMarriage = new Relationship(RelationshipsKind.Spouse, husband, wife);
        familyRelationships.computeIfAbsent(husband, s -> new HashSet<>()).add(newMarriage);
        familyRelationships.computeIfAbsent(wife, s -> new HashSet<>()).add(newMarriage);
    }
    public void childBirth(Person mother, Person child){
        Relationship motherChild = new Relationship(RelationshipsKind.ParentChild, mother, child);
        familyRelationships.computeIfAbsent(mother, s -> new HashSet<>()).add(motherChild);
        familyRelationships.computeIfAbsent(child, s -> new HashSet<>()).add(motherChild);
        Optional<Relationship> fatherChild = familyRelationships.get(mother).stream()
                .filter(k->k.getRelationshipsKind() == RelationshipsKind.Spouse).findFirst()
                .map(relationship -> new Relationship(RelationshipsKind.ParentChild, relationship.getPersonA(), child));
        if(fatherChild.isPresent()){
            familyRelationships.computeIfAbsent(fatherChild.get().getPersonA(), s -> new HashSet<>()).add(fatherChild.get());
            familyRelationships.get(child).add(fatherChild.get());
        }
    }
    public void composeTree(){
        List<Person> first = new ArrayList<>();
        for (Person person:familyRelationships.keySet()){
            if (familyRelationships.get(person).stream()
                    .anyMatch(i -> i.getRelationshipsKind() == RelationshipsKind.ParentChild && i.getPersonB() != person && !person.isMale()))
                first.add(person);
        }
        if (findRoot(first.toArray(Person[]::new)).length != 0)
            showTree(findRoot(first.toArray(Person[]::new))[0], "");
        else System.out.println("Дерево пустое!");


    }
    private Person[] findRoot(Person[] persons){
        Set<Person> next = new HashSet<>();
        for (Person person: persons) {
            next.addAll(familyRelationships.get(person).stream()
                    .filter(i -> i.getRelationshipsKind() == RelationshipsKind.ParentChild && i.getPersonA() == person)
                    .map(Relationship::getPersonB).collect(Collectors.toSet()));
        }
        if (next.isEmpty() && persons.length <= 1)
            return persons;
        else
            return findRoot(next.toArray(Person[]::new));
    }
    public void showTree(Person root, String sep){
        System.out.println(sep + "\\");
        root.showPerson(sep);
        sep = sep + "\t";
        Set<Person> newRoot = familyRelationships.get(root).stream()
                .filter(i -> i.getRelationshipsKind() == RelationshipsKind.ParentChild && i.getPersonB() == root)
                .map(Relationship::getPersonA).collect(Collectors.toSet());
        if (!newRoot.isEmpty())
            for (Person person: newRoot)
                showTree(person, sep);
    }

    public Map<Person, Set<Relationship>> getFamilyRelationships() {
        return familyRelationships;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person:familyRelationships.keySet()){
            stringBuilder.append(person);
            stringBuilder.append("\n");
            for (Relationship relationship:familyRelationships.get(person)){
                stringBuilder.append(relationship);
                stringBuilder.append("\n");
            }
            stringBuilder.append("__________\n");
        }
        return stringBuilder.toString();
    }
}
