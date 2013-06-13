package jsmacro;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        background = titlePanel.getBackground();
        data = "";
        macro = "";
        Console.start();
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
    
    private void launchInfo() {
        InfoDialog i = new InfoDialog();
    }
    
    public RecordModel genModel() {
        try {
            this.model = new RecordModel(new File(data));
        } catch (FileNotFoundException ex) {
            Console.Log("Could not find .csv file.");
        } catch (IOException ex) {
            Console.Log("Could not open data file.");
        }
        this.model.registerGuiHooks(this);
        updateGui();
        return this.model;
    }
    
    public void updateGui() {
        if (model == null) 
            return;
        StringBuilder sb = new StringBuilder();
        sb.append("Item[");
        sb.append(model.record());
        sb.append("/");
        sb.append(model.numRecords());
        sb.append("]");
        itemNumberLabel.setText(sb.toString());
        sb.delete(0, sb.length());
        
        for (int i = 0; i < model.recordSize(); ++i) {
            sb.append(model.get(i));
            if (i < model.recordSize() - 1) {
                sb.append(",");
            }
        }
        itemPreviewField.setText(sb.toString());
    }
    
    public void setMacroState(State state) {
        this.state = state;
        switch (state) {
            case Loading:
                titlePanel.setBackground(background);
                startButton.setText("Start");
                break;
            case Ready:
                titlePanel.setBackground(Color.green);
                startButton.setText("Stop");
                break;
            case Running:
                titlePanel.setBackground(Color.red);
                startButton.setText("Stop");
                break;
        }
    }
    
    public State getMacroState() {
        return state;
    }
    
    public String getData() {
        return data;
    }
    
    public String getMacro() {
        return macro;
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
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMacro(evt);
            }
        });

        infoButton.setText("Info");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getInfoDialog(evt);
            }
        });

        editDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editicon.png"))); // NOI18N
        editDataButton.setMaximumSize(new java.awt.Dimension(26, 23));
        editDataButton.setMinimumSize(new java.awt.Dimension(26, 23));
        editDataButton.setPreferredSize(new java.awt.Dimension(26, 23));
        editDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDataFile(evt);
            }
        });

        editMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editicon.png"))); // NOI18N
        editMacroButton.setMaximumSize(new java.awt.Dimension(26, 23));
        editMacroButton.setMinimumSize(new java.awt.Dimension(26, 23));
        editMacroButton.setPreferredSize(new java.awt.Dimension(26, 23));
        editMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMacroFile(evt);
            }
        });

        newMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add-icon-614x460.png"))); // NOI18N
        newMacroButton.setMaximumSize(new java.awt.Dimension(26, 23));
        newMacroButton.setMinimumSize(new java.awt.Dimension(26, 23));
        newMacroButton.setPreferredSize(new java.awt.Dimension(26, 23));
        newMacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMacroFile(evt);
            }
        });

        newDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add-icon-614x460.png"))); // NOI18N
        newDataButton.setMaximumSize(new java.awt.Dimension(26, 23));
        newDataButton.setMinimumSize(new java.awt.Dimension(26, 23));
        newDataButton.setPreferredSize(new java.awt.Dimension(26, 23));
        newDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDataFile(evt);
            }
        });

        resetPreviewButton.setText("Reset");

        previewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/leftarrow.png"))); // NOI18N
        previewButton.setMaximumSize(new java.awt.Dimension(50, 23));
        previewButton.setMinimumSize(new java.awt.Dimension(50, 23));
        previewButton.setPreferredSize(new java.awt.Dimension(50, 23));

        itemNumberLabel.setText("Item [0/0]:");

        itemPreviewField.setMaximumSize(new java.awt.Dimension(2147483647, 23));
        itemPreviewField.setMinimumSize(new java.awt.Dimension(6, 23));

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rightarrow.png"))); // NOI18N
        nextButton.setMaximumSize(new java.awt.Dimension(50, 23));
        nextButton.setMinimumSize(new java.awt.Dimension(50, 23));
        nextButton.setPreferredSize(new java.awt.Dimension(50, 23));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                        .addComponent(itemPreviewField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
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
                .addComponent(infoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(previewButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemPreviewField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(resetPreviewButton))
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
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
        genModel();
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
        genModel();
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

    private void getInfoDialog(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getInfoDialog
        launchInfo();
    }//GEN-LAST:event_getInfoDialog

    private void startMacro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMacro
        if (state == State.Loading) {
            setMacroState(State.Ready);
        } else {
            setMacroState(State.Loading);
        }
    }//GEN-LAST:event_startMacro

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
    
    public enum State {
        Loading,
        Ready,
        Running
    }
    
    private static final String VERSION = "v0.1.0";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private String data;
    private String macro;
    private Color background;
    private RecordModel model;
    private State state = State.Loading;
    private javax.swing.JButton dataButton;
    private javax.swing.JTextField dataField;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JButton editDataButton;
    private javax.swing.JButton editMacroButton;
    private javax.swing.JButton formatButton;
    private javax.swing.JTextField formatField;
    private javax.swing.JLabel formatLabel;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel itemNumberLabel;
    private javax.swing.JTextField itemPreviewField;
    private javax.swing.ButtonGroup modeGroup;
    private javax.swing.JButton newDataButton;
    private javax.swing.JButton newMacroButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previewButton;
    private javax.swing.JButton resetPreviewButton;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}