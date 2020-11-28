/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import view.GameForm;

/**
 *
 * @author cuongnm
 */
public class GameController implements KeyListener {

    private GameForm game;
    private Timer timer;
    List<JButton> listColumn = new ArrayList<>();
    List<Rectangle> listSave = new ArrayList<>();
    JButton btnFrog = new JButton();
    private int mark = 0;
    private boolean isSave = false;
    private final int GAME_SPEED = 20;
    private final int HEIGHT_GAME_PANEL, WIDTH_GAME_PANEL;
    private final int HEIGHT_COLUMN_UP_DEFAULT = 100;
    private final int HEIGHT_COLUMN_DOWN_DEFAULT = 75;
    private final int WIDTH_FROG = 40;
    private final int Y_FROG_DEFAULT = 100;
    private final int X_FROG_DEFAULT = 60;
    private final int FROG_FALLING_SPEED_DEFAULT = 2;
    //private final int FALLING_SPEED_ACCELERATION = 1;
    private final int FROG_JUMPING = 35;
    private int frogFall;
    private int yForg;
    private int count;
    private boolean isPause = false;
    private boolean pressKey = false;
    private boolean releaseKey = true;

    private int yFalling;
    private int speedJump;
    private int timeFly;
    private int saveCount;
    private int saveMark;
    private int saveYFrog;
    private int saveTimeFly;
    private int saveYFalling;
    private final double fallRange = 0.2;

