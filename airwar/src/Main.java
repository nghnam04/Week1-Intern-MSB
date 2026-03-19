/**
 * Created by hungnv on 09/03/2017.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Air War");
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
