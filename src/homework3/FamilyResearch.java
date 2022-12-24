package homework3;

import homework3.model.Family;
import homework3.model.Person;
import homework3.model.Relationship;
import homework3.model.RelationshipsKind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Компонента для работы с моделью генелогического древа - Family
 * Содержит методы поиска в моделе:
 * getWomen - все женщины содержажиеся в древе
 * getSingle - поиск объектов без связи супружество
 * Используются для корректного формирования новых связей.
 * Методы поиска корня в древе и вывода информации:
 * composeAndShowFamilyTree, findRoot, showFamilyTree
 */
public class FamilyResearch {
    private Family family;

    public FamilyResearch(Family family) {
        this.family = family;
    }

    public Person[] getWomen(){
        return family.getFamilyRelationships().keySet().stream().filter(i -> !i.isMale()).toArray(Person[]::new);
    }

    public Person[] getSingle(boolean male){
        List<Person> men = new ArrayList<>();
        for (Person person:family.getFamilyRelationships().keySet().stream().filter(i -> male == i.isMale()).toArray(Person[]::new))
            if (family.getFamilyRelationships().get(person).stream()
                    .noneMatch(i -> i.getRelationshipsKind() == RelationshipsKind.Spouse))
                men.add(person);
        return men.toArray(Person[]::new);
    }
    public void composeAndShowFamilyTree(){
        List<Person> first = new ArrayList<>();
        for (Person person:family.getFamilyRelationships().keySet()){
            if (family.getFamilyRelationships().get(person).stream()
                    .anyMatch(i -> i.getRelationshipsKind() == RelationshipsKind.ParentChild && i.getPersonB() != person && !person.isMale()))
                first.add(person);
        }
        if (findRoot(first.toArray(Person[]::new)).length != 0)
            showFamilyTree(findRoot(first.toArray(Person[]::new))[0], "");
        else System.out.println("Дерево пустое!");
    }
    private Person[] findRoot(Person[] persons){
        Set<Person> next = new HashSet<>();
        for (Person person: persons) {
            next.addAll(family.getFamilyRelationships().get(person).stream()
                    .filter(i -> i.getRelationshipsKind() == RelationshipsKind.ParentChild && i.getPersonA() == person)
                    .map(Relationship::getPersonB).collect(Collectors.toSet()));
        }
        if (next.isEmpty() && persons.length <= 1)
            return persons;
        else
            return findRoot(next.toArray(Person[]::new));
    }
    public void showFamilyTree(Person root, String sep){
        System.out.println(sep + "\\");
        root.showPerson(sep);
        sep = sep + "\t";
        Set<Person> newRoot = family.getFamilyRelationships().get(root).stream()
                .filter(i -> i.getRelationshipsKind() == RelationshipsKind.ParentChild && i.getPersonB() == root)
                .map(Relationship::getPersonA).collect(Collectors.toSet());
        if (!newRoot.isEmpty())
            for (Person person: newRoot)
                showFamilyTree(person, sep);
    }
}
