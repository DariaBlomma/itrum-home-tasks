package com.example.app;

import com.example.geometry.BaseCircle;
import com.example.geometry.BaseRectangle;
import com.example.geometry.BaseTriangle;
import com.example.geometry.utils.FiguresComparison;

public class Main {
    public static void main(String[] args) {
       try {
           BaseCircle circle = BaseCircle.create(5);
           System.out.println("Circle area: " + circle.getArea());
           System.out.println("Circle perimeter: " + circle.getPerimeter());

           BaseRectangle rectangle = BaseRectangle.create(3, 7);
           System.out.println("Rectangle area: " + rectangle.getArea());
           System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

           BaseTriangle triangle = BaseTriangle.create(7, 8, 9);
           System.out.println("Triangle area: " + triangle.getArea());
           System.out.println("Triangle perimeter: " + triangle.getPerimeter());

           System.out.println("Figure color: " + circle.getColor());

           int triangleToRectangleAreaComparison = FiguresComparison.compareByArea(triangle, rectangle);

           switch (triangleToRectangleAreaComparison) {
               case 0 -> System.out.println("Triangle equals rectangle by area");

               case -1 -> System.out.println("Triangle's area is less than rectangle's one");

               case 1 -> System.out.println("Triangle's area is bigger than rectangle's one");
           }
           FiguresComparison.printOldMessage(circle);
           // Exception in thread "main" java.lang.NoSuchMethodError: 'void com.example.geometry.BaseFigure.oldMethod()'
           //	at com.example.geometry.utils.FiguresComparison.printOldMessage(FiguresComparison.java:30)
           //	at com.example.app.Main.main(Main.java:34)
       } catch (IllegalArgumentException e) {
           System.out.println("Could not create figure: " + e);
       }
    }
}
