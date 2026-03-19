package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungnv on 19/03/2017.
 */
public class PlayerPlane extends Plane {

    public PlayerPlane() {
        positionX = 300;
        positionY = 300;
        hearts = 5;
        try {
            image = ImageIO.read(new File("Resources/PLANE4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        drawHearts(graphics);
    }

    protected void drawHearts(Graphics graphics){
        Image heartImg = null;
        int positionX = 350;
        int positionY = 3;
        try {
            heartImg = ImageIO.read(new File("Resources/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < hearts; i++){
            graphics.drawImage(heartImg, positionX, positionY, null);
            positionX += heartImg.getWidth(null);
        }
    }
}
