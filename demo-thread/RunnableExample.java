public class RunnableExample {
    public static void main(String[] args) {
        Runnable printNumber = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("In ra: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        };

        Thread thread = new Thread(printNumber);
        thread.start(); // tạo luồng mới
        // .run() chạy trên luồng main
    }
}