/*
 * Copyright (C) 2017 Alberto Bausá Cano
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package app.view_controller.datospaciente;

import app.common.Utils;
import app.common.enums.PatientSexEnum;
import app.model.datospaciente.ResumenPacienteModel;
import app.view_controller.menuprincipal.MenuTriajeVC;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import library.JIASimpleDialog;

/**
 *
 * @author Alberto Bausá Cano
 */
public class FilaPacienteTriajeVC extends library.JIASimpleDialog {
    
    private final ResumenPacienteModel model;

    /**
     * Creates new form FilaPaciente
     * 
     * @param resumenPacienteModel Modelo para el diálogo
     */
    public FilaPacienteTriajeVC(ResumenPacienteModel resumenPacienteModel) {
        model = resumenPacienteModel;
        initComponents();
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbSexImage = new javax.swing.JLabel();
        btnBill = new javax.swing.JButton();
        btnEditData = new javax.swing.JButton();
        lbCompleteName = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(650, 70));
        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(lbSexImage, gridBagConstraints);

        btnBill.setBackground(new java.awt.Color(255, 255, 204));
        btnBill.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonMoneda.png"))); // NOI18N
        btnBill.setText(" Consultar factura");
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBill(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(btnBill, gridBagConstraints);

        btnEditData.setBackground(new java.awt.Color(204, 204, 255));
        btnEditData.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEditData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonEditar.png"))); // NOI18N
        btnEditData.setText("Modificar datos");
        btnEditData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyData(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(btnEditData, gridBagConstraints);

        lbCompleteName.setText("Nombre completo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(lbCompleteName, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void openBill(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBill
        ((MenuTriajeVC) ((JButton) evt.getSource()).getParent().getParent()).getTopLevelAncestor().setVisible(false);
        
        DatosGeneralesVC datosPacienteVC = (DatosGeneralesVC) Utils.initDialog(new DatosGeneralesVC(model.getDatosGenerales()));
        DatosBancariosVC datosBancariosVC = (DatosBancariosVC) Utils.initDialog(new DatosBancariosVC(model.getDatosBancarios()));
        
        JIASimpleDialog factura = (JIASimpleDialog) Utils.generateDialog(Type.SIMPLE, "factura", "FACTURA MÉDICA");
        factura.addExtensibleChildrenList(Arrays.asList(datosPacienteVC, datosBancariosVC), "");
        Utils.centrarVentana(factura);
        
        ((JFrame) factura.getTopLevelAncestor()).addWindowListener(new WindowAdapter() {
            @Override public void windowClosed(WindowEvent e) {
                ((MenuTriajeVC) ((JButton) evt.getSource()).getParent().getParent()).getTopLevelAncestor().revalidate();
                ((MenuTriajeVC) ((JButton) evt.getSource()).getParent().getParent()).getTopLevelAncestor().setVisible(true);
            } });
    }//GEN-LAST:event_openBill

    private void modifyData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyData
        ((MenuTriajeVC) ((JButton) evt.getSource()).getParent().getParent()).getTopLevelAncestor().setVisible(false);
        
        ResumenPacienteVC resumenPacienteVC = (ResumenPacienteVC) Utils.initDialog(new ResumenPacienteVC(model));
        DatosGeneralesVC datosGeneralesVC = (DatosGeneralesVC) Utils.initDialog(new DatosGeneralesVC(model.getDatosGenerales()));
        datosGeneralesVC.setCaption("General");
        DatosPersonalesVC datosPersonalesVC = (DatosPersonalesVC) Utils.initDialog(new DatosPersonalesVC(model.getDatosPersonales()));
        datosPersonalesVC.setCaption("Personal");
        DatosClinicosVC datosClinicosVC = (DatosClinicosVC) Utils.initDialog(new DatosClinicosVC(model.getDatosClinicos()));
        datosClinicosVC.setCaption("Clínica");
        DatosBancariosVC datosBancariosVC = (DatosBancariosVC) Utils.initDialog(new DatosBancariosVC(model.getDatosBancarios()));
        datosBancariosVC.setCaption("Bancaria");
        
        JIASimpleDialog resumen = (JIASimpleDialog) Utils.generateDialog(Type.SIMPLE, "resumen", "RESUMEN PACIENTE");
        resumenPacienteVC.addExtensibleChildrenList(Arrays.asList(datosGeneralesVC, datosPersonalesVC, datosClinicosVC, datosBancariosVC), "Edición de datos");
        resumen.addExtensibleChild(resumenPacienteVC, "");
        Utils.centrarVentana(resumen);

        ((JFrame) resumen.getTopLevelAncestor()).addWindowListener(new WindowAdapter() {
            @Override public void windowClosed(WindowEvent e) {
                ((MenuTriajeVC) ((JButton) evt.getSource()).getParent().getParent()).getTopLevelAncestor().setVisible(true);
            } });
    }//GEN-LAST:event_modifyData

    @Override
    public boolean validateThis() { return true; } // nada que validar

    @Override
    public void saveThis() { } // nada que guardar

    @Override
    public void cleanThis() { }

    @Override
    public void getExternVal(String id, Object value) { }

    private void initData() {
        lbSexImage.setIcon(new ImageIcon(getSexImagePath(model.getDatosPersonales().getPatientSex())));
        lbCompleteName.setText(getCompleteName());
        lbCompleteName.setToolTipText(getCompleteName());
    }
    
    public String getCompleteName() {
        return (model != null && model.getDatosGenerales() != null) ?
                model.getDatosGenerales().getName() + ", " + model.getDatosGenerales().getSurname() : "";
    }
    
    private String getSexImagePath(PatientSexEnum patientSex) {
        File aux = new File("");
        String path = "";
        try { path = aux.getCanonicalPath() + "/src/images"; } catch (IOException ioe) { }
        
        if(!path.trim().isEmpty()) {
            switch(patientSex) {
                case Hombre:
                    path += "/hombre.png";
                    break;
                case Mujer:
                    path += "/mujer.png";
                    break;
                default:
                    path += "/desconocido.png"; }
        }
        
        return path;
    }

    public ResumenPacienteModel getModel() {
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnEditData;
    private javax.swing.JLabel lbCompleteName;
    private javax.swing.JLabel lbSexImage;
    // End of variables declaration//GEN-END:variables
}
