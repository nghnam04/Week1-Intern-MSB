import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 1; i <= 5; i++){
            int id = i;
            executorService.execute(() -> { // .submit() trả về Future
                System.out.println("Luồng " + Thread.currentThread().getName() + " chạy task " + id);
            });
        }
            executorService.shutdown();
    }
}

//Luồng pool-1-thread-2 chạy task 2
//Luồng pool-1-thread-5 chạy task 5
//Luồng pool-1-thread-1 chạy task 1
//Luồng pool-1-thread-3 chạy task 3
//Luồng pool-1-thread-4 chạy task 4

//Luồng pool-1-thread-4 chạy task 4
//Luồng pool-1-thread-5 chạy task 5
//Luồng pool-1-thread-3 chạy task 3
//Luồng pool-1-thread-2 chạy task 2
//Luồng pool-1-thread-1 chạy task 1
