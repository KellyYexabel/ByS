package com.bys.gui;

import com.bys.gestor.GestorProducto;
import com.bys.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private GestorProducto gestorProducto;
    private VentanaPrincipal ventanaPrincipal;
    private int idProducto;

    public ButtonEditor(JCheckBox checkBox, VentanaPrincipal ventanaPrincipal, GestorProducto gestorProducto) {
        super(checkBox);
        this.ventanaPrincipal = ventanaPrincipal;
        this.gestorProducto = gestorProducto;

        button = new JButton("Ver Detalle");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = gestorProducto.buscarProductoPorId(idProducto);
                if (producto != null) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "DETALLE DEL PRODUCTO\n" +
                            "Nombre: " + producto.getNombre() + "\n" +
                            "Descripción: " + producto.getDescripcion() + "\n" +
                            "Precio: " + producto.getPrecio() + "\n" +
                            "Categoría: " + producto.getCategoria() + "\n" +
                            "Fecha creación: " + producto.getFechaCreacion());
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        idProducto = (int) table.getValueAt(row, 0); // Obtener ID del producto
        return button;
    }
}