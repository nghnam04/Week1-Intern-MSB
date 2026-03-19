package model;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hungnv on 19/03/2017.
 */
public class EnemyPlane extends Plane {

    public EnemyPlane() {
        positionX = 30;
        positionY = 60;
        speedX = 3;
        hearts = 10;
        try {
            image = ImageIO.read(new File("Resources/PLANE1.png"));
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

    public void shoot(Vector<Bullet> listBullet){
        Bullet bullet = new Bullet(positionX, positionY, 0, 3, "Resources/enemy_bullet.png");
        listBullet.add(bullet);
    }
}
