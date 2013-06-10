package jsmacro;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ben Cochrane
 */
public class Console extends JFrame implements WindowListener {

    private static ArrayList<String> messages = new ArrayList<>();
    private static Console console = null;
    
    public static void Log(String message) {
        messages.add(message);
        if (console != null) {
            console.updateUI();
        }
        start();
    }
    
    public static void start() {
        if (console == null) {
            console = new Console();
        }
    }
    
    public static void stop() {
        console = null;
    }
    
    /**
     * Creates new form Console
     */
    private Console() {
        initComponents();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        this.addWindowListener(this);
        this.setTitle("JsMacro - Console");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateUI();
    }
    
    public void clearLog() {
        System.out.println("Clearing messages.");
        Console.messages.clear();
        System.out.println(Console.messages);
        updateUI();
    }
    
    private void updateUI() {
        pane.removeAll();
        for (String msg : messages) {
            pane.add(new JLabel(msg));
        }
        pane.revalidate();
        pane.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pane = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout paneLayout = new javax.swing.GroupLayout(pane);
        pane.setLayout(paneLayout);
        paneLayout.setHorizontalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        paneLayout.setVerticalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pane);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLog(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clearButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearLog(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLog
        clearLog();
    }//GEN-LAST:event_clearLog
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pane;
    // End of variables declaration//GEN-END:variables

    @Override public void windowOpened(WindowEvent we) {}
    @Override public void windowIconified(WindowEvent we) {}
    @Override public void windowDeiconified(WindowEvent we) {}
    @Override public void windowActivated(WindowEvent we) {}
    @Override public void windowDeactivated(WindowEvent we) {}
    @Override public void windowClosing(WindowEvent we) {}
    @Override public void windowClosed(WindowEvent we) { 
        System.out.println("Closed");
        Console.stop();
    }
}
