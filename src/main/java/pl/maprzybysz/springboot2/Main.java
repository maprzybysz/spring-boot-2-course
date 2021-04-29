package pl.maprzybysz.springboot2;

public class Main {

    public static void main(String[] args) {
        Car car = new CarBuilder().setWheel(4).setColor("Red").createCar();
        System.out.println(car);
    }
}
