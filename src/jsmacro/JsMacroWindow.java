package jsmacro;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ben Cochrane
 */
public class JsMacroWindow extends javax.swing.JFrame {

    public JsMacroWindow() {
        initComponents();
        super.setLocationRelativeTo(null);
        new GlobalKeyListener(this).register();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeGroup = new javax.swing.ButtonGroup();
        titlePanel = new javax.swing.JPanel();
        dataField = new javax.swing.JTextField();
        dataButton = new javax.swing.JButton();
        dataLabel = new javax.swing.JLabel();
        formatLabel = new javax.swing.JLabel();
        formatField = new javax.swing.JTextField();
        formatButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        editDataButton = new javax.swing.JButton();
        editMacroButton = new javax.swing.JButton();
        newMacroButton = new javax.swing.JButton();
        newDataFile = new javax.swing.JButton();
        resetPreviewButton = new javax.swing.JButton();
        previewButton = new javax.swing.JButton();
        itemNumberLabel = new javax.swing.JLabel();
        itemPreviewField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        playModeButton = new javax.swing.JRadioButton();
        insertModeButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JMacro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setResizable(false);

        titlePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("JsMacro v0.0.1"));

        dataButton.setText("...");

        dataLabel.setText("Data (.csv):");

        formatLabel.setText("Macro (.js):");

        formatButton.setText("...");

        startButton.setText("Start");
        startButton.setMaximumSize(new java.awt.Dimension(58, 23));
        startButton.setMinimumSize(new java.awt.Dimension(58, 23));
        startButton.setPreferredSize(new java.awt.Dimension(58, 23));

        infoButton.setText("Info");

        editDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editicon.png"))); // NOI18N
        editDataButton.setMaximumSize(new java.awt.Dimension(45, 23));
        editDataButton.setMinimumSize(new java.awt.Dimension(45, 23));
        editDataButton.setPreferredSize(new java.awt.Dimension(45, 23));

        editMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editicon.png"))); // NOI18N
        editMacroButton.setMaximumSize(new java.awt.Dimension(45, 23));
        editMacroButton.setMinimumSize(new java.awt.Dimension(45, 23));
        editMacroButton.setPreferredSize(new java.awt.Dimension(45, 23));

        newMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add-icon-614x460.png"))); // NOI18N
        newMacroButton.setMaximumSize(new java.awt.Dimension(26, 23));
        newMacroButton.setMinimumSize(new java.awt.Dimension(26, 23));
        newMacroButton.setPreferredSize(new java.awt.Dimension(26, 23));

        newDataFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add-icon-614x460.png"))); // NOI18N
        newDataFile.setMaximumSize(new java.awt.Dimension(26, 23));
        newDataFile.setMinimumSize(new java.awt.Dimension(26, 23));
        newDataFile.setPreferredSize(new java.awt.Dimension(26, 23));

        resetPreviewButton.setText("Reset");

        previewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/leftarrow.png"))); // NOI18N
        previewButton.setMaximumSize(new java.awt.Dimension(50, 23));
        previewButton.setMinimumSize(new java.awt.Dimension(50, 23));
        previewButton.setPreferredSize(new java.awt.Dimension(50, 23));

        itemNumberLabel.setText("Item [0/0]:");

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rightarrow.png"))); // NOI18N
        nextButton.setMaximumSize(new java.awt.Dimension(50, 23));
        nextButton.setMinimumSize(new java.awt.Dimension(50, 23));
        nextButton.setPreferredSize(new java.awt.Dimension(50, 23));

        playModeButton.setSelected(true);
        playModeButton.setText("Play Mode");

        insertModeButton.setText("Insert Mode");
        insertModeButton.setEnabled(false);

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insertModeButton)
                            .addComponent(playModeButton))
                        .addGap(87, 188, Short.MAX_VALUE)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formatLabel)
                            .addComponent(dataLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataField)
                            .addComponent(formatField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                .addComponent(formatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMacroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newMacroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                .addComponent(dataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newDataFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addComponent(resetPreviewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemNumberLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemPreviewField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editDataButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataLabel)
                            .addComponent(dataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataButton)))
                    .addComponent(newDataFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(formatLabel)
                        .addComponent(formatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(formatButton))
                    .addComponent(editMacroButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newMacroButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(playModeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertModeButton))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(infoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetPreviewButton)
                    .addComponent(previewButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(itemNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(itemPreviewField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JsMacroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JsMacroWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dataButton;
    private javax.swing.JTextField dataField;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JButton editDataButton;
    private javax.swing.JButton editMacroButton;
    private javax.swing.JButton formatButton;
    private javax.swing.JTextField formatField;
    private javax.swing.JLabel formatLabel;
    private javax.swing.JButton infoButton;
    private javax.swing.JRadioButton insertModeButton;
    private javax.swing.JLabel itemNumberLabel;
    private javax.swing.JTextField itemPreviewField;
    private javax.swing.ButtonGroup modeGroup;
    private javax.swing.JButton newDataFile;
    private javax.swing.JButton newMacroButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton playModeButton;
    private javax.swing.JButton previewButton;
    private javax.swing.JButton resetPreviewButton;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}