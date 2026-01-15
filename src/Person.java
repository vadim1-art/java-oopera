import java.util.Objects;

class Person {
    protected String name;
    protected String surname;
    protected Gender gender;

    public enum Gender {
        MALE,
        FEMALE
    }

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender);
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Gender getGender() { return gender; }
}