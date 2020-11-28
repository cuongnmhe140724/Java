/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_fix;

import Model.Memory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JOptionPane;
import view.Calculator;

/**
 *
 * @author cuongnm
 */
public class Controller implements ActionListener {

    private Calculator m;
    private Memory memory = null;
   // private DecimalFormat df = new DecimalFormat("#.#########");
    private boolean ready = true;
   // private double result = 0;
    private BigDecimal result1 = new BigDecimal("0");
    private String operation = "add";
    private boolean process;
   // private double temp = 0;
    private BigDecimal temp1 = new BigDecimal("0");

    public Controller() {
        m = new Calculator();
        m.setVisible(true);
       // df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        m.getBtn0().addActionListener(this);
        m.getBtn1().addActionListener(this);
        m.getBtn2().addActionListener(this);
        m.getBtn3().addActionListener(this);
        m.getBtn4().addActionListener(this);
        m.getBtn5().addActionListener(this);
        m.getBtn6().addActionListener(this);
        m.getBtn7().addActionListener(this);
        m.getBtn8().addActionListener(this);
        m.getBtn9().addActionListener(this);
        m.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("add");
            }
        });
        m.getBtnSub().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("sub");
            }
        });
        m.getBtnDiv().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("div");
            }
        });
        m.getBtnMul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("multi");
            }
        });
        m.getBtnEqua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform();
            }
        });
        m.getLblClear().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear();
            }
        });
        m.getBtnMc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mClear();
            }
        });
        m.getBtnMr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mR();
            }
        });
        m.getBtnMAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mAdd();
            }
        });
        m.getBtnMSub().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mSub();
            }
        });
        m.getBtnSR().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqrt();
            }
        });
        m.getBtnFlip().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flip();
            }
        });
        m.getBtnPercent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                percent();
            }
        });
        m.getBtnSwap().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap();
            }
        });
        m.getBtnDot().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDot();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // check case input number
        if (ready) {
            result1 = getCurrentNumber();
            setResultText(command);
            ready = false;
        } else {
            setResultText(getCurrentText() + command);
        }
    }

    /**
     * set and get text in text field
     */
    public void setResultText(String text) {
        m.txtResult.setText(text);
    }
    
    public void setResultNumber(BigDecimal number){
        setResultText(number.stripTrailingZeros().toPlainString());
    }

    public String getCurrentText() {
        return m.txtResult.getText();
    }

    public BigDecimal getCurrentNumber() {
        BigDecimal number;
        try {
            number = new BigDecimal(getCurrentText());
        } catch (Exception e) {
            return temp1;
        }
        return number;
    }

    /**
     * button . add dot but current number is an integer
     */
    public void addDot() {
        //check number is an integer and there was a input number
        if (!haveDot() && ready == false) {
            setResultText(getCurrentText() + ".");
            ready = false;
        }
        if (ready == true) {
            setResultText("0.");
            ready = false;
        }
    }

    private boolean haveDot() {
        return m.txtResult.getText().contains(".");
    }

    /**
     * button +/- Write opposite number of the current result
     */
    public void swap() {
        perform();
        BigDecimal number = getCurrentNumber().negate();
        System.out.println("swp" + number);
        setResultNumber(number);
        result1 = getCurrentNumber();
        System.out.println(result1);
    }

    /**
     * clear text
     */
    public void clear() {
        setResultText("0");
        mClear();
        result1 = new BigDecimal("0");
        operation = "add";
    }

    /**
     * button =
     */
    public void perform() {
        //check execution conditions
        if (getCurrentText().equals("ERROR")) {
            setResultNumber(getCurrentNumber());
        } else {
            //check execution conditions
            if (!ready) {
                calculator();
            }
        }
        operation = "";
        result1 = new BigDecimal("0");
        System.out.println(result1);
        ready = true;
    }

    /**
     * set operation when user press operation button
     */
    public void setOperation(String o) {
        //check after press =
        if (ready) {
            operation = o;
            if (getCurrentText().equals("ERROR")) {
                setResultText(getCurrentNumber() + "");
            }
            return;
        }
        calculator();
        //save new operator to calculate next opression
        operation = o;
    }

    public void calculator() {
        //if (!getCurrentText().equals("ERROR")) {
        System.out.println(result1 + "f");
        switch (operation) {
            //to add value
            case "add":
                result1 = result1.add(getCurrentNumber());
                break;
            //to sub value    
            case "sub":
                result1 = result1.subtract(getCurrentNumber());
                break;
            //to multiple value    
            case "multi":
                result1 = result1.multiply(getCurrentNumber());
                break;
            //to division value   
            case "div":
                //check div to 0
                if (getCurrentNumber().toString().equals("0")) {
                    setResultText("ERROR");
                    temp1 = result1;
                    ready = true;
                    return;
                } else {
                    result1 = result1.divide(getCurrentNumber(), 12, RoundingMode.HALF_EVEN);
                }
                break;
            default: // giai quyet truong hop 1 + = 9 + -> 1
                result1 = getCurrentNumber();
        }
        setResultNumber(result1);
        System.out.println(result1);
        ready = true;
    }

    //button √ 
    //SQRT current number if possible. Display Error if not
    public void sqrt() {
        //check possible number
        if (getCurrentNumber().doubleValue() < 0) {
            setResultText("ERROR");
            temp1 = result1;
        } else {
            String display = Math.sqrt(getCurrentNumber().doubleValue()) + "";
            if (display.endsWith(".0")) {
                display = display.replace(".0", "");
            }
            setResultText(display);
        }
        ready = true;
    }

    //button %
    //Divde current result by 100
    //return result to display in txtDisplay
    public void percent() {
        setResultNumber(getCurrentNumber().divide(new BigDecimal("100"), 12, RoundingMode.HALF_EVEN));
        ready = true;
    }

    //button 1/X
    //Take 1 then divide it by current result. Return to display in txtDisplay
    public void flip() {
        //check div to 0
        if (getCurrentNumber().equals("0")) {
            setResultText("ERROR");
            temp1 = result1;
        } else {
            BigDecimal result = new BigDecimal("1").divide(getCurrentNumber(), 12, RoundingMode.HALF_EVEN);
            setResultNumber(result);
        }
        ready = true;
    }

    //button M+
    //Add current number to memory
    //text is what current txtDisplay
    public void mAdd() {
        if (memory == null) {
            memory = new Memory(getCurrentNumber());
            m.btnMc.setEnabled(true);
            m.btnMr.setEnabled(true);
        } else {
            memory.setMemory(memory.getMemory().add(getCurrentNumber()));
        }
        ready = true;
    }

    //button M-
    //Number in memory will substract current number
    //text is what current txtDisplay
    public void mSub() {
        if (memory == null) {
            memory = new Memory(getCurrentNumber().negate());
            m.btnMc.setEnabled(true);
            m.btnMr.setEnabled(true);
        } else {
            memory.setMemory(memory.getMemory().subtract(getCurrentNumber()));
        }
        ready = true;
    }

    //button MR
    //Return number from memory
    public void mR() {
        setResultText(memory.getMemory() + "");
        ready = true;
    }

    //button MC
    //Clear Memory and set enable button 
    public void mClear() {
        m.btnMc.setEnabled(false);
        m.btnMr.setEnabled(false);
        memory = null;
        ready = true;
    }
}
