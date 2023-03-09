/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.controladorArticulos;
import Controladores.controladorHistorial;
import Controladores.funcionesAux;
import Controladores.llenarCombos;
import Modelos.Articulos;
import Modelos.Historial;
import Modelos.TipoArticulo;
import Modelos.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almatron
 */
public final class pnlArticulos extends javax.swing.JPanel {

    /**
     * Creates new form pnlUsuario
     */
    llenarCombos cmbCombos = new llenarCombos();
    funcionesAux funciones = new funcionesAux();
    controladorArticulos controladorArt = new controladorArticulos();
    controladorHistorial controladorHist = new controladorHistorial();
    Historial historial = new Historial();
    Articulos articulos = new Articulos();
    int contadorClick;
    ArrayList<Articulos> listaArticulos = new ArrayList<>();//lista para tener los articulos preparados para modificar
    // String [] condicionArticulo = {"Dañado","Regular","Bueno", "Muy Bueno", "Excelente"};
    DefaultTableModel tabla = new DefaultTableModel(); //utilizada para tomar los datos que serán modificados desde el jtable
    int filaSeleccionadaGlobal = -1;
    Usuario usuarioLogeado;

    public pnlArticulos() {
        initComponents();
        cmbCombos.cmbTipoArticulo(cmbTipoArticulo);
        cmbCombos.cmbCondicionArticulo(cmbCondicion);
        cmbCombos.cmbPersonaEncargada(cmbPersonaEncargada);
        cmbCondicion.setSelectedIndex(-1);
        cmbTipoArticulo.setSelectedIndex(-1);
        cmbPersonaEncargada.setSelectedIndex(-1);
        tablaArticulos(); //función para cargar los datos en la tabla
    }

    public pnlArticulos(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
        initComponents();
        cmbCombos.cmbTipoArticulo(cmbTipoArticulo);
        cmbCombos.cmbCondicionArticulo(cmbCondicion);
        cmbCombos.cmbPersonaEncargada(cmbPersonaEncargada);
        cmbCondicion.setSelectedIndex(-1);
        cmbTipoArticulo.setSelectedIndex(-1);
        cmbPersonaEncargada.setSelectedIndex(-1);
        tablaArticulos(); //función para cargar los datos en la tabla

    }

