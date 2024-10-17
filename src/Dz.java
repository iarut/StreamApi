import java.util.*;
import java.util.stream.Collectors;

public class Dz {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("бобик",10));
        dogs.add(new Dog("бобик",10));
        dogs.add(new Dog("бобик",10));
        dogs.add(new Dog("шарик",20));
        dogs.add(new Dog("шарик",20));
        dogs.add(new Dog("шарик",20));
        dogs.add(new Dog("мухтар",13));
        dogs.add(new Dog("бобик",14));
        dogs.add(new Dog("рекс",15));
        for (Dog dog : dogs) {
            if (dog.getAge()>12){
                System.out.println(dog);
            }
        }
        Set<Dog> set =dogs
                .stream()
                .filter(c->c.getAge()>12)
                .collect(Collectors.toSet());

        System.out.println(set);
        Map<Integer,List<Dog>> map=dogs.stream().collect(Collectors.groupingBy(Dog::getAge));
        System.out.println(map);
        Map<String,Long> count=dogs.stream().collect(Collectors.groupingBy(Dog::getName,Collectors.counting()));
        System.out.println(count);
    }

}
class Dog {
    String name;
   private int age;

    public Dog() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
