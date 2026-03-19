import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {
        System.out.println("Bắt đầu");

        CompletableFuture<String> processOrder = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {}
            return "Xong task 1";
        });

        System.out.println("Luồng chính đang rảnh");

        processOrder.thenAccept(result -> {
            System.out.println("Kết quả: " + result + " -> Đang làm task 2...");
        });

        System.out.println("Luồng chính vẫn đang rảnh");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        processOrder.join();
    }
}

//Bắt đầu
//Luồng chính đang rảnh
//Luồng chính vẫn đang rảnh
//Kết quả: Xong task 1 -> Đang làm task 2...