    public void tablaArticulos() {

        tabla = controladorArt.llenarTablaArticulos(controladorArt.listarArticulos());
        tbArticulos.setModel(tabla);
        // DefaultTableModel model = (DefaultTableModel) miTabla.getModel();
        //TableColumn column = tbArticulos.getColumnModel().getColumn(1);
        tbArticulos.removeColumn(tbArticulos.getColumn("idTipoArticulo"));
        tbArticulos.removeColumn(tbArticulos.getColumn("idEncargado"));
        tbArticulos.getTableHeader().setReorderingAllowed(false);
        tbArticulos.getColumnModel().getColumn(0).setPreferredWidth(5);
        //tbArticulos.getColumnModel().getColumn(5).setPreferredWidth(10);
        tbArticulos.getColumnModel().getColumn(5).setPreferredWidth(15);
        tbArticulos.getColumnModel().getColumn(7).setPreferredWidth(300);
        tbArticulos.setDefaultEditor(Object.class, null);

        tbArticulos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Detecta el doble clic
                    int filaSeleccionada = tbArticulos.getSelectedRow();
                    filaSeleccionadaGlobal = tbArticulos.getSelectedRow();// Obtiene la fila seleccionada

                    // Carga los datos de la fila seleccionada en sus componentes                   
                    cmbTipoArticulo.setSelectedIndex(buscarIndexTipoArticulo((String) tabla.getValueAt(filaSeleccionada, 2)));
                    txtMarca.setText((String) tabla.getValueAt(filaSeleccionada, 3));
                    txtModelo.setText((String) tabla.getValueAt(filaSeleccionada, 4));
                    txtSerie.setText((String) tabla.getValueAt(filaSeleccionada, 5));
                    cmbCondicion.setSelectedIndex(buscarIndexCondicion((String) tabla.getValueAt(filaSeleccionada, 6)));
                    cmbPersonaEncargada.setSelectedIndex(buscarIndexIdEncargado((String) tabla.getValueAt(filaSeleccionada, 8)));
                    txtAreaDescripcion.setText((String) tabla.getValueAt(filaSeleccionada, 9));
                    contadorClick= 2;
                }
            }
        });
    }

    public int buscarIndexTipoArticulo(String nombreBuscar) {
        int idEncontrado = -1; // Valor predeterminado si no se encuentra el elemento buscado
        for (int i = 0; i < cmbTipoArticulo.getItemCount(); i++) {
            TipoArticulo elemento = cmbTipoArticulo.getItemAt(i);
            if (elemento.getTipoArticulo().equals(nombreBuscar)) {
                idEncontrado = i;
                return idEncontrado;// Si se encuentra el elemento, se sale del bucle
            }
        }
        return idEncontrado;
    }

    public int buscarIndexIdEncargado(String nombreBuscar) {
        int idEncontrado = -1; // Valor predeterminado si no se encuentra el elemento buscado
        for (int i = 0; i < cmbPersonaEncargada.getItemCount(); i++) {
            Usuario elemento = cmbPersonaEncargada.getItemAt(i);
            if (elemento.getNombreDeUsuario().equals(nombreBuscar)) {
                idEncontrado = i;
                return idEncontrado;// Si se encuentra el elemento, se sale del bucle
            }
        }
        return idEncontrado;
    }

    public int buscarIndexCondicion(String nombreBuscar) {
        int idEncontrado = -1; // Valor predeterminado si no se encuentra el elemento buscado
        for (int i = 0; i < cmbCondicion.getItemCount(); i++) {
            System.out.println(cmbCondicion.getItemAt(i));
            if (cmbCondicion.getItemAt(i).equals(nombreBuscar)) {
                idEncontrado = i;
            }
        }
        return idEncontrado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatosArticulos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoArticulo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbPersonaEncargada = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDescripcion = new javax.swing.JTextArea();
        txtSerie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticulos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setAlignmentX(20.0F);

        pnlDatosArticulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de artículo:");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setText("Modelo:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setText("Condición:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel7.setText("Datos del artículo");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel8.setText("Persona encargada:");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel9.setText("Marca:");

        txtAreaDescripcion.setColumns(20);
        txtAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtAreaDescripcion);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel10.setText("Serie:");

        javax.swing.GroupLayout pnlDatosArticulosLayout = new javax.swing.GroupLayout(pnlDatosArticulos);
        pnlDatosArticulos.setLayout(pnlDatosArticulosLayout);
        pnlDatosArticulosLayout.setHorizontalGroup(
            pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                        .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosArticulosLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(20, 20, 20)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosArticulosLayout.createSequentialGroup()
                                .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosArticulosLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                                .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                                        .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cmbCondicion, javax.swing.GroupLayout.Alignment.LEADING, 0, 177, Short.MAX_VALUE)
                                            .addComponent(txtModelo)
                                            .addComponent(cmbPersonaEncargada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                                        .addComponent(cmbTipoArticulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27))
                            .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        pnlDatosArticulosLayout.setVerticalGroup(
            pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatosArticulosLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(19, 19, 19)
                .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbPersonaEncargada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnModificar.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadir.png"))); // NOI18N
        btnAgregar.setText("Añadir");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setMaximumSize(new java.awt.Dimension(87, 74));
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar)
                .addGap(7, 7, 7)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgregar, btnEliminar, btnLimpiar, btnModificar});

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel6.setText("GESTIÓN DE ARTÍCULOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tbArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbArticulos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(pnlDatosArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(412, 412, 412)
                                .addComponent(jLabel11)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDatosArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        funciones.limpiarFormulario(pnlDatosArticulos);
         filaSeleccionadaGlobal = -1;
    }//GEN-LAST:event_btnLimpiarActionPerformed


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        TipoArticulo elementoTipoArticulo = (TipoArticulo) cmbTipoArticulo.getSelectedItem(); //para seleccionar idtipoarticulo
        Usuario elementoUsuario = (Usuario) cmbPersonaEncargada.getSelectedItem(); //para seleccionar idusuario
        int respuesta = JOptionPane.showOptionDialog(
                null,
                "¿Está seguro(a) de querer añadir este artículo?",
                "Añadir articulo.",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                "Cancelar");
        if (respuesta == JOptionPane.YES_OPTION) {

            //VALIDACIONES
            if (elementoUsuario == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una persona encargada.");
                return;
            }

            if (elementoTipoArticulo == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de artículo.");
                return;
            }
            if (cmbCondicion.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una condición de artículo.");
                return;
            }
            if (usuarioLogeado.getIdUsuario() == 1) {
                System.out.println("Logeado");
            }
            //Seteado de articulos
            articulos.setIdTipoArticulo(elementoTipoArticulo.getIdTipoArticulo());
            articulos.setMarca(txtMarca.getText());
            articulos.setNumeroSerie(txtSerie.getText());
            articulos.setModelo(txtModelo.getText());
            articulos.setIdPersonaEncargada(elementoUsuario.getIdUsuario());
            articulos.setCondicionArticulo(cmbCondicion.getSelectedItem().toString());
            articulos.setDescripcion(txtAreaDescripcion.getText());
            controladorArt.insertarArticulo(articulos);
            //Seteado de historial
            historial.setIdItem(controladorArt.buscarUltimoID());
            historial.setIdUsuario(usuarioLogeado.getIdUsuario());
            historial.setOperacion("Insert");
            historial.setTabla("articulos");
            controladorHist.guardarHistorial(historial);
            //Mensaje de finalización
            JOptionPane.showMessageDialog(null, "Artículo añadido con éxito.");
            funciones.limpiarFormulario(pnlDatosArticulos);
            tablaArticulos();
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        //articulos.setIdArticulo(Integer.parseInt(tabla.getValueAt(filaSeleccionadaGlobal, 0).toString()));
        // int articuloid = articulos.getIdArticulo();
       // System.out.println(articulos.getIdArticulo());
        if (filaSeleccionadaGlobal==-1) {
            JOptionPane.showMessageDialog(null, "Por favor, haga doble click sobre el artículo para modificar.");
        } else {
            int respuesta = JOptionPane.showOptionDialog(
                    null,
                    "¿Está seguro(a) de querer modificar este artículo ("+tabla.getValueAt(filaSeleccionadaGlobal, 0)+") ?",
                    "Modificar articulo.",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "Cancelar");
            if (respuesta == JOptionPane.YES_OPTION) {
                TipoArticulo elementoTipoArticulo = (TipoArticulo) cmbTipoArticulo.getSelectedItem(); //para seleccionar idtipoarticulo
                Usuario elementoUsuario = (Usuario) cmbPersonaEncargada.getSelectedItem();

                articulos.setIdArticulo(Integer.parseInt(tabla.getValueAt(filaSeleccionadaGlobal, 0).toString()));
                articulos.setIdTipoArticulo(elementoTipoArticulo.getIdTipoArticulo());
                articulos.setMarca(txtMarca.getText());
                articulos.setNumeroSerie(txtSerie.getText());
                articulos.setModelo(txtModelo.getText());
                articulos.setIdPersonaEncargada(elementoUsuario.getIdUsuario());
                articulos.setCondicionArticulo(cmbCondicion.getSelectedItem().toString());
                articulos.setDescripcion(txtAreaDescripcion.getText());
                controladorArt.modificarArticulo(articulos);
                //Setear historial
                historial.setIdItem(articulos.getIdArticulo());
                historial.setIdUsuario(usuarioLogeado.getIdUsuario());
                historial.setOperacion("Update");
                historial.setTabla("articulos");
                controladorHist.guardarHistorial(historial);
                JOptionPane.showMessageDialog(null, "Artículo modificado con éxito.");
                tablaArticulos();
                funciones.limpiarFormulario(pnlDatosArticulos);
                filaSeleccionadaGlobal = -1;
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        //obtener el valor de la fila seleccionada
        if (tbArticulos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un artículo de la lista.");
        } else {
            int respuesta = JOptionPane.showOptionDialog(
                    null,
                    "¿Está seguro(a) de querer eliminar este artículo " + "(" + articulos.getIdArticulo() + ") ?",
                    "Eliminar articulo.",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "Cancelar");
            if (respuesta == JOptionPane.YES_OPTION) {
                articulos.setIdArticulo(Integer.parseInt(tabla.getValueAt(filaSeleccionadaGlobal, 0).toString()));
                historial.setIdItem(articulos.getIdArticulo());
                historial.setIdUsuario(usuarioLogeado.getIdUsuario());
                historial.setOperacion("Delete");
                historial.setTabla("articulos");
                controladorHist.guardarHistorial(historial);
                controladorArt.eliminarArticulo(articulos);
                JOptionPane.showMessageDialog(null, "Artículo eliminado con éxito.");
                tablaArticulos();
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<Usuario> cmbPersonaEncargada;
    private javax.swing.JComboBox<TipoArticulo> cmbTipoArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlDatosArticulos;
    private javax.swing.JTable tbArticulos;
    private javax.swing.JTextArea txtAreaDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
