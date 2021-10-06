/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.vista;

import javax.swing.JOptionPane;
import arbol.modelo.arbolBinario;
import arbol.modelo.nodoArbol;

public class inicioArbol extends javax.swing.JFrame {

    /**
     * Creates new form inicioArbol
     */
    public inicioArbol() {
        initComponents();
        setTitle("Arboles");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ingresoArbol = new javax.swing.JTextField();
        crearArbol = new javax.swing.JButton();
        recorridoPreorden = new javax.swing.JButton();
        recorridoInorden1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ingresoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoArbolActionPerformed(evt);
            }
        });

        crearArbol.setText("Crear");
        crearArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearArbolActionPerformed(evt);
            }
        });

        recorridoPreorden.setText("Recorrido PreOrden");
        recorridoPreorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recorridoPreordenActionPerformed(evt);
            }
        });

        recorridoInorden1.setText("Recorrido Inorden");
        recorridoInorden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recorridoInorden1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(crearArbol)
                    .addComponent(ingresoArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(recorridoPreorden, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(405, Short.MAX_VALUE)
                    .addComponent(recorridoInorden1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingresoArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recorridoPreorden, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(crearArbol)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(recorridoInorden1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(291, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresoArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoArbolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoArbolActionPerformed

    private void crearArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearArbolActionPerformed
        // TODO add your handling code here:
        String arbol = ingresoArbol.getText();
        arbolBinario arbolito = new arbolBinario();
        arbolito.crearArbolCadena(arbol);
        if(arbolito == null){
            JOptionPane.showMessageDialog(rootPane, "El árbol no ha sido creado");
            return;
        }else{
            JOptionPane.showMessageDialog(rootPane, "El árbol fue creado.");
        }
    }//GEN-LAST:event_crearArbolActionPerformed

    private void recorridoPreordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recorridoPreordenActionPerformed
        // TODO add your handling code here:
        String arbol = ingresoArbol.getText();
        arbolBinario arbolito = new arbolBinario();
        arbolito.crearArbolCadena(arbol);
        if(ingresoArbol == null){
            JOptionPane.showMessageDialog(rootPane, "Árbol vacío. No se puede recorrrer");
        }else{
            arbolito.preOrden(arbolito.getRaiz());
        }
    }//GEN-LAST:event_recorridoPreordenActionPerformed

    private void recorridoInorden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recorridoInorden1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recorridoInorden1ActionPerformed

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearArbol;
    private javax.swing.JTextField ingresoArbol;
    private javax.swing.JButton recorridoInorden1;
    private javax.swing.JButton recorridoPreorden;
    // End of variables declaration//GEN-END:variables
}
