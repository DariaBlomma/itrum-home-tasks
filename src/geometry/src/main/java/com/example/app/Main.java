package com.example.app;

import com.example.geometry.BaseCircle;
import com.example.geometry.BaseRectangle;
import com.example.geometry.BaseTriangle;

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
       } catch (IllegalArgumentException e) {
           System.out.println("Could not create figure: " + e);
       }
    }
}
