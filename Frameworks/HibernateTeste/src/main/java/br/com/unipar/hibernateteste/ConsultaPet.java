package br.com.unipar.hibernateteste;

import br.com.unipar.hibernateteste.model.dao.PetDAO;
import br.com.unipar.hibernateteste.model.usuario.Pet;
import br.com.unipar.hibernateteste.tableModel.PetTableModel;
import java.util.List;

public class ConsultaPet extends javax.swing.JDialog {

    private Pet petSelecionado;
    private PetTableModel model;
    private List<Pet> listaPets;

    public Pet getPetSelecionado() {
        return petSelecionado;
    }

    public void setPetSelecionado(Pet petSelecionado) {
        this.petSelecionado = petSelecionado;
    }

    public ConsultaPet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaLista();
    }

    private void atualizaLista() {
        PetDAO dao = new PetDAO();
        listaPets = dao.findAll();
        model = new PetTableModel(listaPets);
        jTablePets.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePets = new javax.swing.JTable();
        jButtonSelecionarPet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTablePets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablePets);

        jButtonSelecionarPet.setText("Selecionar");
        jButtonSelecionarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarPetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonSelecionarPet, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSelecionarPet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarPetActionPerformed
        setPetSelecionado(model.getSelectedPet(jTablePets, listaPets));

        this.dispose();
    }//GEN-LAST:event_jButtonSelecionarPetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaPet dialog = new ConsultaPet(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSelecionarPet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePets;
    // End of variables declaration//GEN-END:variables
}
