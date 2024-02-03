

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ashwi
 */
public class TicTacToe extends javax.swing.JFrame {

    public String startGame = "";
    private int ocount = 0;
    private int xcount = 0;
    int checker = 0;
    int Total = 0;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    int aa[][][] = {
        {{11, 22, 33, 44, 1, 66, 77, 88, 99}, {11, 2, 33, 44, 1, 66, 77, 88, 99}, {1, 2, 33, 44, 1, 66, 77, 88, 99}, {1, 2, 33, 44, 1, 66, 77, 88, 2}, {1, 2, 33, 1, 1, 66, 77, 88, 2}},
        {{11, 22, 33, 44, 55, 66, 77, 88, 1}, {11, 22, 33, 44, 2, 66, 77, 88, 1}, {1, 22, 33, 44, 2, 66, 77, 88, 1}, {1, 22, 2, 44, 2, 66, 77, 88, 1}, {1, 22, 2, 44, 2, 66, 1, 88, 1}},
        {{11, 22, 33, 44, 1, 66, 77, 88, 99}, {11, 2, 33, 44, 1, 66, 77, 88, 99}, {11, 2, 1, 44, 1, 66, 77, 88, 99}, {11, 2, 1, 44, 1, 66, 2, 88, 99}, {11, 2, 1, 44, 1, 1, 2, 88, 99}},
        {{11, 22, 33, 44, 1, 66, 77, 88, 99}, {11, 2, 33, 44, 1, 66, 77, 88, 99}, {11, 2, 1, 44, 1, 66, 77, 88, 99}, {11, 2, 1, 44, 1, 66, 2, 88, 99}, {11, 2, 1, 44, 1, 66, 2, 88, 1}},
        {{11, 22, 33, 44, 1, 66, 77, 88, 99}, {11, 2, 33, 44, 1, 66, 77, 88, 99}, {1, 2, 33, 44, 1, 66, 77, 88, 99}, {1, 2, 33, 44, 1, 66, 77, 88, 2}, {1, 2, 33, 44, 1, 66, 1, 88, 2}},
        {{11, 22, 33, 44, 55, 66, 77, 88, 1}, {11, 22, 33, 44, 55, 66, 77, 2, 1}, {11, 22, 33, 44, 1, 66, 77, 2, 1}, {2, 22, 33, 44, 1, 66, 77, 2, 1}, {2, 22, 33, 44, 1, 1, 77, 2, 1}},
        {{11, 22, 33, 44, 55, 66, 1, 88, 99}, {11, 22, 33, 44, 55, 66, 1, 2, 99}, {11, 22, 33, 44, 1, 66, 1, 2, 99}, {11, 22, 2, 44, 1, 66, 1, 2, 99}, {11, 22, 2, 1, 1, 66, 1, 2, 99}},
        {{11, 22, 33, 44, 55, 1, 77, 88, 99}, {11, 2, 33, 44, 55, 1, 77, 88, 99}, {11, 2, 1, 44, 55, 1, 77, 88, 99}, {11, 2, 1, 44, 55, 1, 77, 88, 2}, {11, 2, 1, 44, 1, 1, 77, 88, 2}},
        {{11, 22, 33, 44, 55, 66, 1, 88, 99}, {11, 22, 33, 44, 55, 66, 1, 88, 2}, {11, 22, 33, 1, 55, 66, 1, 88, 2}, {2, 22, 33, 1, 55, 66, 1, 88, 2}, {2, 22, 33, 1, 1, 66, 1, 88, 2}},
        {{11, 22, 1, 44, 55, 66, 77, 88, 99}, {11, 22, 1, 2, 55, 66, 77, 88, 99}, {11, 22, 1, 2, 55, 66, 77, 88, 1}, {11, 22, 1, 2, 55, 2, 77, 88, 1}, {11, 22, 1, 2, 1, 2, 77, 88, 1}},
        {{11, 22, 33, 44, 55, 66, 77, 88, 1}, {11, 22, 33, 2, 55, 66, 77, 88, 1}, {11, 22, 1, 2, 55, 66, 77, 88, 1}, {11, 22, 1, 2, 55, 2, 77, 88, 1}, {11, 22, 1, 2, 1, 2, 77, 88, 1}},
        {{1, 22, 33, 44, 55, 66, 77, 88, 99}, {1, 22, 2, 44, 55, 66, 77, 88, 99}, {1, 22, 2, 1, 55, 66, 77, 88, 99}, {1, 22, 2, 1, 55, 66, 2, 88, 99}, {1, 22, 2, 1, 1, 66, 2, 88, 99}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 22, 33, 2, 55, 66, 77, 1, 99}, {11, 22, 33, 2, 55, 66, 1, 1, 99}, {11, 22, 33, 2, 55, 66, 1, 1, 2}, {11, 22, 33, 2, 1, 66, 1, 1, 2}},
        {{11, 22, 33, 44, 1, 66, 77, 88, 99}, {11, 22, 33, 44, 1, 66, 77, 88, 2}, {1, 22, 33, 44, 1, 66, 77, 88, 2}, {1, 2, 33, 44, 1, 66, 77, 88, 2}, {1, 2, 33, 1, 1, 66, 77, 88, 2}},
        {{11, 22, 33, 44, 1, 66, 77, 88, 99}, {11, 22, 33, 44, 1, 66, 77, 88, 2}, {1, 22, 33, 44, 1, 66, 77, 88, 2}, {1, 22, 33, 2, 1, 66, 77, 88, 2}, {1, 1, 33, 2, 1, 66, 77, 88, 2}},
        {{11, 22, 33, 44, 55, 1, 77, 88, 99}, {11, 22, 33, 44, 55, 1, 77, 88, 2}, {11, 1, 33, 44, 55, 1, 77, 88, 2}, {11, 1, 2, 44, 55, 1, 77, 88, 2}, {11, 1, 2, 44, 1, 1, 77, 88, 2}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 1, 44, 55, 66, 77, 1, 99}, {11, 2, 1, 2, 55, 66, 77, 1, 99}, {11, 2, 1, 2, 55, 66, 77, 1, 1}},
        {{11, 22, 33, 44, 55, 66, 77, 88, 1}, {2, 22, 33, 44, 55, 66, 77, 88, 1}, {2, 22, 33, 44, 55, 66, 1, 88, 1}, {2, 22, 33, 44, 55, 66, 1, 2, 1}, {2, 22, 1, 44, 55, 66, 1, 2, 1}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 1, 44, 55, 66, 77, 1, 99}, {2, 2, 1, 44, 55, 66, 77, 1, 99}, {2, 2, 1, 44, 55, 66, 77, 1, 1}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 2, 44, 55, 66, 77, 1, 99}, {1, 2, 2, 44, 55, 66, 1, 1, 99}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 44, 55, 2, 77, 1, 99}, {1, 2, 33, 44, 55, 2, 1, 1, 99}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 1, 44, 55, 66, 77, 1, 99}, {11, 2, 1, 44, 55, 2, 77, 1, 99}, {11, 2, 1, 44, 55, 2, 1, 1, 99}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 2, 55, 66, 77, 1, 99}, {1, 2, 33, 2, 55, 66, 77, 1, 1}},
        {{11, 22, 33, 44, 55, 66, 77, 1, 99}, {11, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 44, 55, 66, 77, 1, 99}, {1, 2, 33, 44, 2, 66, 77, 1, 99}, {1, 2, 33, 44, 2, 66, 77, 1, 1},}
    };

    int a[][] = {{11, 22, 33}, {44, 55, 66}, {77, 88, 99}};
    int i, n, zzz = 1, ooxx;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public TicTacToe() {
        initComponents();
        jButtonnewgame.setEnabled(false);
        jButton1.addKeyListener(new KeyListenerDemo());
        jButton2.addKeyListener(new KeyListenerDemo());
        jButton3.addKeyListener(new KeyListenerDemo());
        jButton4.addKeyListener(new KeyListenerDemo());
        jButton5.addKeyListener(new KeyListenerDemo());
        jButton6.addKeyListener(new KeyListenerDemo());
        jButton7.addKeyListener(new KeyListenerDemo());
        jButton8.addKeyListener(new KeyListenerDemo());
        jButton9.addKeyListener(new KeyListenerDemo());
        jButtonnewgame.addKeyListener(new KeyListenerDemo());
        jButtonreset.addKeyListener(new KeyListenerDemo());
        jButtonexit.addKeyListener(new KeyListenerDemo());
        loading_components();
        //System.out.println(startGame.length()+ " tttttttttt");
        //if(startGame.length()==-1)
        //    
        try {
            if (startGame.length() == -1) {
                startGame = "x";
            }
        } catch (Exception e) {
            startGame = "x";
        }
        if (startGame.equalsIgnoreCase("x")) {
            zzz = 0;
            computer();
        }
        jLabelplayero.setBackground(Color.WHITE);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButtonnewgame = new javax.swing.JButton();
        jButtonexit = new javax.swing.JButton();
        jButtonreset = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabelplayero = new javax.swing.JLabel();
        jLabelo = new javax.swing.JLabel();
        jLabelx = new javax.swing.JLabel();
        jLabeplayerx = new javax.swing.JLabel();
        jLabeltotal = new javax.swing.JLabel();
        jLabelDisplayTotal = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(95, 158, 160));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(95, 158, 160));

        jPanel4.setBackground(new java.awt.Color(95, 158, 160));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBackground(new java.awt.Color(95, 158, 160));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("                          Tic Tac Toe");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(95, 158, 160));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButtonnewgame.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButtonnewgame.setText("New Game");
        jButtonnewgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonnewgameActionPerformed(evt);
            }
        });

        jButtonexit.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButtonexit.setText("Exit");
        jButtonexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonexitActionPerformed(evt);
            }
        });

        jButtonreset.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jButtonreset.setText("Reset");
        jButtonreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonnewgame, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButtonreset, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButtonnewgame, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonreset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(95, 158, 160));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabelplayero.setBackground(new java.awt.Color(255, 255, 255));
        jLabelplayero.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        jLabelplayero.setText("Player:O");
        jLabelplayero.setOpaque(true);

        jLabelo.setBackground(java.awt.Color.white);
        jLabelo.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        jLabelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelo.setText("0");
        jLabelo.setOpaque(true);

        jLabelx.setBackground(java.awt.Color.white);
        jLabelx.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        jLabelx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelx.setText("0");
        jLabelx.setOpaque(true);

        jLabeplayerx.setBackground(new java.awt.Color(255, 255, 255));
        jLabeplayerx.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        jLabeplayerx.setText("Player:X");
        jLabeplayerx.setOpaque(true);

        jLabeltotal.setBackground(new java.awt.Color(51, 153, 255));
        jLabeltotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabeltotal.setText("Total match:");
        jLabeltotal.setOpaque(true);

        jLabelDisplayTotal.setBackground(java.awt.Color.white);
        jLabelDisplayTotal.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        jLabelDisplayTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDisplayTotal.setText("0");
        jLabelDisplayTotal.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabeplayerx, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelx, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabelplayero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelDisplayTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeplayerx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelplayero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDisplayTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1() {
        a[0][0] = 2;
        String b1 = jButton1.getText();
        if (!"x".equals(b1) && !"o".equals(b1) && checker == 0) {
            jButton1.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2() {
        a[0][1] = 2;
        String b2 = jButton2.getText();
        if (!"x".equals(b2) && !"o".equals(b2) && checker == 0) {
            jButton2.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3() {
        a[0][2] = 2;
        String b3 = jButton3.getText();
        if (!"x".equals(b3) && !"o".equals(b3) && checker == 0) {
            jButton3.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       jButton4();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4() {
        a[1][0] = 2;
        String b4 = jButton4.getText();
        if (!"x".equals(b4) && !"o".equals(b4) && checker == 0) {
            jButton4.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5() {
        a[1][1] = 2;
        String b5 = jButton5.getText();
        if (!"x".equals(b5) && !"o".equals(b5) && checker == 0) {
            jButton5.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6() {
        a[1][2] = 2;
        String b6 = jButton6.getText();
        if (!"x".equals(b6) && !"o".equals(b6) && checker == 0) {
            jButton6.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7() {
        a[2][0] = 2;
        String b7 = jButton7.getText();
        if (!"x".equals(b7) && !"o".equals(b7) && checker == 0) {
            jButton7.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

     private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         jButton8();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8() {
        a[2][1] = 2;
        String b8 = jButton8.getText();
        if (!"x".equals(b8) && !"o".equals(b8) && checker == 0) {
            jButton8.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton9() {
        a[2][2] = 2;
        String b9 = jButton9.getText();
        if (!"x".equals(b9) && !"o".equals(b9) && checker == 0) {
            jButton9.setText("o");
            winningGame();
            if (!arrayisfull()) {
                computer();
            }
        }
    }

    private JFrame frame;
    private void jButtonexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonexitActionPerformed
        jButtonexit();
    }//GEN-LAST:event_jButtonexitActionPerformed

    private void jButtonexit() {
        frame = new JFrame("Exit");
        if ((JOptionPane.showConfirmDialog(frame, "Comfirm if you want to exit", " 'Tic tac Toe' ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
            writing_Player();
            System.exit(0);
        }
    }

    private void loading_components() {
        
        File folder = new File("C:\\TicTacToeDataFiles");
        if (!folder.exists())
            folder.mkdirs();  // Create the folder and any necessary parent folders
          
        String ss1 = null;
        boolean TherisNowError = true;
        try {
            BufferedReader br;
            FileReader fr;
            fr = new FileReader("C:\\TicTacToeDataFiles\\highscore.txt");
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                ss1 = sCurrentLine;
            }
        } catch (IOException e) {
            //TherisNowError = false;
            writing_total();
            writing_oplayer();
            writing_xplayer();
        }
        if (TherisNowError) {
            {
                String ss = null;
                try {
                    BufferedReader br ;
                    FileReader fr;
                    fr = new FileReader("C:\\TicTacToeDataFiles\\highscore.txt");
                    br = new BufferedReader(fr);
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        ss = sCurrentLine;
                    } 
                } catch (IOException e) {
                }
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                Total = Integer.parseInt(ss);
                jLabelDisplayTotal.setText(ss);
                ooxx = Total;
            }
            //////////////////////////////////////////////////////////////////////////////////////////////
            {
                String ss = null;
                try {
                    BufferedReader br ;
                    FileReader fr;
                    fr = new FileReader("C:\\TicTacToeDataFiles\\ocount.txt");
                    br = new BufferedReader(fr);
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        ss = sCurrentLine;
                    }
                } catch (IOException e) {
                }
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                ocount = Integer.parseInt(ss);
                jLabelo.setText(ss);
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            {
                String ss = null;
                try {
                    BufferedReader br;
                    FileReader fr ;
                    fr = new FileReader("C:\\TicTacToeDataFiles\\xcount.txt");
                    br = new BufferedReader(fr);
                    String sCurrentLine ;
                    while ((sCurrentLine = br.readLine()) != null) {
                        ss = sCurrentLine;
                    }
                } catch (IOException e) {
                }
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                xcount = Integer.parseInt(ss);
                jLabelx.setText(ss);
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            {
                String ss = null;
                try {
                    BufferedReader br;
                    FileReader fr;
                    fr = new FileReader("C:\\TicTacToeDataFiles\\playerstoped.txt");
                    br = new BufferedReader(fr);
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        ss = sCurrentLine;
                    }
                } catch (IOException e) {
                }
                startGame = ss;
            }
        }
    }

    private void incresestotal() {
        Total++;
        writing_total();
        jLabelDisplayTotal.setText(Integer.toString(Total));
    }

    private void writing_total() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\TicTacToeDataFiles\\highscore.txt", "UTF-8");
            writer.println(Integer.toString(Total));
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }

    private void writing_oplayer() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\TicTacToeDataFiles\\ocount.txt", "UTF-8");
            writer.println(Integer.toString(ocount));
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }

    private void writing_xplayer() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\TicTacToeDataFiles\\xcount.txt", "UTF-8");
            writer.println(Integer.toString(xcount));
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }

    private void writing_Player() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\TicTacToeDataFiles\\playerstoped.txt", "UTF-8");
            writer.println(startGame);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }

    private void gameScore(String p) {
        checker++;
        incresestotal();
        jLabelx.setText(String.valueOf(xcount));
        jLabelo.setText(String.valueOf(ocount));
        choose_a_Playerifwins(p);
    }

    private void choose_a_Player() {

        if (startGame.equalsIgnoreCase("x")) {
            startGame = "o";
        } else {
            startGame = "x";
        }

        writing_Player();
    }

    private void choose_a_Playerifwins(String p) {

        if (p.equalsIgnoreCase("x")) {
            startGame = "x";
        } else {
            startGame = "o";
        }

        writing_Player();
    }

    private void winningGame() {

        String b1 = jButton1.getText();
        String b2 = jButton2.getText();
        String b3 = jButton3.getText();
        String b4 = jButton4.getText();
        String b5 = jButton5.getText();
        String b6 = jButton6.getText();
        String b7 = jButton7.getText();
        String b8 = jButton8.getText();
        String b9 = jButton9.getText();

        if (checker == 0) {
            if ("x".equals(b1) && "x".equals(b2) && "x".equals(b3)) {

                jButton1.setBackground(Color.ORANGE);
                jButton2.setBackground(Color.ORANGE);
                jButton3.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b4) && "x".equals(b5) && "x".equals(b6)) {

                jButton4.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton6.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b7) && "x".equals(b8) && "x".equals(b9)) {

                jButton7.setBackground(Color.ORANGE);
                jButton8.setBackground(Color.ORANGE);
                jButton9.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b1) && "x".equals(b5) && "x".equals(b9)) {

                jButton1.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton9.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b3) && "x".equals(b5) && "x".equals(b7)) {

                jButton7.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton3.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b1) && "x".equals(b4) && "x".equals(b7)) {

                jButton1.setBackground(Color.ORANGE);
                jButton4.setBackground(Color.ORANGE);
                jButton7.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b2) && "x".equals(b5) && "x".equals(b8)) {

                jButton2.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton8.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'X' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("x".equals(b3) && "x".equals(b6) && "x".equals(b9)) {

                jButton3.setBackground(Color.ORANGE);
                jButton6.setBackground(Color.ORANGE);
                jButton9.setBackground(Color.ORANGE);
                xcount++;
                writing_xplayer();
                gameScore("x");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b1) && "o".equals(b2) && "o".equals(b3)) {

                jButton1.setBackground(Color.ORANGE);
                jButton2.setBackground(Color.ORANGE);
                jButton3.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b4) && "o".equals(b5) && "o".equals(b6)) {

                jButton4.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton6.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b7) && "o".equals(b8) && "o".equals(b9)) {

                jButton9.setBackground(Color.ORANGE);
                jButton8.setBackground(Color.ORANGE);
                jButton7.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b1) && "o".equals(b5) && "o".equals(b9)) {
                jButton9.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton1.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);

            } else if ("o".equals(b3) && "o".equals(b5) && "o".equals(b7)) {

                jButton3.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton7.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b1) && "o".equals(b4) && "o".equals(b7)) {

                jButton1.setBackground(Color.ORANGE);
                jButton4.setBackground(Color.ORANGE);
                jButton7.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b2) && "o".equals(b5) && "o".equals(b8)) {

                jButton2.setBackground(Color.ORANGE);
                jButton5.setBackground(Color.ORANGE);
                jButton8.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b3) && "o".equals(b6) && "o".equals(b9)) {
                jButton3.setBackground(Color.ORANGE);
                jButton6.setBackground(Color.ORANGE);
                jButton9.setBackground(Color.ORANGE);
                ocount++;
                writing_oplayer();
                gameScore("o");
                JOptionPane.showConfirmDialog(this, "Player 'O' Wins", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else if ("o".equals(b1) || "x".equals(b1)) {
                if ("o".equals(b2) || "x".equals(b2)) {
                    if ("o".equals(b3) || "x".equals(b3)) {
                        if ("o".equals(b4) || "x".equals(b4)) {
                            if ("o".equals(b5) || "x".equals(b5)) {
                                if ("o".equals(b6) || "x".equals(b6)) {
                                    if ("o".equals(b7) || "x".equals(b7)) {
                                        if ("o".equals(b8) || "x".equals(b8)) {
                                            if ("o".equals(b9) || "x".equals(b9)) {
                                                JOptionPane.showConfirmDialog(this, "Draw Match...!", "Tic tac Toe", JOptionPane.INFORMATION_MESSAGE);
                                                checker = 0;
                                                incresestotal();
                                                choose_a_Player();

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void jButtonresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonresetActionPerformed
        jButtonreset();
    }//GEN-LAST:event_jButtonresetActionPerformed

    private void jButtonreset() {
        if (arrayisfull() || ooxx != Total) {
            ooxx = Total;
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            jButton1.setText("");
            jButton2.setText("");
            jButton3.setText("");
            jButton4.setText("");
            jButton5.setText("");
            jButton6.setText("");
            jButton7.setText("");
            jButton8.setText("");
            jButton9.setText("");
            checker = 0;
            jButton1.setBackground(Color.LIGHT_GRAY);
            jButton2.setBackground(Color.LIGHT_GRAY);
            jButton3.setBackground(Color.LIGHT_GRAY);
            jButton4.setBackground(Color.LIGHT_GRAY);
            jButton5.setBackground(Color.LIGHT_GRAY);
            jButton6.setBackground(Color.LIGHT_GRAY);
            jButton7.setBackground(Color.LIGHT_GRAY);
            jButton8.setBackground(Color.LIGHT_GRAY);
            jButton9.setBackground(Color.LIGHT_GRAY);

            checker = 0;
            a[0][0] = 11;
            a[0][1] = 22;
            a[0][2] = 33;
            a[1][0] = 44;
            a[1][1] = 55;
            a[1][2] = 66;
            a[2][0] = 77;
            a[2][1] = 88;
            a[2][2] = 99;
            if (startGame.equalsIgnoreCase("x")) {
                computer();
            }
        }
    }

    private void jButtonnewgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonnewgameActionPerformed
        jButtonnewgame();
    }//GEN-LAST:event_jButtonnewgameActionPerformed

    private void jButtonnewgame() {

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);

        jLabelx.setText("0");
        jLabelo.setText("0");

        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");

        jButton1.setBackground(Color.LIGHT_GRAY);
        jButton2.setBackground(Color.LIGHT_GRAY);
        jButton3.setBackground(Color.LIGHT_GRAY);
        jButton4.setBackground(Color.LIGHT_GRAY);
        jButton5.setBackground(Color.LIGHT_GRAY);
        jButton6.setBackground(Color.LIGHT_GRAY);
        jButton7.setBackground(Color.LIGHT_GRAY);
        jButton8.setBackground(Color.LIGHT_GRAY);
        jButton9.setBackground(Color.LIGHT_GRAY);
        checker = 0;
        ocount = 0;
        xcount = 0;
        a[0][0] = 11;
        a[0][1] = 22;
        a[0][2] = 33;
        a[1][0] = 44;
        a[1][1] = 55;
        a[1][2] = 66;
        a[2][0] = 77;
        a[2][1] = 88;
        a[2][2] = 99;
        startGame = "x";

        if (startGame.equalsIgnoreCase("x")) {
            computer();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void computer() {
        String b1 = jButton1.getText();
        String b2 = jButton2.getText();
        String b3 = jButton3.getText();
        String b4 = jButton4.getText();
        String b5 = jButton5.getText();
        String b6 = jButton6.getText();
        String b7 = jButton7.getText();
        String b8 = jButton8.getText();
        String b9 = jButton9.getText();
        a[0][0] = 11;
        a[0][1] = 22;
        a[0][2] = 33;
        a[1][0] = 44;
        a[1][1] = 55;
        a[1][2] = 66;
        a[2][0] = 77;
        a[2][1] = 88;
        a[2][2] = 99;
        if ("x".equals(b1)) {
            a[0][0] = 1;
        } else if ("o".equals(b1)) {
            a[0][0] = 2;
        }
        if ("x".equals(b2)) {
            a[0][1] = 1;
        } else if ("o".equals(b2)) {
            a[0][1] = 2;
        }
        if ("x".equals(b3)) {
            a[0][2] = 1;
        } else if ("o".equals(b3)) {
            a[0][2] = 2;
        }
        if ("x".equals(b4)) {
            a[1][0] = 1;
        } else if ("o".equals(b4)) {
            a[1][0] = 2;
        }
        if ("x".equals(b5)) {
            a[1][1] = 1;
        } else if ("o".equals(b5)) {
            a[1][1] = 2;
        }
        if ("x".equals(b6)) {
            a[1][2] = 1;
        } else if ("o".equals(b6)) {
            a[1][2] = 2;
        }
        if ("x".equals(b7)) {
            a[2][0] = 1;
        } else if ("o".equals(b7)) {
            a[2][0] = 2;
        }
        if ("x".equals(b8)) {
            a[2][1] = 1;
        } else if ("o".equals(b8)) {
            a[2][1] = 2;
        }
        if ("x".equals(b9)) {
            a[2][2] = 1;
        } else if ("o".equals(b9)) {
            a[2][2] = 2;
        }
        int dd1[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};
        int dd2[] = {7, 4, 1, 8, 5, 2, 9, 6, 3};
        int ii, nn, mm, mmm = 0, p1;
        int aaaaa[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int aaaaa1[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int a1[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int a2[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int a3[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int a4[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        if (checker == 0) {
            if (zzz == 0) {
                zzz++;
                int zxcv;
                mmm = 1;
                double asdf = Math.random();
                double zxcvv = asdf * 10;
                zxcv = (int) zxcvv;
                p1 = 1;
                for (i = 0; i < 3; i++) {
                    for (n = 0; n < 3; n++) {
                        if (p1 == zxcv) {
                            if (a[i][n] >= 11) {
                                a[i][n] = 1;
                            }
                        }
                        p1++;
                    }
                }
            }

            if (zzz <= 6 && mmm == 0) {
                int a1a1a1 = 0;
                for (i = 0; i < 3; i++) {
                    for (n = 0; n < 3; n++) {
                        aaaaa[a1a1a1] = a[i][n];
                        aaaaa1[a1a1a1] = a[i][n];
                        a1a1a1++;
                    }
                }

                for (i = 0; i <= 8; i++) {
                    {
                        a1[i] = aaaaa[i];
                    }

                    if (aaaaa[dd1[i] - 1] <= 2) {
                        a2[i] = aaaaa[dd1[i] - 1];
                    }

                    if (aaaaa[dd2[i] - 1] <= 2) {
                        a3[i] = aaaaa[dd2[i] - 1];
                    }

                    if (aaaaa[8 - i] <= 2) {
                        a4[i] = aaaaa[8 - i];
                    }
                }
            }
            ///  

            for (ii = 100; (ii <= 23 && mmm == 0); ii++) {
                int aa1b2[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
                int aa1b3[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
                int aa1b4[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
                int aa1b5[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
                for (nn = 1; nn <= 4; nn++) {
                    for (mm = 0; mm <= 8; mm++) {

                        switch (nn) {
                            case 1:
                                aa1b2[mm] = aa[ii][nn][mm];
                                break;
                            case 2:
                                aa1b3[mm] = aa[ii][nn][mm];
                                break;
                            case 3:
                                aa1b4[mm] = aa[ii][nn][mm];
                                break;
                            case 4:
                                aa1b5[mm] = aa[ii][nn][mm];
                                break;
                            default:
                                break;
                        }
                    }
                }
                if (zzz == 2 && mmm == 0) {
                    int t1 = 0, t2 = 0, t3 = 0, t4 = 0;
                    for (n = 0; n <= 8; n++) {
                        if (a1[n] == aa1b2[n]) {
                            t1++;
                        }
                        if (a2[n] == aa1b2[n]) {
                            t2++;
                        }
                        if (a3[n] == aa1b2[n]) {
                            t3++;
                        }
                        if (a4[n] == aa1b2[n]) {
                            t4++;
                        }
                    }
                    if (t1 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b3[i];
                            mmm = 1;
                        }
                    }
                    if (t2 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b3[dd2[i] - 1];
                            mmm = 1;
                        }
                    }
                    if (t3 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b3[dd1[i] - 1];
                            mmm = 1;
                        }
                    }
                    if (t4 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b3[8 - i];
                            mmm = 1;
                        }
                    }
                }
                if (zzz == 4 && mmm == 0) {
                    int t1 = 0, t2 = 0, t3 = 0, t4 = 0;
                    for (n = 0; n <= 8; n++) {
                        if (a1[n] == aa1b4[n]) {
                            t1++;
                        }
                        if (a2[n] == aa1b4[n]) {
                            t2++;
                        }
                        if (a3[n] == aa1b4[n]) {
                            t3++;
                        }
                        if (a4[n] == aa1b4[n]) {
                            t4++;
                        }
                    }
                    if (t1 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b5[i];
                            mmm = 1;
                        }
                    }
                    if (t2 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b5[dd2[i] - 1];
                            mmm = 1;
                        }
                    }
                    if (t3 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b5[dd1[i] - 1];
                            mmm = 1;
                        }
                    }
                    if (t4 == 9) {
                        for (i = 0; i <= 8; i++) {
                            aaaaa[i] = aa1b5[8 - i];
                            mmm = 1;
                        }
                    }
                }

                if (mmm == 1) {
                    int zz3 = 0;
                    for (i = 0; i < 3; i++) {
                        for (n = 0; n < 3; n++) {
                            if (aaaaa[zz3] <= 2) {
                                a[i][n] = aaaaa[zz3];
                            } else {
                                a[i][n] = (zz3 + 1) * 10 + (zz3 + 1);
                            }
                            zz3++;
                        }
                    }
                }
            }

            for (int tim = 1; tim <= 2 && mmm == 0; tim++) {
                if ((mmm == 0 && zzz >= 1)) {

                    int z1 = a[0][0], z2 = a[0][1], z3 = a[0][2];
                    int z4 = a[1][0], z5 = a[1][1], z6 = a[1][2];
                    int z7 = a[2][0], z8 = a[2][1], z9 = a[2][2];
                    mmm = 1;
                    if (z1 == tim && z2 == tim && z3 > 4) {
                        a[0][2] = 1;
                    } else if (z1 == tim && z3 == tim && z2 > 4) {
                        a[0][1] = 1;
                    } else if (z2 == tim && z3 == tim && z1 > 4) {
                        a[0][0] = 1;
                    } else if (z4 == tim && z5 == tim && z6 > 4) {
                        a[1][2] = 1;
                    } else if (z4 == tim && z6 == tim && z5 > 4) {
                        a[1][1] = 1;
                    } else if (z5 == tim && z6 == tim && z4 > 4) {
                        a[1][0] = 1;
                    } else if (z7 == tim && z8 == tim && z9 > 4) {
                        a[2][2] = 1;
                    } else if (z7 == tim && z9 == tim && z8 > 4) {
                        a[2][1] = 1;
                    } else if (z8 == tim && z9 == tim && z7 > 4) {
                        a[2][0] = 1;
                    } else if (z1 == tim && z4 == tim && z7 > 4) {
                        a[2][0] = 1;
                    } else if (z1 == tim && z7 == tim && z4 > 4) {
                        a[1][0] = 1;
                    } else if (z4 == tim && z7 == tim && z1 > 4) {
                        a[0][0] = 1;
                    } else if (z2 == tim && z5 == tim && z8 > 4) {
                        a[2][1] = 1;
                    } else if (z2 == tim && z8 == tim && z5 > 4) {
                        a[1][1] = 1;
                    } else if (z5 == tim && z8 == tim && z2 > 4) {
                        a[0][1] = 1;
                    } else if (z3 == tim && z6 == tim && z9 > 4) {
                        a[2][2] = 1;
                    } else if (z3 == tim && z9 == tim && z6 > 4) {
                        a[1][2] = 1;
                    } else if (z6 == tim && z9 == tim && z3 > 4) {
                        a[0][2] = 1;
                    } else if (z1 == tim && z5 == tim && z9 > 4) {
                        a[2][2] = 1;
                    } else if (z1 == tim && z9 == tim && z5 > 4) {
                        a[1][1] = 1;
                    } else if (z5 == tim && z9 == tim && z1 > 4) {
                        a[0][0] = 1;
                    } else if (z3 == tim && z5 == tim && z7 > 4) {
                        a[2][0] = 1;
                    } else if (z3 == tim && z7 == tim && z5 > 4) {
                        a[1][1] = 1;
                    } else if (z5 == tim && z7 == tim && z3 > 4) {
                        a[0][2] = 1;
                    } else {
                        mmm = 0;
                    }

                }
            }

            if (mmm == 0) {
                mmm = 1;
                for (int bnm = 1; bnm == 1;) {
                    double asdf = Math.random();
                    double zxcvv = asdf * 10;
                    int zxcv = (int) zxcvv;
                    int p11 = 1;
                    for (i = 0; i < 3; i++) {
                        for (n = 0; n < 3; n++) {
                            if (p11 == zxcv) {
                                if (a[i][n] >= 3) {
                                    a[i][n] = 1;
                                    bnm = 0;
                                } else {
                                    bnm = 1;
                                }
                            }
                            p11++;
                        }
                    }
                }
            }

            if (a[0][0] != aaaaa1[0]) {
                jButton1.setText("x");
            } else if (a[0][1] != aaaaa1[1]) {
                jButton2.setText("x");
            } else if (a[0][2] != aaaaa1[2]) {
                jButton3.setText("x");
            } else if (a[1][0] != aaaaa1[3]) {
                jButton4.setText("x");
            } else if (a[1][1] != aaaaa1[4]) {
                jButton5.setText("x");
            } else if (a[1][2] != aaaaa1[5]) {
                jButton6.setText("x");
            } else if (a[2][0] != aaaaa1[6]) {
                jButton7.setText("x");
            } else if (a[2][1] != aaaaa1[7]) {
                jButton8.setText("x");
            } else if (a[2][2] != aaaaa1[8]) {
                jButton9.setText("x");
            }
            if (mmm == 1) {
                winningGame();
            }
        }
    }

    private boolean arrayisfull() {
        boolean yess = true;
        for (int yyyy = 0; yyyy < 3; yyyy++) {
            for (int yy22 = 0; yy22 < 3; yy22++) {
                if (a[yyyy][yy22] >= 11) {
                    yess = false;
                    break;
                }
            }
        }
        return (yess);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TicTacToe().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonexit;
    private javax.swing.JButton jButtonnewgame;
    private javax.swing.JButton jButtonreset;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDisplayTotal;
    private javax.swing.JLabel jLabelo;
    private javax.swing.JLabel jLabelplayero;
    private javax.swing.JLabel jLabeltotal;
    private javax.swing.JLabel jLabelx;
    private javax.swing.JLabel jLabeplayerx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

    class KeyListenerDemo implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {

            switch (e.getKeyChar()) {
                case '7' ->
                    jButton1();
                case '8' ->
                    jButton2();
                case '9' ->
                    jButton3();
                case '4' ->
                    jButton4();
                case '5' ->
                    jButton5();
                case '6' ->
                    jButton6();
                case '1' ->
                    jButton7();
                case '2' ->
                    jButton8();
                case '3' ->
                    jButton9();
                case 'n','N' ->
                    jButtonnewgame();
                case 'r','R' ->
                    jButtonreset();
                case 'e','E' ->
                    jButtonexit();
                default -> {
                }
            }

        }
    }
}
