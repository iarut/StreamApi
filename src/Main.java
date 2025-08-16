import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> numbersStream=Stream.of(1,3,5,6,7,8);
        Optional<Integer> result=numbersStream.reduce((x,y)->x+y);
        System.out.println(result);
        Stream<String>wordsStream=Stream.of("я","учусь","програмировать");
        Optional<String>result1=wordsStream.reduce((x,y)->x+y);
        System.out.println(result1);
        Stream<Car>carStream=Stream.of(new Car("1",100),new Car("2",200));
        int sum=carStream.reduce(0,
                (x,y)->{
            if(y.getSpeed()<200)
                return x+y.getSpeed();
            else
                return x+150;
                },
                (x,y)->x+y);
        System.out.println(sum);
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{1,2,4,5,8,9}));
        Optional<Integer> min=numbers.stream().min(Integer::compare);
        System.out.println(min.get());
    }
    static class Car{
        public Car() {
            super();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
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
            return super.toString();
        }

        public Car(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        String name;

        public Car(int speed, String name) {
            this.speed = speed;
            this.name = name;
        }

        int speed;
        public String getName() {
            return name;
        }
        public int getSpeed(){
            return speed;
        }
    }

}
//hello world
