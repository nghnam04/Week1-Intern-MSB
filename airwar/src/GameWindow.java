import model.Bullet;
import model.EnemyPlane;
import model.PlayerPlane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by hungnv on 10/03/2017.
 */
public class GameWindow extends Frame implements Runnable{

    Image background;
    Image gameOverImg;
    Image winImg;
    PlayerPlane playerPlane;
    EnemyPlane enemyPlane;
    BufferedImage bufferedImage;
    Vector<Bullet> listPlayerBullet;
    Vector<Bullet> listEnemyBullet;
    int enemyShootCount;

    public GameWindow(){
        this.setTitle("Air War");
        this.setSize(600, 700);
        this.setVisible(true);
        enemyShootCount = 0;
        playerPlane = new PlayerPlane();
        enemyPlane = new EnemyPlane();
        listPlayerBullet = new Vector<>();
        listEnemyBullet = new Vector<>();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse Press");
                int positionX = e.getX();
                int positionY = e.getY();
                Bullet bullet = new Bullet(0, positionY, 0, -3, "Resources/Bullet.png");
                bullet.setPositionX(positionX - bullet.image.getWidth(null)/2);
                listPlayerBullet.add(bullet);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse release");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouse enter");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouse exit");
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                playerPlane.positionX = e.getX() - playerPlane.image.getWidth(null)/2;
                playerPlane.positionY = e.getY() - playerPlane.image.getHeight(null)/2;
            }
        });
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            gameOverImg = ImageIO.read(new File("Resources/gameover.jpg"));
            winImg = ImageIO.read(new File("Resources/win_screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateGame(){
        synchronized (listPlayerBullet) {
            for (Bullet bullet : listPlayerBullet) {
                bullet.move();
            }
        }
        synchronized (listEnemyBullet) {
            for (Bullet bullet : listEnemyBullet) {
                bullet.move();
            }
        }
        enemyPlane.move();
        if (enemyShootCount == 60){
            enemyPlane.shoot(listEnemyBullet);
            enemyShootCount = 0;
        }
        enemyShootCount++;
        playerPlane.isShooted(listEnemyBullet);
        enemyPlane.isShooted(listPlayerBullet);
        if (playerPlane.hearts <= 0){
            playerPlane.isAlive = false;
        }
        if (enemyPlane.hearts <= 0){
            enemyPlane.isAlive = false;
        }
    }

    @Override
    public void update(Graphics g) {
        if (bufferedImage == null){
            bufferedImage = new BufferedImage(600, 700, 1);
        }
        Graphics bufferedGraphic = bufferedImage.getGraphics();
        bufferedGraphic.drawImage(background, 0, 0, null);
        synchronized (listPlayerBullet) {
            for (Bullet bullet : listPlayerBullet) {
                bullet.draw(bufferedGraphic);
            }
        }
        synchronized (listEnemyBullet) {
            for (Bullet bullet : listEnemyBullet) {
                bullet.draw(bufferedGraphic);
            }
        }
        playerPlane.draw(bufferedGraphic);
        enemyPlane.draw(bufferedGraphic);
        if (!playerPlane.isAlive && enemyPlane.isAlive){
            bufferedGraphic.drawImage(gameOverImg, 0, 0, null);
        }
        if (!enemyPlane.isAlive){
            bufferedGraphic.drawImage(winImg, -100, 0, null);
        }
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateGame();
            repaint();
        }
    }
}