    public GameController() {
        game = new GameForm();
        game.setVisible(true);
        HEIGHT_GAME_PANEL = game.getPnlGameArea().getHeight();
        WIDTH_GAME_PANEL = game.getPnlGameArea().getWidth();
        btnFrog.setBounds(X_FROG_DEFAULT, Y_FROG_DEFAULT, WIDTH_FROG, WIDTH_FROG);
        createNewGame();
        //add envent to button
        btnFrog.addKeyListener(this);
        game.getBtnPause().addKeyListener(this);
        game.getBtnSave().addKeyListener(this);
        game.getBtnPause().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });
        game.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        run();
        pause();
    }

    //generate and add column to game area
    public void addButton() {
        Random random = new Random();
        JButton btnUp = new JButton();
        JButton btnDown = new JButton();

        int heightUp = random.nextInt(100) + HEIGHT_COLUMN_UP_DEFAULT;
        int heightDown = HEIGHT_GAME_PANEL - WIDTH_FROG * 3 - heightUp;

        btnUp.setBounds(WIDTH_GAME_PANEL, 0, WIDTH_FROG, heightUp);
        btnDown.setBounds(WIDTH_GAME_PANEL, HEIGHT_GAME_PANEL - heightDown, WIDTH_FROG, heightDown);

        //add to list button
        listColumn.add(btnDown);
        listColumn.add(btnUp);
        //add to panel
        game.getPnlGameArea().add(btnDown);
        game.getPnlGameArea().add(btnUp);
    }

    //pause/continute button
    public void pause() {
        //if game is running, press pause -> game stop, change text on button
        if (isPause == false) {
            timer.stop();
            isPause = true;
            game.getBtnPause().setText("Play");
        } else {
            //if game is stop, press continute -> game continute, change text on button
            timer.restart();
            isPause = false;
            game.getBtnPause().setText("Pause");
        }
    }
    
    /**
     *
     * @return true if collision
     */
    public boolean checkCollision() {
        boolean isCollisionCeiling = false;
        Rectangle frog = btnFrog.getBounds();
        //check for collisions with ceilings
        if (frog.y <= 0) {
            isCollisionCeiling = true;
            handingIntersect(frog, frog, isCollisionCeiling);
            return true;
        }
        //check for collisions with floors
        if (frog.y >= HEIGHT_GAME_PANEL - WIDTH_FROG) {
            return true;
        }
//        Rectangle frog = new Rectangle(X_FROG_DEFAULT, yForg, WIDTH_FROG, WIDTH_FROG);
        //check for collisions with column
        for (int i = 0; i < listColumn.size(); i++) {
            //fomart column button to rectangle
            Rectangle column = listColumn.get(i).getBounds();
            int x = column.x - 1;
            int y = column.y;
            listColumn.get(i).setLocation(x, y);
           
            //check frog intersect with column
            if (column.intersects(frog)) {

                if (frog.x + WIDTH_FROG - 1 > column.x) {
                    handingIntersect(column, frog, isCollisionCeiling);
                }
                return true;
            } else {
                if ((column.x + WIDTH_FROG) == X_FROG_DEFAULT) {
                    mark++;
                }
            }

            //if column moves out panel -> delete columns
            if (x <= -WIDTH_FROG) {
                listColumn.remove(i);
                i--;
            }
        }
        game.getLblPoint().setText("Point: " + mark / 2);
        return false;
    }

    public void handingIntersect(Rectangle column, Rectangle frog, boolean isCollisionCeiling) {
        Rectangle intersect = column.intersection(frog);
        if (isCollisionCeiling) {
            frog.y = 0;
        } else {
            if (frog.y > column.y) {
                frog.y += intersect.height;
            } else {
                frog.y -= intersect.height;
            }
        }
        btnFrog.setBounds(frog);
    }

    public void save() {
        isSave = true;
        listSave.clear();
        for (int i = 0; i < listColumn.size(); i++) {
            listSave.add((Rectangle) listColumn.get(i).getBounds().clone());
        }
        saveYFrog = yForg;
        saveMark = mark;
        saveCount = count;
        saveTimeFly = timeFly;
        saveYFalling = yFalling;
    }

    //reset panel and add frog again
    public void resetGameArea() {
        game.getPnlGameArea().removeAll();
        game.getPnlGameArea().repaint();
        listColumn.clear();
        game.getPnlGameArea().add(btnFrog);
    }

    public void loadFile() {
        resetGameArea();
        for (int i = 0; i < listSave.size(); i++) {
            JButton button = new JButton();
            button.setBounds(listSave.get(i));
            listColumn.add(button);
            game.getPnlGameArea().add(button);
        }
        count = saveCount;
        mark = saveMark;
        yForg = saveYFrog;
        yFalling = saveYFalling;
        timeFly = saveTimeFly;
    }

    public void createNewGame() {
        resetGameArea();
        mark = 0;
        isSave = false;
        count = WIDTH_FROG * 5;
        timeFly = 0;
        yForg = Y_FROG_DEFAULT;
        yFalling = yForg;
        speedJump = 0;
        //game.getLblPoint().setText("Point: 0");
    }

    public void showMes() {
        String medal = "no";
        int playerPoint = mark / 2;
        //get medal
        if (playerPoint > 40) {
            medal = "platinum";
        } else if (playerPoint > 30) {
            medal = "gold";
        } else if (playerPoint > 20) {
            medal = "silver";
        } else if (playerPoint >= 10) {
            medal = "bronze";
        }
        //check user save game
        if (isSave == false) {
            JOptionPane.showMessageDialog(null, "Your point " + playerPoint + "\n You receive " + medal + " medal", "Happy Frog", JOptionPane.PLAIN_MESSAGE);
            createNewGame();
        } else {
            Object mes[] = {"New Game", "Continue"};
            int option = JOptionPane.showOptionDialog(null, "Your point " + mark + "\n You receive " + medal + " medal",
                    "Happy Frog", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, mes, mes[0]);
            //choose continute
            if (option == 1) {
                loadFile();
            } else {
                createNewGame();
            }
        }
        timer.restart();
    }

    public void frogMove() {
        yForg = (int) (yFalling - speedJump * timeFly + fallRange * timeFly * timeFly / 2);
        timeFly++;
    }

    public void run() {
        timer = new Timer(GAME_SPEED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if press up -> frog move up
                Rectangle frogRect = btnFrog.getBounds();
                if (pressKey) {
                    timeFly = 0;
                    speedJump = 4;
                    yFalling = yForg;
                    frogMove();
                    pressKey = false;
                }
                //frogFall++;
                frogMove();
                btnFrog.setLocation(X_FROG_DEFAULT, yForg);
                count++;
                if (count == (WIDTH_FROG * 5) + 1) {
                    addButton();
                    count = 0;
                }
                //if frog collision with column -> stop game, show message
                if (checkCollision()) {
                    timer.stop();
                    showMes();
                }
            }
        });
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //if press up 
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (releaseKey) {
                pressKey = true;
                releaseKey = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        releaseKey = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
