package model;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by hungnv on 12/03/2017.
 */
public class Plane extends GameObject {

    public int hearts;
    public boolean isAlive;

    public Plane() {
        isAlive = true;
    }

    public void isShooted(Vector<Bullet> listBullet){
        Iterator<Bullet> listBulletIterator = listBullet.iterator();
        while (listBulletIterator.hasNext()){
            if (isTouch(listBulletIterator.next())){
                listBulletIterator.remove();
                hearts--;
            }
        }
    }

    private boolean isTouch(Bullet bullet){
        if ((bullet.positionX > this.positionX &&
                bullet.positionX < this.positionX + this.image.getWidth(null)) &&
                (bullet.positionY > this.positionY &&
                bullet.positionY < this.positionY + this.image.getHeight(null))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
