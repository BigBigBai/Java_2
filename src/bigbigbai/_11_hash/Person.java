package bigbigbai._11_hash;

import java.util.HashMap;
import java.util.Objects;

public class Person {
    private int age;
    private float height;
    private String name;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hashCode = Integer.hashCode(this.age);
        hashCode = hashCode * 31 + Float.hashCode(this.height);
        hashCode = hashCode * 31 + (this.name != null ? this.name.hashCode() : 0);
        return hashCode;
    }

    /**
     * Override equals: When happen hash collision, use it to compare 2 keys the same or not
     * Assume a index position links multiple node (bucket)
     * When insert a data, ...
     * Must See Note
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Float.compare(height, person.height) == 0 && Objects.equals(name, person.name);
    }





    public static void main(String[] args) {
        Person p1 = new Person(54, 17.7f, "jeff");//-262661225
        Person p2 = new Person(45, 18.2f, "pony");//-254354787
        Person p3 = new Person(54, 17.7f, "jeff");//-262661225

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p1 == p3);
        System.out.println(p1.equals(p3));

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(p1, 999);
        map.put(p2, 222);
        map.put(p3, 555);
        System.out.println(map.size());
    }
}
