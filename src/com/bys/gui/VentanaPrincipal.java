package com.bys.gui;

import com.bys.gestor.GestorProducto;
import com.bys.model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
    private GestorProducto gestorProducto;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    public VentanaPrincipal(GestorProducto gestorProducto) {
        this.gestorProducto = gestorProducto;

        setTitle("Catálogo de Productos - Botica");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem agregarProducto = new JMenuItem("Agregar Producto");
        agregarProducto.addActionListener(this::abrirVentanaAgregarProducto);
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        menu.add(agregarProducto);
        menu.add(salir);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Crear tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Precio", "Acción"}, 0);
        tablaProductos = new JTable(modeloTabla) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Solo la columna de botones es editable
            }
        };

        // Agregar botón en la tabla
        tablaProductos.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        tablaProductos.getColumn("Acción").setCellEditor(new ButtonEditor(new JCheckBox(), this, gestorProducto));

        cargarProductosEnTabla();

        add(new JScrollPane(tablaProductos), BorderLayout.CENTER);
    }

    private void cargarProductosEnTabla() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        for (Producto producto : gestorProducto.listarProductos()) {
            modeloTabla.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getPrecio(), "Ver Detalle"});
        }
    }

    private void abrirVentanaAgregarProducto(ActionEvent e) {
        new VentanaAgregarProducto(this, gestorProducto).setVisible(true);
    }

    public void actualizarTabla() {
        cargarProductosEnTabla();
    }
}