package br.com.unipar.hibernateteste;

import br.com.unipar.hibernateteste.model.dao.CidadeDAO;
import br.com.unipar.hibernateteste.model.dao.ClienteDAO;
import br.com.unipar.hibernateteste.model.dao.EnderecoDAO;
import br.com.unipar.hibernateteste.model.dao.EstadoDAO;
import br.com.unipar.hibernateteste.model.usuario.Cidade;
import br.com.unipar.hibernateteste.model.usuario.Cliente;
import br.com.unipar.hibernateteste.model.usuario.Endereco;
import br.com.unipar.hibernateteste.model.usuario.Estado;
import br.com.unipar.hibernateteste.model.util.PetDoguiLog;
import br.com.unipar.hibernateteste.tableModel.ClienteTableModel;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientePetDogui extends javax.swing.JFrame {

    private Cliente cliente = new Cliente();
    private Endereco endereco = new Endereco();
    private ClienteDAO daoCliente = new ClienteDAO();
    private EnderecoDAO daoEndereco = new EnderecoDAO();
    
    public ClientePetDogui() {
        initComponents();
        atualizaEstado();
        atualizaLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelCadastroPet = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        emailCliente = new javax.swing.JTextField();
        cpfCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bairroText = new javax.swing.JTextField();
        cepText = new javax.swing.JTextField();
        numeroText = new javax.swing.JTextField();
        logradouroText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cidadeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        codeCliente = new javax.swing.JTextField();
        JPanelListaCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1, 3, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Cliente");

        cpfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("E-mail:");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        logradouroText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logradouroTextActionPerformed(evt);
            }
        });

        jLabel5.setText("Bairro:");

        jLabel6.setText("CEP:");

        jLabel7.setText("Numero:");

        jLabel8.setText("Logradouro");

        estadoComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estadoComboBoxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estadoComboBoxMousePressed(evt);
            }
        });
        estadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado");

        jLabel10.setText("Cidade:");

        jButton2.setText("Desativar Cliente");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        codeCliente.setEditable(false);
        codeCliente.setEnabled(false);

        javax.swing.GroupLayout JPanelCadastroPetLayout = new javax.swing.GroupLayout(JPanelCadastroPet);
        JPanelCadastroPet.setLayout(JPanelCadastroPetLayout);
        JPanelCadastroPetLayout.setHorizontalGroup(
            JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelCadastroPetLayout.createSequentialGroup()
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelCadastroPetLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCadastroPetLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelCadastroPetLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(98, 98, 98))
                            .addComponent(cpfCliente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCadastroPetLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCadastroPetLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(emailCliente)
                                .addGroup(JPanelCadastroPetLayout.createSequentialGroup()
                                    .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bairroText, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cepText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(numeroText, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                                .addComponent(logradouroText)
                                .addComponent(jLabel8)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCadastroPetLayout.createSequentialGroup()
                                    .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(codeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(cidadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        JPanelCadastroPetLayout.setVerticalGroup(
            JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelCadastroPetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logradouroText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(codeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(JPanelCadastroPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(20, 20, 20))
        );

        getContentPane().add(JPanelCadastroPet);

        JPanelListaCliente.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        JPanelListaCliente.add(jScrollPane1);

        getContentPane().add(JPanelListaCliente);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cliente.setAtivo(true);
        cliente.setCpf(cpfCliente.getText());
        cliente.setNome(nomeCliente.getText());
        cliente.setEmail(emailCliente.getText());
        gravaCliente();
        endereco.setBairro(bairroText.getText());
        endereco.setCep(cepText.getText());
        endereco.setCliente(cliente);
        endereco.setLogradouro(logradouroText.getText());
        endereco.setNumero(numeroText.getText());
        gravaEndereco();
        atualizaLista();
        PetDoguiLog.infoGeral("CLIENTE SALVO COM SUCESSO");
        limpaTela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logradouroTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logradouroTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logradouroTextActionPerformed

    private void estadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoComboBoxActionPerformed
        atualizaCidade();
    }//GEN-LAST:event_estadoComboBoxActionPerformed

    private void estadoComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoComboBoxMouseClicked
        
    }//GEN-LAST:event_estadoComboBoxMouseClicked

    private void estadoComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoComboBoxMousePressed
        
    }//GEN-LAST:event_estadoComboBoxMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cliente.setAtivo(false);
        cliente.setCpf(cpfCliente.getText());
        cliente.setNome(nomeCliente.getText());
        cliente.setEmail(emailCliente.getText());
        cliente.setId_cliente(Long.parseLong(codeCliente.getText()));
        atualizaCliente();
        atualizaLista();
        PetDoguiLog.infoGeral("CLIENTE DESATIVADO COM SUCESSO");
        limpaTela();
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Cliente cliente = new Cliente();
        int linha = jTable1.getSelectedRow();
        Long idCliente = Long.parseLong(jTable1.getValueAt(linha, 0).toString());
        
        cliente = daoCliente.findById(idCliente);
        
        cpfCliente.setText(cliente.getCpf());
        emailCliente.setText(cliente.getEmail());
        nomeCliente.setText(cliente.getNome());
        codeCliente.setText(String.valueOf(cliente.getId_cliente()));
        
        bairroText.setText(cliente.getEnderecos().get(0).getBairro());
        cepText.setText(cliente.getEnderecos().get(0).getCep());
        logradouroText.setText(cliente.getEnderecos().get(0).getLogradouro());
        numeroText.setText(cliente.getEnderecos().get(0).getNumero());
        
        jButton2.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

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
            java.util.logging.Logger.getLogger(ClientePetDogui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientePetDogui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientePetDogui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientePetDogui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientePetDogui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelCadastroPet;
    private javax.swing.JPanel JPanelListaCliente;
    private javax.swing.JTextField bairroText;
    private javax.swing.JTextField cepText;
    private javax.swing.JComboBox<String> cidadeComboBox;
    private javax.swing.JTextField codeCliente;
    private javax.swing.JTextField cpfCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField logradouroText;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField numeroText;
    // End of variables declaration//GEN-END:variables

    private void gravaCliente() {
        validaCliente();
        daoCliente = new ClienteDAO();
        daoCliente.save(cliente);
    }
    
    private void atualizaCliente(){
        validaCliente();
        daoCliente = new ClienteDAO();
        daoCliente.update(cliente);
    }

    private void validaCliente() {
        if (cliente.getCpf().isEmpty() || cliente.getCpf() == null){
            JOptionPane.showMessageDialog(null, "É necessário informar o CPF");
        }
        
        if (cliente.getEmail().isEmpty() || cliente.getEmail() == null){
            JOptionPane.showMessageDialog(null, "É necessário informar o Email");
        }
        
        if (cliente.getNome().isEmpty() || cliente.getNome() == null){
            JOptionPane.showMessageDialog(null, "É necessário informar o Nome");
        }
    }
    
    private void atualizaEstado(){
        EstadoDAO daoEstado = new EstadoDAO();
        List<Estado> listaEstado = daoEstado.findAll();
        for (Estado estado : listaEstado){
            estadoComboBox.addItem(estado.getNome());
        }
    }

    private void atualizaCidade() {
        CidadeDAO daoCidade = new CidadeDAO();
        List<Cidade> listaCidade = daoCidade.findAll();
        for (Cidade cidade : listaCidade){
            cidadeComboBox.addItem(cidade.getNome());
        }
    }

    private void gravaEndereco() {
        daoEndereco = new EnderecoDAO();
        daoEndereco.save(endereco);
    }
    
    public void atualizaLista() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> listaClientes = dao.findAll();
        ClienteTableModel model = new ClienteTableModel(listaClientes);
        jTable1.setModel(model);
    }
    
    public void limpaTela(){
        bairroText.setText(null);
        cepText.setText(null);
        cpfCliente.setText(null);
        emailCliente.setText(null);
        logradouroText.setText(null);
        nomeCliente.setText(null);
        numeroText.setText(null);
    }
    
}
