package homework2;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    private final String familyName;
    private final Map<Person, Set<Relationship>> familyRelationships;

    public Family(String familyName) {
        this.familyName = familyName;
        familyRelationships = new HashMap<>();
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
