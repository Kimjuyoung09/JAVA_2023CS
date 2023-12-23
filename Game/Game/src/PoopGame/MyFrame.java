package PoopGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GraphicObject extends Thread {
    int x = 0, y = 0;
    protected Image img = null;

    public GraphicObject(String name) {
        try {
            img = ImageIO.read(new File(name));
            img = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

            x = new Random().nextInt(440);
            y = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public Image getImg() {
        return img;
    }
}

class Poop extends GraphicObject {
    int dy = 5;

    public Poop(String name) {
        super(name);
    }

    public void update() {
        y += dy;
        if (y > 500) {
            y = 0;
            x = new Random().nextInt(440);
        }
    }
}

class Person extends GraphicObject {
    public Person(String name) {
        super(name);
        x = 150;
        y = 400;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT && x > 0) {
            x -= 10;
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT && x < 440) {
            x += 10;
        }
    }
}

class MyPanel extends JPanel implements KeyListener {
    Poop[] poops;
    Person person;
    JLabel scoreLabel = new JLabel();
    int score;

    public MyPanel() {
        super();
        this.addKeyListener(this);
        this.setFocusable(true);

        poops = new Poop[5];
        for (int i = 0; i < poops.length; i++) {
            poops[i] = new Poop("poop.gif");
        }
        person = new Person("person.jpg");

        scoreLabel.setFont(new Font("Gothic", Font.ITALIC, 20));
        scoreLabel.setBounds(370, 10, 200, 200);
        add(scoreLabel);

        class MyThread extends Thread {
            public void run() {
                while (true) {
                    for (Poop poop : poops) {
                        poop.update();
                    }
                    person.update();
                    checkCollision();
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Thread t = new MyThread();
        t.start();
    }

    private void checkCollision() {
        for (Poop poop : poops) {
            int poopRight = poop.x + poop.img.getWidth(null);
            int poopBottom = poop.y + poop.img.getHeight(null);

            int personRight = person.x + person.img.getWidth(null);
            int personBottom = person.y + person.img.getHeight(null);

            if (poop.y == 500) {
                score += 10;
                scoreLabel.setText("점수: " + Integer.toString(score));
                scoreLabel.setForeground(Color.BLUE);
            }

            if ((poop.x < personRight) && (poopRight > person.x) &&
                (poop.y < personBottom) && (poopBottom > person.y)) {
                System.exit(0);
            }
        }
    }
    public void paint(Graphics g) {
        super.paint(g);

        for (Poop poop : poops) {
            poop.draw(g);
        }
        person.draw(g);
    }

    public void keyPressed(KeyEvent event) {
        person.keyPressed(event);
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }
}

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("똥 피하기 게임");
        add(new MyPanel());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
