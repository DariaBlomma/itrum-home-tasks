import collection.task1.FilterMain;
import collection.task1.FilterTest;
import core.task1.CareTaker;
import core.task1.Task1Tests;

public class Main {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();

        careTaker.append("First string");
        System.out.println(careTaker);

        careTaker.append("Second string");
        System.out.println(careTaker);

        careTaker.undo();
        System.out.println(careTaker);


        Task1Tests task1Tests = new Task1Tests();
        task1Tests.runAllTests();

        FilterMain filterMain = new FilterMain();
        filterMain.run();
        FilterTest filterTest = new FilterTest();
        filterTest.runAllTests();
    }
}