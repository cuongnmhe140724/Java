
import java.awt.HeadlessException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh Thanh
 */
public class Q3 extends javax.swing.JFrame {
    Thread countDown, printPrime, notPrime;

    /**
     * Creates new form Q3
     */
    public Q3() {
        initComponents();
        initThreadCountDown();  
        initThreadPrintPrime();
        initThreadPrintNotPrime();
    }
    
    boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    void primeNumber(){
        int number = Integer.parseInt(spnTime.getValue().toString());
        int i = 2;
        int count = 0;
        while(true){
            if(isPrime(i)){
                txtResultPrime.append(i + " ");
                count ++;
                try {
                    sleep(1000);                            
                } catch (InterruptedException ex) {
                    
                }                
            }
            i++;
            if(count == 10){
               txtResultPrime.append("\n");
            }

            if(count == number || number <= 0){
                break;
            }
        }
    }
    void countdown(){
        int number = Integer.parseInt(spnTime.getValue().toString()); //(int)(spnTime.getValue());
        for (int i = number; i >= 0; i--) {
            lbResultNumber.setText(i + " second");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
               
            }
        }
    }

    void initThreadCountDown(){
        countDown = new Thread(){
            @Override
            public void run() {
                countdown();
            }
        };  
    }
    
    void initThreadPrintPrime(){
        printPrime = new Thread(){
            @Override
            public void run() {
                primeNumber();
            }            
        };
    }
    
        void initThreadPrintNotPrime(){
        notPrime = new Thread(){
            @Override
            public void run() {
                notPrimeNumber();
            }            
        };
    }
    
    
        void notPrimeNumber(){
        
        int i = 25;
        int count = 0;
        while(true){
            if(!isPrime(i)){
                txtResultNotPrime.append(i + " ");
                count ++;
                try {
                    sleep(1000);                            
                } catch (InterruptedException e) {
                    
                }                
            }
            i--;
            if(count == 8){
               break;
            }


        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        spnTime = new javax.swing.JSpinner();
        lb2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultPrime = new javax.swing.JTextArea();
        lbResultNumber = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultNotPrime = new javax.swing.JTextArea();
        btnStart2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setText("Run time:");

        spnTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        spnTime.setModel(new javax.swing.SpinnerNumberModel(10, 0, 10, 1));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb2.setText("second");

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        txtResultPrime.setColumns(20);
        txtResultPrime.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtResultPrime.setRows(5);
        jScrollPane1.setViewportView(txtResultPrime);

        lbResultNumber.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        txtResultNotPrime.setColumns(20);
        txtResultNotPrime.setRows(5);
        jScrollPane2.setViewportView(txtResultNotPrime);

        btnStart2.setText("Start");
        btnStart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb1)
                                .addGap(87, 87, 87)
                                .addComponent(spnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb2)
                                .addGap(118, 118, 118)
                                .addComponent(btnStart))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(51, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(lbResultNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStart2)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(spnTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb2)
                    .addComponent(btnStart))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnStart2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbResultNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        countDown.start();
        printPrime.start();
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart2ActionPerformed

        notPrime.start();
    }//GEN-LAST:event_btnStart2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Q3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Q3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Q3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Q3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Q3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStart2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbResultNumber;
    private javax.swing.JSpinner spnTime;
    private javax.swing.JTextArea txtResultNotPrime;
    private javax.swing.JTextArea txtResultPrime;
    // End of variables declaration//GEN-END:variables
}
