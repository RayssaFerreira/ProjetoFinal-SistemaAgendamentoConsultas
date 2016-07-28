/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaGerenciadordeConsultas.apresentacao;

import br.com.SistemaGerenciadordeConsultas.entidade.Consulta;
import br.com.SistemaGerenciadordeConsultas.entidade.Medico;
import br.com.SistemaGerenciadordeConsultas.entidade.Paciente;
import br.com.SistemaGerenciadordeConsultas.excecao.CampoObrigatorioException;
import br.com.SistemaGerenciadordeConsultas.excecao.DataInvalidaException;
import br.com.SistemaGerenciadordeConsultas.excecao.GerenciadorConsultasException;
import br.com.SistemaGerenciadordeConsultas.negocio.ConsultaBO;
import br.com.SistemaGerenciadordeConsultas.negocio.ConverteData;
import br.com.SistemaGerenciadordeConsultas.negocio.MedicoBO;
import br.com.SistemaGerenciadordeConsultas.negocio.PacienteBO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rayssa
 */
public class NovaConsultaForm extends javax.swing.JFrame {

    /**
     * Creates new form NovaConsultaForm
     */
    private Consulta consulta;
    private boolean consultaEmEdicao;
    private ListagemConsultasForm listagemConsultasForm;
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    private List<Consulta> consultas;

    public NovaConsultaForm() throws SQLException {
        initComponents();
        carregarCmbMedico();
        carregarCmbPaciente();
    }

    NovaConsultaForm(Consulta consultaSelecionada, ListagemConsultasForm listagemConsultasForm) {
        consultaEmEdicao = true;
        consulta = consultaSelecionada;
        this.listagemConsultasForm = listagemConsultasForm;
        initComponents();
        try {
            carregarCmbMedico();
            carregarCmbPaciente();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        inicializarCamposTela();
    }

    private void inicializarCamposTela() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.txtData.setText(formatador.format(this.consulta.getData()));
        this.txtObservacao.setText(this.consulta.getObservacao());

        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            if (medico.getNome().equals(medico.getId())) {
                this.cmbMedico.setSelectedIndex(i + 1);
                break;
            }
        }
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            if (paciente.getNome().equals(paciente.getId())) {
                this.cmbPaciente.setSelectedIndex(i + 1);
                break;
            }
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

        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        lblObservacao = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        cmbPaciente = new javax.swing.JComboBox();
        cmbMedico = new javax.swing.JComboBox();
        lblMedico = new javax.swing.JLabel();
        txtHorario = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        lblHorario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        imagemAgenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGENDAR CONSULTAS");
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendamento de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/SistemaGerenciadordeConsultas/apresentacao/icones/save-file.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/SistemaGerenciadordeConsultas/apresentacao/icones/1469138248_ic_assignment_return_48px.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        lblObservacao.setText("Observação:");

        lblPaciente.setText("Paciente:");

        cmbPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicoActionPerformed(evt);
            }
        });

        lblMedico.setText("Médico:");

        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        lblHorario.setText("Horário:");

        lblData.setText("Data:");

        imagemAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/SistemaGerenciadordeConsultas/apresentacao/icones/436.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHorario)
                                    .addComponent(lblData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData)
                                    .addComponent(txtHorario)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblObservacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblPaciente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagemAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblData)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHorario)
                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMedico))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaciente))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblObservacao))))
                    .addComponent(imagemAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(997, 494));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    public void validaCampos() throws CampoObrigatorioException {
        String data = txtData.getText().trim();
        String horario = txtHorario.getText().trim();
        String observacao = txtObservacao.getText().trim();

        if (data.isEmpty() || horario.isEmpty() || observacao.isEmpty()) {
            throw new CampoObrigatorioException();
        }
    }
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (consultaEmEdicao == false) {
            salvarConsulta();
        } else {
            editarConsulta();
        }

    }//GEN-LAST:event_btnSalvarActionPerformed
    private void salvarConsulta() {
        try {
            validaCampos();
            String data = txtData.getText().trim();
            String horario = txtHorario.getText().trim();
            String observacao = txtObservacao.getText().trim();
            Consulta consulta = new Consulta();
            consulta.setMedico((Medico) cmbMedico.getSelectedItem());
            consulta.setPaciente((Paciente) cmbPaciente.getSelectedItem());
            consulta.setObservacao(observacao);
            try {
                consulta.setData(ConverteData.StringForDate(data));
                consulta.setHorario(ConverteData.StringForTime(horario));
                ConsultaBO consultaBO = new ConsultaBO();
                consultaBO.salvar(consulta);
                JOptionPane.showMessageDialog(this,
                        "Consulta agendada com sucesso!",
                        "Agendamento de Consultas",
                        JOptionPane.INFORMATION_MESSAGE);
                this.limparCamposTela();
                carregarCmbMedico();
                carregarCmbPaciente();
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Data ou Horário Inválida!", "Agendamento de Consultas!",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (SQLException ex) {
                Logger.getLogger(NovaConsultaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (GerenciadorConsultasException e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Agendamento de Consultas",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void editarConsulta() {
        try {
            this.validaCampos();

            String data = txtData.getText().trim();
            String horario = txtHorario.getText().trim();
            String observacao = txtObservacao.getText().trim();
            consulta.setMedico((Medico) cmbMedico.getSelectedItem());
            consulta.setPaciente((Paciente) cmbPaciente.getSelectedItem());
            consulta.setObservacao(observacao);
            try {
                consulta.setData(ConverteData.StringForDate(data));
                consulta.setHorario(ConverteData.StringForTime(horario));
                ConsultaBO consultaBO = new ConsultaBO();
                consultaBO.editar(consulta);
                JOptionPane.showMessageDialog(this,
                        "Consulta alterada com sucesso!",
                        "Alteração de Consultas",
                        JOptionPane.INFORMATION_MESSAGE);
                this.limparCamposTela();
                carregarCmbMedico();
                carregarCmbPaciente();
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Data ou Horário Inválida!", "Alteração de Consultas!",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (SQLException ex) {
                Logger.getLogger(NovaConsultaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (GerenciadorConsultasException e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Alteração de Consultas",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void limparCamposTela() {
        txtData.setText("");
        txtHorario.setText("");
        txtObservacao.setText("");
    }
    private void cmbMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedicoActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbMedico;
    private javax.swing.JComboBox cmbPaciente;
    private javax.swing.JLabel imagemAgenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables

    private void carregarCmbMedico() throws SQLException {
        MedicoBO medicoBO = new MedicoBO();
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmbMedico.getModel();
        model.removeAllElements();
        cmbMedico.addItem("Selecione");
        for (Medico medico : medicoBO.buscarTodos()) {
            model.addElement(medico);
        }
    }

    private void carregarCmbPaciente() throws SQLException {
        PacienteBO pacienteBO = new PacienteBO();
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmbPaciente.getModel();
        model.removeAllElements();
        cmbPaciente.addItem("Selecione");
        for (Paciente paciente : pacienteBO.buscarTodos()) {
            model.addElement(paciente);
        }
    }
}
