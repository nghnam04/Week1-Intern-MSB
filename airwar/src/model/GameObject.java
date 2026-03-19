package model;

import java.awt.*;

/**
 * Created by hungnv on 12/03/2017.
 */
public class GameObject {

    public int positionX;
    public int positionY;
    public int speedX;
    public int speedY;
    public Image image;

    public void move(){
        positionX += speedX;
        positionY += speedY;
    }

    public void draw(Graphics graphics){
        graphics.drawImage(image, positionX, positionY, null);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }
}
