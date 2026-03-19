package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hungnv on 19/03/2017.
 */
public class EnemyPlane extends Plane {

    private Image heartImg;

    public EnemyPlane() {
        positionX = 30;
        positionY = 60;
        speedX = 3;
        hearts = 10;
        try {
            image = ImageIO.read(new File("Resources/PLANE1.png"));
            heartImg = ImageIO.read(new File("Resources/black_heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void move() {
        super.move();
        if (positionX < 0 || positionX > 600){
            speedX *= -1;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        drawHearts(graphics);
    }

    protected void drawHearts(Graphics graphics){
        if(heartImg == null) return;
        int positionX = 10;
        int positionY = 30;
        for (int i = 0; i < hearts; i++){
            int row = i / 5;
            int col = i % 5;
            int drawPositionX = positionX + col * (5 + heartImg.getWidth(null));
            int drawPositionY = positionY + row * (5 + heartImg.getHeight(null));
            graphics.drawImage(heartImg, drawPositionX, drawPositionY, null);
        }
    }

    public void shoot(Vector<Bullet> listBullet){
        int numberOfBullets = 11 - this.hearts;
        for (int i = 0; i < numberOfBullets; i++) {
            int newSpeedX = i - (numberOfBullets / 2);
            listBullet.add(new Bullet(positionX, positionY, newSpeedX, 3, "Resources/enemy_bullet.png"));
        }
    }
}
