package model;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungnv on 19/03/2017.
 */
public class Bullet extends GameObject {

    public Bullet(int positionX, int positionY, int speedX, int speedY, String imgUrl) {
        try {
            image = ImageIO.read(new File(imgUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.positionX = positionX;
        this.positionY = positionY;
        this.speedX = speedX;
        this.speedY = speedY;
    }
}
