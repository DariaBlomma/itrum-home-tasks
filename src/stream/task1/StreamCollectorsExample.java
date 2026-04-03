package stream.task1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        /*
            Создайте список заказов с разными продуктами и их стоимостями.
            Группируйте заказы по продуктам.
            Для каждого продукта найдите общую стоимость всех заказов.
            Отсортируйте продукты по убыванию общей стоимости.
            Выберите три самых дорогих продукта.
            Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
         */

        Map<String, Double> top3 = orders.stream()
                .collect(Collectors.groupingBy(
                    Order::getProduct,
                    Collectors.summingDouble(Order::getCost)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry<String, Double> entry : top3.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
