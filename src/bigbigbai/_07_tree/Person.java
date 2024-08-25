package bigbigbai._07_tree;

public class Person implements Comparable<Person> {
    int age;
    String name;

    public int compareTo(Person p) {
        return this.age - p.age;
    }
}
