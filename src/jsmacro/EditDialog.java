/**
 *
 * @author Ben Cochrane
 */
package jsmacro;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditDialog extends JFrame implements WindowListener {

    /**
     * Creates new form EditDialog
     */
    public EditDialog() {
        this("", false);
    }
    
    public EditDialog(String path) {
        this(path, false);
    }
    
    public EditDialog(String path, boolean reparse) {
        pathname = path;
        parseOnClose = reparse;
        cache = "";
        initComponents();
        initTextArea();
        addWindowListener(this);
        hasChanged = false;
        this.setTitle(pathname);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void initTextArea() {
        if (!pathname.equals("")) {
            try {
                MFLfile = new java.io.File(pathname);
                String s = "";
                java.util.Scanner sc = new java.util.Scanner(MFLfile);
                while (sc.hasNext()) {
                    s += sc.nextLine() + "\n";
                }
                editTextArea.setText(s);
                cache = s;
            } catch (FileNotFoundException ex) {
                saveFile();
            }
        } else {
            System.out.println("Pathname is empty!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        editTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        editTextArea.setColumns(20);
        editTextArea.setRows(5);
        editTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editTextAreaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editTextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(editTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveFile();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editTextAreaKeyPressed
        if (evt.isControlDown()) {
            if (evt.getKeyCode() == KeyEvent.VK_S) {
                saveFile();
            }
        }
        if (!cache.equals(editTextArea.getText())) {
            hasChanged = true;
            this.setTitle("*" + pathname);
        } else {
            hasChanged = false;
            this.setTitle(pathname);
        }
    }//GEN-LAST:event_editTextAreaKeyPressed

    private void editTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editTextAreaKeyTyped
        if (!cache.equals(editTextArea.getText())) {
            hasChanged = true;
            this.setTitle("*" + pathname);
        } else {
            hasChanged = false;
            this.setTitle(pathname);
        }
    }//GEN-LAST:event_editTextAreaKeyTyped
    
    private boolean saveFile() {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathname))) {
                writer.write(editTextArea.getText());
                cache = editTextArea.getText();
            }
            this.setTitle(pathname);
            hasChanged = false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        if (hasChanged) {
            if (JOptionPane.showConfirmDialog(this, "You have not yet saved!\nWould you like to now?",
                    "Warning!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                saveFile();
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }
    
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    
    private java.io.File MFLfile;
    private String pathname;
    private boolean parseOnClose;
    private boolean hasChanged;
    private String cache;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editPanel;
    private javax.swing.JTextArea editTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    
    
}
