/**
 *
 * @author Ben Cochrane
 */
package jmacro;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditDialog extends javax.swing.JFrame implements WindowListener {

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
        initComponents();
        initTextArea();
        addWindowListener(this);
        hasChanged = false;
        this.setTitle(pathname);
    }
    
    public void linkMacroData(MacroData md) {
        macroData = md;
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
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EditDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Pathname is empty!");
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
        editTextArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                editTextAreaPropertyChange(evt);
            }
        });
        editTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editTextAreaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editTextAreaKeyTyped(evt);
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

    private void editTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editTextAreaKeyTyped
        
    }//GEN-LAST:event_editTextAreaKeyTyped

    private void editTextAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_editTextAreaPropertyChange
        
    }//GEN-LAST:event_editTextAreaPropertyChange

    private void editTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editTextAreaKeyPressed
        hasChanged = true;
        this.setTitle("*" + pathname);
        if (evt.isControlDown()) {
            if (evt.getKeyCode() == KeyEvent.VK_S) {
                saveFile();
            }
        }
    }//GEN-LAST:event_editTextAreaKeyPressed
    
    private boolean saveFile() {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathname))) {
                writer.write(editTextArea.getText());
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
        if (parseOnClose) {
            macroData.parseData();
        }
    }
    
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    
    private java.io.File MFLfile;
    private String pathname;
    private MacroData macroData;
    private boolean parseOnClose;
    private boolean hasChanged;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editPanel;
    private javax.swing.JTextArea editTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    
    
}
