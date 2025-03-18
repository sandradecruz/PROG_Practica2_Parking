/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package intento2Parking;
//
//import java.lang.Iterable;
//import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class ComprobarMatriculaPago extends javax.swing.JFrame {

    private static Maquina maquina;
    private static Ticket ticket;

    /**
     * Creates new form ComprobarMatriculaPago
     */
    public ComprobarMatriculaPago() { //Inicia los componentes
        initComponents();
        
        String matricula = "";
        int piso = 0;
        int plaza = 0;
        
        if (maquina == null) {
            maquina = new Maquina(0.5);
        }
        if (ticket == null) {
            ticket = new Ticket(matricula, piso, plaza);
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

        IntroducirID = new javax.swing.JTextField();
        AñadirMatriculaParaPago = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        IntroducirID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntroducirIDActionPerformed(evt);
            }
        });

        AñadirMatriculaParaPago.setText("Pago");
        AñadirMatriculaParaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirMatriculaParaPagoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Introduzca ID:");
        jLabel1.setMaximumSize(new java.awt.Dimension(175, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(175, 25));
        jLabel1.setPreferredSize(new java.awt.Dimension(175, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AñadirMatriculaParaPago)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IntroducirID, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(IntroducirID, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(AñadirMatriculaParaPago)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IntroducirIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntroducirIDActionPerformed

    }//GEN-LAST:event_IntroducirIDActionPerformed

    private void AñadirMatriculaParaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirMatriculaParaPagoActionPerformed
        try{
            int idIngresado = Integer.parseInt(IntroducirID.getText().trim());
            boolean encontrado = false;
            Ticket ticketEncontrado = null;
            ArrayList <Ticket> listaTickets = maquina.getTickets();
            
            for (int i = 0; i < listaTickets.size(); i++) {
                if(listaTickets.indexOf(i) == idIngresado){
                    encontrado = true;
                    ticketEncontrado = listaTickets.get(i);
                    break;
                }
                
            }

        if (encontrado) {
            JOptionPane.showMessageDialog(this, "Ticket encontrado:\nID: " + ticketEncontrado.getId() +
                                          "\nMatrícula: " + ticketEncontrado.getMatricula() +
                                          "\nPiso: " + ticketEncontrado.getPiso() +
                                          "\nPlaza: " + ticketEncontrado.getPlaza(),
                                          "Ticket Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un ticket con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido. Introduzca un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar el ID", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_AñadirMatriculaParaPagoActionPerformed

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
            java.util.logging.Logger.getLogger(ComprobarMatriculaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprobarMatriculaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprobarMatriculaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprobarMatriculaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprobarMatriculaPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirMatriculaParaPago;
    private javax.swing.JTextField IntroducirID;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
