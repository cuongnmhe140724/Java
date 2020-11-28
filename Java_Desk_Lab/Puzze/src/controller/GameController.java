/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.GameForm;

/**
 *
 * @author cuongnm
 */
public class GameController {

    //private Timer timer;
    private Thread eclapse = ThreadElapse();
    private GameForm g;
    private HashMap<Integer, JButton> buttonList;
    final int SPACE_BUTTON = 20;
    final int SIZE_BUTTON = 50;

    private int count = 0;
    private int edge = 3;
    private int time = 0;
    private int emptyPos;
    private int currentPos;
    private boolean isFlag = false;

    public GameController() {
        g = new GameForm();
        g.setVisible(true);
        buttonList = new HashMap<>();
        eclapse.start();
        newGame();

        g.getCboSize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizeGameArea();
            }
        });

        g.getBtnNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
    }

    // Set size game area
    public void setSizeGameArea() {
        String sizeString = g.getCboSize().getSelectedItem().toString();
        String[] sizeSquare = sizeString.split("x");
        try {
            int num = Integer.parseInt(sizeSquare[0]);
            edge = num;
        } catch (NumberFormatException nfe) {
            System.err.println("Size illegal");
        }
    }

    //action for btnNewGame
    public void newGame() {
        //check play ststus
        if (isFlag) {
            isFlag = false;
            int confirm = JOptionPane.showConfirmDialog(g, "Do you really want to start new game?",
                    "Confirm Dialog", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                isFlag = true;//false
                createGameArea();
            } else {
                isFlag = true;
            }
        } else {
            isFlag = true;
            createGameArea();
        }
    }

    // create panel game area, set layout and add button
    public void createGameArea() {

        //countTime();
        buttonList.clear();
        time = 0;
        g.getLblTime().setText(time + " sec");
        count = 0;
        g.getLblCount().setText(Integer.toString(count));

        ArrayList<Integer> listNumber = (ArrayList) randomNumber(edge);
        g.getPnlGame().removeAll();
        g.getPnlGame().setLayout(new GridLayout(edge, edge, SPACE_BUTTON, SPACE_BUTTON));
        g.getPnlGame().setPreferredSize(new Dimension(((SIZE_BUTTON * edge) + (SPACE_BUTTON * (edge - 1))),
                ((SIZE_BUTTON * edge) + (SPACE_BUTTON * (edge - 1)))));
//        game.getPnlAreaGame().setSize(size, size);
        //loop for to add button into panel
        for (int i = 0; i < edge * edge; i++) {
            int num = listNumber.get(i);
            String txt = num % (edge * edge) != 0 ? num + "" : "";
            if (txt.equals("")) {
                emptyPos = i;
            }
            JButton btn = new JButton(txt);
            btn.setPreferredSize(new Dimension(SIZE_BUTTON, SIZE_BUTTON));
//            btn.setMargin(new Insets(MARGIN_BUTTON, MARGIN_BUTTON, MARGIN_BUTTON, MARGIN_BUTTON));
            addButtonAction(btn);
            buttonList.put(i, btn);
            g.getPnlGame().add(btn);
        }
        g.pack();
    }

    // create random in list
    public List<Integer> randomNumber(int size) {
        ArrayList<Integer> listNumber = new ArrayList<>();
        //for loop  from 1 to size * size to add number into array list
        for (int i = 1; i <= size * size; i++) {
            listNumber.add(i);
        }
        // make sure always win
        do {
            Collections.shuffle(listNumber);
        } while (!checkShuffle(listNumber));
        return listNumber;
    }

    //check shuffle algorithm always right
    public boolean checkShuffle(List<Integer> listNumber) {
        // count is the number of elements smaller than the ith element
        // 1 2 3 | 4 5 6 | 7 8 
        int count = 0;
        int posiEmty = 0;
        int size = listNumber.size();

        for (int i = 0; i < size; i++) {
            // danh dau empty position
            if (listNumber.get(i) == size) {
                posiEmty = i;
                continue;
            }
            // counts the number of elements smaller than the ith element
            for (int j = i + 1; j < size; j++) {
                // check max is not count
                if (listNumber.get(j) == size) {
                    continue;
                }
                // check so thu i lon hon j thi count + 1
                if (listNumber.get(i) > listNumber.get(j)) {
                    count++;
                }
            }
        }

        System.out.println("Count: " + count + " Size: " + size + " PosiEmpty: " + posiEmty);
        // if size is odd, count must be even
        if (size % 2 == 1) {
            return count % 2 == 0;
        } else {
            //if size is even and pos empty in an even row, count must be even
            return ((posiEmty / size + 1) % 2 == 0 && count % 2 == 0)
                    || ((posiEmty / size + 1) % 2 == 1 && count % 2 == 1);
        }
    }

    // Add action to button 
    public void addButtonAction(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When the game starts, the buttons display automatically and if manipulated, the status will be changed playing
                isFlag = true; 
                getCurrentPos(btn);
                //check button can swap
                if (swappable()) {
                    swapButton();
                    updateCount();
                    solveWin();
                }
            }
        });
    }

    public void getCurrentPos(JButton btn) {
        //for loop find pos of button is selected
        for (Map.Entry<Integer, JButton> entry : buttonList.entrySet()) {
            Integer key = entry.getKey();
            JButton value = entry.getValue();
            //save current button pos
            if (btn.getText().equals(value.getText())) {
                currentPos = key;
                return;
            }
        }
    }

    public boolean swappable() {
        //if selected button near empty button -> swap
        return isTop() || isBottom()
                || isLeft() || isRight();
    }

    boolean isTop() {
        return currentPos - edge == emptyPos;
    }

    boolean isBottom() {
        return currentPos + edge == emptyPos;
    }

    boolean isLeft() {
        return currentPos - 1 == emptyPos;
    }

    boolean isRight() {
        return currentPos + 1 == emptyPos;
    }


    public void swapButton() {
        String txt = buttonList.get(currentPos).getText();
        buttonList.get(emptyPos).setText(txt);
        buttonList.get(currentPos).setText("");
        emptyPos = currentPos;
    }

    // Count number of the movement and display into screen
    public void updateCount() {
        ++count;
        g.getLblCount().setText(count + "");
    }

    public void solveWin() {
        // When players win, display message to screen, reset time and stop the interaction of players with buttons
        if (checkWin()) {
            isFlag = false;
            JOptionPane.showMessageDialog(g, "You Win !!!", "Congratulate", 1);
            g.getLblTime().setText(Integer.toString(time) + " sec ");
            disableButton();
        }
    }

    // Check condition to win
    public boolean checkWin() {
        // for loop to get key and vakue of HashMap
        for (Map.Entry<Integer, JButton> entry : buttonList.entrySet()) {
            Integer key = entry.getKey();
            JButton value = entry.getValue();
            String txt = value.getText();
            if (!txt.equals("")) {
                int num = 0;
                try {
                    num = Integer.parseInt(txt);
                } catch (NumberFormatException numf) {
                    System.err.println("Convert number checkWin error");
                }
                if (num - 1 != key) {
                    return false;
                }
            }
        }
        return true;
    }

    //When players win, player cannot interact with button
    public void disableButton() {
        // for loop in hash map to get value of Jbutton
        for (Map.Entry<Integer, JButton> entry : buttonList.entrySet()) {
            JButton value = entry.getValue();
            value.setEnabled(false);
        }
    }

    // Thread for time count
    public Thread ThreadElapse() {
        Thread elapsed = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (isFlag) {
                        g.getLblTime().setText(time++ + " sec");
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.err.println("Thread elapse error");
                    }
                }
            }
        };
        return elapsed;
    }
}
