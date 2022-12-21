package homework2;

import java.io.Serializable;

public class Relationship implements Serializable {
    private final Person personA;
    private final Person personB;
    private final RelationshipsKind relationshipsKind;

    public Relationship(RelationshipsKind relationshipsKind, Person personA, Person personB) {
        this.personA = personA;
        this.personB = personB;
        this.relationshipsKind = relationshipsKind;
    }

    public Person getPersonA() {
        return personA;
    }

    public Person getPersonB() {
        return personB;
    }

    public RelationshipsKind getRelationshipsKind() {
        return relationshipsKind;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                ", relationshipsKind=" + relationshipsKind +
                ", personA=" + personA +
                ", personB=" + personB +
                '}';
    }
}
