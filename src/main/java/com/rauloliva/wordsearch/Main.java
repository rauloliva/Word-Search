package com.rauloliva.wordsearch;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JTextField;

public class Main extends javax.swing.JFrame {

    private Board board;
    private Map<String, JTextField> cellCoords;
    private final char[] alphabet = {
        'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        mapCells();
    }

    private void mapCells() {
        cellCoords = new HashMap();
        cellCoords.put("0:0", txt_char1);
        cellCoords.put("0:1", txt_char2);
        cellCoords.put("0:2", txt_char3);
        cellCoords.put("0:3", txt_char4);
        cellCoords.put("1:0", txt_char5);
        cellCoords.put("1:1", txt_char6);
        cellCoords.put("1:2", txt_char7);
        cellCoords.put("1:3", txt_char8);
        cellCoords.put("2:0", txt_char9);
        cellCoords.put("2:1", txt_char10);
        cellCoords.put("2:2", txt_char11);
        cellCoords.put("2:3", txt_char12);
    }

    private void charToUpper(char input, JTextField txt_char) {
        if (Character.isLetter(input)) {
            String key = String.valueOf(input).toUpperCase();
            txt_char.setText(key);

            // fire tab event
            try {
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_TAB);
                r.keyRelease(KeyEvent.VK_TAB);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void generateRandom() {
        Random r = new Random();

        // use cellsCoords values to asign random letters to the empty ones
        for (JTextField txt : cellCoords.values()) {
            if (txt.getText().isEmpty()) {
                String randChar = "" + alphabet[r.nextInt(alphabet.length)];
                txt.setText(randChar);
            }
        }
    }

    private void resetBoard() {
        // use cellsCoords values to reset the board and search word txt
        for (JTextField txt : cellCoords.values()) {
            txt.setText("");
            txt.setBackground(Color.white);
        }
        txt_word.setText("");
    }

    private void start() {
        // construct the matrix
        char[] row1 = new char[]{
            txt_char1.getText().charAt(0),
            txt_char2.getText().charAt(0),
            txt_char3.getText().charAt(0),
            txt_char4.getText().charAt(0)
        };

        char[] row2 = new char[]{
            txt_char5.getText().charAt(0),
            txt_char6.getText().charAt(0),
            txt_char7.getText().charAt(0),
            txt_char8.getText().charAt(0)
        };

        char[] row3 = new char[]{
            txt_char9.getText().charAt(0),
            txt_char10.getText().charAt(0),
            txt_char11.getText().charAt(0),
            txt_char12.getText().charAt(0)
        };

        char[][] b = new char[][]{row1, row2, row3};

        board = new Board(b, txt_word.getText());
        board.start();
        revealWord(board.getLettersCoords());
    }

    private void revealWord(List<String> coords) {
        for (String coord : coords) {
            JTextField txt = cellCoords.get(coord);
            txt.setBackground(Color.YELLOW.darker());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_char1 = new javax.swing.JTextField();
        txt_char2 = new javax.swing.JTextField();
        txt_char3 = new javax.swing.JTextField();
        txt_char4 = new javax.swing.JTextField();
        txt_char5 = new javax.swing.JTextField();
        txt_char6 = new javax.swing.JTextField();
        txt_char7 = new javax.swing.JTextField();
        txt_char8 = new javax.swing.JTextField();
        txt_char9 = new javax.swing.JTextField();
        txt_char10 = new javax.swing.JTextField();
        txt_char11 = new javax.swing.JTextField();
        txt_char12 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_word = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        txt_char1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char1KeyReleased(evt);
            }
        });

        txt_char2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char2KeyReleased(evt);
            }
        });

        txt_char3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char3KeyReleased(evt);
            }
        });

        txt_char4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char4KeyReleased(evt);
            }
        });

        txt_char5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char5KeyReleased(evt);
            }
        });

        txt_char6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char6KeyReleased(evt);
            }
        });

        txt_char7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char7KeyReleased(evt);
            }
        });

        txt_char8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char8KeyReleased(evt);
            }
        });

        txt_char9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char9KeyReleased(evt);
            }
        });

        txt_char10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char10KeyReleased(evt);
            }
        });

        txt_char11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char11KeyReleased(evt);
            }
        });

        txt_char12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_char12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_char12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_char12KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_char9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_char5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_char1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_char4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_char1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_char5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_char9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_char12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Word Search");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Word to search:");

        txt_word.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_word.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setText("Generate Random");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_word, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(33, 33, 33)
                                .addComponent(jButton2))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_word, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_char1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char1KeyReleased
        charToUpper(evt.getKeyChar(), txt_char1);
    }//GEN-LAST:event_txt_char1KeyReleased

    private void txt_char2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char2KeyReleased
        charToUpper(evt.getKeyChar(), txt_char2);
    }//GEN-LAST:event_txt_char2KeyReleased

    private void txt_char3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char3KeyReleased
        charToUpper(evt.getKeyChar(), txt_char3);
    }//GEN-LAST:event_txt_char3KeyReleased

    private void txt_char4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char4KeyReleased
        charToUpper(evt.getKeyChar(), txt_char4);
    }//GEN-LAST:event_txt_char4KeyReleased

    private void txt_char5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char5KeyReleased
        charToUpper(evt.getKeyChar(), txt_char5);
    }//GEN-LAST:event_txt_char5KeyReleased

    private void txt_char6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char6KeyReleased
        charToUpper(evt.getKeyChar(), txt_char6);
    }//GEN-LAST:event_txt_char6KeyReleased

    private void txt_char7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char7KeyReleased
        charToUpper(evt.getKeyChar(), txt_char7);
    }//GEN-LAST:event_txt_char7KeyReleased

    private void txt_char8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char8KeyReleased
        charToUpper(evt.getKeyChar(), txt_char8);
    }//GEN-LAST:event_txt_char8KeyReleased

    private void txt_char9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char9KeyReleased
        charToUpper(evt.getKeyChar(), txt_char9);
    }//GEN-LAST:event_txt_char9KeyReleased

    private void txt_char10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char10KeyReleased
        charToUpper(evt.getKeyChar(), txt_char10);
    }//GEN-LAST:event_txt_char10KeyReleased

    private void txt_char11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char11KeyReleased
        charToUpper(evt.getKeyChar(), txt_char11);
    }//GEN-LAST:event_txt_char11KeyReleased

    private void txt_char12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_char12KeyReleased
        charToUpper(evt.getKeyChar(), txt_char12);
    }//GEN-LAST:event_txt_char12KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generateRandom();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        resetBoard();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        start();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_char1;
    private javax.swing.JTextField txt_char10;
    private javax.swing.JTextField txt_char11;
    private javax.swing.JTextField txt_char12;
    private javax.swing.JTextField txt_char2;
    private javax.swing.JTextField txt_char3;
    private javax.swing.JTextField txt_char4;
    private javax.swing.JTextField txt_char5;
    private javax.swing.JTextField txt_char6;
    private javax.swing.JTextField txt_char7;
    private javax.swing.JTextField txt_char8;
    private javax.swing.JTextField txt_char9;
    private javax.swing.JTextField txt_word;
    // End of variables declaration//GEN-END:variables
}
