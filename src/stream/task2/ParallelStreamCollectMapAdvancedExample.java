package stream.task2;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        /*
            Создайте коллекцию студентов, где каждый студент содержит информацию о предметах, которые он изучает, и его оценках по этим предметам.
            Используйте Parallel Stream для обработки данных и создания Map, где ключ - предмет, а значение - средняя оценка по всем студентам.
            Выведите результат: общую Map с средними оценками по всем предметам.
         */
        Map<String, Integer> result = students.parallelStream()
                .flatMap(s ->  s.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.collectingAndThen(
                            Collectors.averagingInt(Map.Entry::getValue),
                            avg -> (int) Math.round(avg)
                        )
                ));

        System.out.println(result);
    }
}