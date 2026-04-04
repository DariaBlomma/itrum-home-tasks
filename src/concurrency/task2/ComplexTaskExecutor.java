package concurrency.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplexTaskExecutor {
    private int numberOfTasksFromConstructor;

    public ComplexTaskExecutor(int numberOfTasksFromConstructor) {
        this.numberOfTasksFromConstructor = numberOfTasksFromConstructor;
    }

    void executeTasks(int numberOfTasks) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks)) {
            AtomicInteger successCount = new AtomicInteger(0);

            CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfTasks, () -> {
                System.out.println("All threads reached barrier");
                System.out.println("Успешных задач: " + successCount.get());
            });
            for (int i = 0; i < numberOfTasks; i++) {
                final int taskId = i;
                executorService.execute(() -> {
                    try {
                        ComplexTask task = new ComplexTask();
                        task.execute(taskId);
                        successCount.incrementAndGet();
                    } catch (Exception e) {
                        System.out.println("Error while executing task" + taskId + ". Exception: " + e);
                    } finally {
                        try {
                            cyclicBarrier.await(5, TimeUnit.SECONDS);
                        } catch (Exception e) {
                            System.out.println("Failed to wait for task" + taskId + ", barrier will be unlocked with timeout" + ". Exception: " + e);
                        }
                    }
                });
            }
        } catch (Exception e) {
            System.err.println("Error during executor shutdown: " + e);
        }
    }
}
