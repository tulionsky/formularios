package umg.progra2.formas.productos;

import umg.progra2.DataBase.Model.Producto;
import umg.progra2.DataBase.Services.ProductoService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmProductos {
    private JPanel jPanelPrincipal;
    private JLabel lblTitulo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmProductos");
        frame.setContentPane(new frmProductos().jPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel lblId;
    private JTextField textFieldIdProducto;
    private JLabel lblNombre;
    private JTextField textFieldProducto;
    private JLabel lblOrigen;
    private JComboBox comboBoxOrigen;
    private JButton buttonGrabar;
    private JButton buttonBuscar;

    public frmProductos() {
        comboBoxOrigen.addItem("China");
        comboBoxOrigen.addItem("Japon");
        comboBoxOrigen.addItem("Corea");

        buttonGrabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = new Producto();
                producto.setDescripcion(textFieldProducto.getText());
                producto.setOrigen(comboBoxOrigen.getSelectedItem().toString());

                try{
                    new ProductoService().crearProducto(producto);
                    JOptionPane.showMessageDialog(null, "Producto creado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error al guardar producto"+ ex.getMessage());
                }

            }
        });
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idProducto = textFieldIdProducto.getText().isEmpty() ? 0 : Integer.parseInt(textFieldIdProducto.getText());
                try{
                    Producto productoEncontrado = new ProductoService().obtenerProducto(idProducto);
                    if (productoEncontrado != null) {
                        textFieldIdProducto.setText(productoEncontrado.getDescripcion());
                        comboBoxOrigen.setSelectedItem(productoEncontrado.getOrigen());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el producto");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al obtener el producto"+ ex.getMessage());
                }
            }
        });
    }
}
