package jsmacro;

import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    
    private String browseForFile(String description, String fileType, int save) {
        JFileChooser f = new JFileChooser(System.getProperty("user.dir"));
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        f.setFileFilter(new FileNameExtensionFilter(description, fileType));
        f.setDialogType(save);
        f.showDialog(f, "JsMacro - " + VERSION);
        if (f.getSelectedFile() != null) {
            if (save == JFileChooser.SAVE_DIALOG &&
                    !f.getSelectedFile().toString().endsWith("." + fileType)) {
                return f.getSelectedFile().toString() + "." + fileType;
            }
            return f.getSelectedFile().toString();
        }
        return "";
    }
    
    private void launchEditor(String pathname) {
        EditDialog e = new EditDialog(pathname, true);
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
        newDataButton = new javax.swing.JButton();
        resetPreviewButton = new javax.swing.JButton();
        previewButton = new javax.swing.JButton();
        itemNumberLabel = new javax.swing.JLabel();
        itemPreviewField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        playModeButton = new javax.swing.JRadioButton();
        insertModeButton = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JMacro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setResizable(false);

        titlePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("JsMacro - " + VERSION));

        dataButton.setText("...");
        dataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDataFile(evt);
            }
        });

        dataLabel.setText("Data (.csv):");

        formatLabel.setText("Macro (.js):");

        formatButton.setText("...");
        formatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setMacroFile(evt);
            }
        });

        startButton.setText("Start");
        startButton.setMaximumSize(new java.awt.Dimension(58, 23));
        startButton.setMinimumSize(new java.awt.Dimension(58, 23));
        startButton.setPreferredSize(new java.awt.Dimension(58, 23));

        infoButton.setText("Info");

        editDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editicon.png"))); // NOI18N
        editDataButton.setMaximumSize(new java.awt.Dimension(45, 30));
        editDataButton.setMinimumSize(new java.awt.Dimension(45, 30));
        editDataButton.setPreferredSize(new java.awt.Dimension(45, 30));
        editDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDataFile(evt);
            }
        });

        editMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editicon.png"))); // NOI18N
        editMacroButton.setMaximumSize(new java.awt.Dimension(45, 30));
        editMacroButton.setMinimumSize(new java.awt.Dimension(45, 30));
        editMacroButton.setPreferredSize(new java.awt.Dimension(45, 30));
        editMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMacroFile(evt);
            }
        });

        newMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add-icon-614x460.png"))); // NOI18N
        newMacroButton.setMaximumSize(new java.awt.Dimension(26, 30));
        newMacroButton.setMinimumSize(new java.awt.Dimension(26, 30));
        newMacroButton.setPreferredSize(new java.awt.Dimension(26, 30));
        newMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMacroFile(evt);
            }
        });

        newDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add-icon-614x460.png"))); // NOI18N
        newDataButton.setMaximumSize(new java.awt.Dimension(26, 30));
        newDataButton.setMinimumSize(new java.awt.Dimension(26, 30));
        newDataButton.setPreferredSize(new java.awt.Dimension(26, 30));
        newDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDataFile(evt);
            }
        });

        resetPreviewButton.setText("Reset");

        previewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/leftarrow.png"))); // NOI18N
        previewButton.setMaximumSize(new java.awt.Dimension(50, 30));
        previewButton.setMinimumSize(new java.awt.Dimension(50, 30));
        previewButton.setPreferredSize(new java.awt.Dimension(50, 30));

        itemNumberLabel.setText("Item [0/0]:");

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rightarrow.png"))); // NOI18N
        nextButton.setMaximumSize(new java.awt.Dimension(50, 30));
        nextButton.setMinimumSize(new java.awt.Dimension(50, 30));
        nextButton.setPreferredSize(new java.awt.Dimension(50, 30));

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
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insertModeButton)
                            .addComponent(playModeButton))
                        .addGap(87, 200, Short.MAX_VALUE)
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
                                .addComponent(newDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(newDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void setDataFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDataFile
        data = browseForFile("CSV Files", "csv", JFileChooser.OPEN_DIALOG);
        dataField.setText(data);
    }//GEN-LAST:event_setDataFile

    private void setMacroFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setMacroFile
        macro = browseForFile("JavaScript Files", "js", JFileChooser.OPEN_DIALOG);
        formatField.setText(macro);
    }//GEN-LAST:event_setMacroFile

    private void getDataFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getDataFile
        Object src = evt.getSource();
        if (src.equals(newDataButton)) {
            data = browseForFile("CSV Files", "csv", JFileChooser.SAVE_DIALOG);
            dataField.setText(data);
        }
        if (!data.isEmpty()) {
            launchEditor(data);
        }
        
    }//GEN-LAST:event_getDataFile

    private void getMacroFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMacroFile
        Object src = evt.getSource();
        if (src.equals(newMacroButton)) {
            macro = browseForFile("JavaScript Files", "js", JFileChooser.SAVE_DIALOG);
            formatField.setText(macro);
        }
        if (!macro.isEmpty()) {
            launchEditor(macro);
        }
    }//GEN-LAST:event_getMacroFile

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JsMacroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JsMacroWindow().setVisible(true);
            }
        });
    }
    
    private static final String VERSION = "v0.0.1";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private String data;
    private String macro;
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
    javax.swing.JProgressBar jProgressBar1;
    private javax.swing.ButtonGroup modeGroup;
    private javax.swing.JButton newDataButton;
    private javax.swing.JButton newMacroButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton playModeButton;
    private javax.swing.JButton previewButton;
    private javax.swing.JButton resetPreviewButton;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}