package homework3;

import java.util.*;

/**
 * Компонента связывающая множество объектов человек - Person между собой через компонент связей Relationship
 * Содержит методы добаления новых членов множества - addMember
 * и методы добавления новых связей:
 * marriage - супружество
 * childBirth - рождение ребенка
 */
public class Family {
    private final Map<Person, Set<Relationship>> familyRelationships;

    public Family() {
        familyRelationships = new HashMap<>();
    }

    public Family(Map<Person, Set<Relationship>> familyRelationships) {
        this.familyRelationships = familyRelationships;
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
