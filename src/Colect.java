import java.util.*;
import java.util.stream.Collectors;

public class Colect {
    public static void main(String[] args) {
        List<Car> cars= new ArrayList<Car>();
        cars.add(new Car("мерседес",100));
        cars.add(new Car("bmw",160));
        cars.add(new Car("lexus",400));

        cars.add(new Car("lada",100));
        Car bentley = new Car("Bentley",240);

        cars.add(bentley);
        cars.add(bentley);
        for (Car car : cars) {
            if (car.getSpeed()>200) {
                System.out.println(car);
            }
        }
Set<Car> set =cars
        .stream()
        .filter(c->c.getSpeed()>200)
        .collect(Collectors.toSet());

        System.out.println(set);
        Map<String,Integer> map = cars.stream().distinct().collect(Collectors.toMap(Car::getName,c->c.getSpeed()));
        System.out.println(map);
        Map<Integer,List<Car>> speedmap=cars.stream().collect(Collectors.groupingBy(Car::getSpeed));
        System.out.println(speedmap);
        Map<Boolean,List<Car>> partotionmap=cars.stream().collect(Collectors.partitioningBy(c->c.getSpeed()>150&& c.getName().toUpperCase().startsWith("B")));
        System.out.println(partotionmap);
        Map<Integer,Long> group=cars.stream().collect(Collectors.groupingBy(Car::getSpeed,Collectors.counting()));
        System.out.println(group);
        Map<String,Integer> summ=cars.stream().collect(Collectors.groupingBy(Car::getName,Collectors.summingInt(Car::getSpeed)));
        System.out.println(summ);
        Map<String, Optional<Car>> min=cars.stream().collect(Collectors.groupingBy(Car::getName,Collectors.minBy(Comparator.comparing(Car::getSpeed))));
        System.out.println(min);
        Map<String, IntSummaryStatistics> sum=cars.stream().collect(Collectors.groupingBy(Car::getName,Collectors.summarizingInt(Car::getSpeed)));
        System.out.println(sum);
        Map<String, Set<Integer>> mapi=cars.stream().collect(Collectors.groupingBy(Car::getName,Collectors.mapping(Car::getSpeed,Collectors.toSet())));
        System.out.println(mapi);
        for(Map.Entry<String,IntSummaryStatistics> entry:sum.entrySet()){
            System.out.println("/////////////////////////////");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getMax());
            System.out.println(entry.getValue().getMin());
            System.out.println(entry.getValue().getCount());
        }
    }
}
 class Car{
    private String name;
    private int speed;

     public String getName() {
         return name;
     }


     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Car car = (Car) o;
         return speed == car.speed && Objects.equals(name, car.name);
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, speed);
     }

     @Override
     protected Object clone() throws CloneNotSupportedException {
         return super.clone();
     }

     @Override
     public String toString() {
         return name+" "+speed;

     }

     public void setName(String name) {
         this.name = name;
     }

     public int getSpeed() {
         return speed;
     }

     public void setSpeed(int speed) {
         this.speed = speed;
     }

     public Car() {
     }

     public Car(String name, int speed) {
         this.name = name;
         this.speed = speed;
     }
 }
