package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import modelo.Conexion;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class Produccion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JTable table;
	PreparedStatement ps;
	ResultSet rs;
	private JTextField busqueda;
	Connection con;
	Conexion cn = new Conexion();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Produccion dialog = new Produccion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Produccion() {
		setTitle("Produccion");
		setBounds(100, 100, 681, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(222, 236, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(121, 236, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(12, 13, 56, 16);
		contentPanel.add(lblCodigo);
		
		id = new JTextField();
		id.setBounds(135, 10, 116, 22);
		contentPanel.add(id);
		id.setColumns(10);
		
		JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
		lblFechaInicial.setBounds(12, 50, 76, 16);
		contentPanel.add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		lblFechaFinal.setBounds(12, 95, 76, 16);
		contentPanel.add(lblFechaFinal);
		
		JDateChooser fecha2 = new JDateChooser();
		fecha2.setDateFormatString("yyy/MM/d");
		fecha2.setBounds(135, 89, 116, 22);
		contentPanel.add(fecha2);
		
		JDateChooser fecha1 = new JDateChooser();
		fecha1.setDateFormatString("yyy/MM/d");
		fecha1.setBounds(135, 50, 116, 22);
		contentPanel.add(fecha1);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(12, 130, 56, 16);
		contentPanel.add(lblProducto);
		
		JComboBox prod = new JComboBox();
		prod.setModel(new DefaultComboBoxModel(new String[] {"Aveo", "Chevy", "Focus", "Fiesta", "Tsuru"}));
		prod.setBounds(135, 130, 116, 22);
		contentPanel.add(prod);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(12, 179, 56, 16);
		contentPanel.add(lblCantidad);
		
		JSpinner cant = new JSpinner();
		cant.setBounds(162, 176, 89, 22);
		contentPanel.add(cant);
		
		JButton btnConsulat = new JButton("Consultar");
		btnConsulat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String campo = busqueda.getText();
				String where = "";
				if(!"".equals(campo)) {
					where = "WHERE id_prod = '" + campo +"'";
				}
        		try {
        			DefaultTableModel modelo1 = new DefaultTableModel();
        			con = cn.conectar();      
        	        String sql = "SELECT id_prod, fecini_prod, fecter_prod, mod_prod, num_prod FROM eproduccion " + where;
        	        ps = con.prepareStatement(sql);
        	        rs = ps.executeQuery();
        	        table.setModel(modelo1);
        	        ResultSetMetaData rsMD = rs.getMetaData();
        	        int cantidadColumnas = rsMD.getColumnCount();
        	        modelo1.addColumn("Codigo");
        	        modelo1.addColumn("Fecha Inicio");
        	        modelo1.addColumn("Fecha Final");
        	        modelo1.addColumn("Modelo");
        	        modelo1.addColumn("Cantidad");
        	        
        	        while(rs.next()) {
        	        	Object[]  filas = new Object[cantidadColumnas];
        	        	
        	        	for (int i = 0; i < cantidadColumnas; i++) {
        					filas[i] = rs.getObject(i + 1 );
        				}
        	        	modelo1.addRow(filas);
        	        }
        	        		
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "Error");
        		}
			}
		});
		btnConsulat.setBounds(12, 235, 97, 25);
		contentPanel.add(btnConsulat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 11, 324, 248);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fecha Inicial", "Fecha Final", "Modelo", "Cantidad"
			}
		));
		scrollPane.setViewportView(table);
		
		busqueda = new JTextField();
		busqueda.setBounds(12, 287, 86, 20);
		contentPanel.add(busqueda);
		busqueda.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();
		            ps = con.prepareStatement("INSERT INTO eproduccion (id_prod, fecini_prod, fecter_prod, mod_prod, num_prod) VALUES(?,?,?,?,?) ");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(fecha1.getDate());
					String date1 = sdf.format(fecha2.getDate());
					ps.setString(1, id.getText());
					ps.setString(2, date);
					ps.setString(3,date1);
		            ps.setString(4, prod.getSelectedItem().toString());
		            ps.setString(5, cant.getValue().toString());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[5];
		            fila[0] = id.getText();
		            fila[1] = fecha1.getDate();
		            fila[2] = fecha2.getDate();
		            fila[3] = prod.getSelectedItem();
		            fila[4] = cant.getValue();
		            modelo1.addRow(fila);
		            if(res > 0){
		                JOptionPane.showMessageDialog(null, "Guardado");
		            } else {
		                 JOptionPane.showMessageDialog(null,"Error al Guardar Producto");
		            }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(162, 286, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();
		            ps = con.prepareStatement("UPDATE eproduccion SET id_prod=?, fecini_prod=?, fecter_prod=?, mod_prod=?, num_prod=? WHERE id_prod=? ");
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(fecha1.getDate());
					String date1 = sdf.format(fecha2.getDate());
					ps.setString(1, id.getText());
					ps.setString(2, date);
					ps.setString(3,date1);
		            ps.setString(4, prod.getSelectedItem().toString());
		            ps.setString(5, cant.getValue().toString());
		            ps.setString(6, busqueda.getText());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[5];
		            fila[0] = id.getText();
		            fila[1] = fecha1.getDate();
		            fila[2] = fecha2.getDate();
		            fila[3] = prod.getSelectedItem();
		            fila[4] = cant.getValue();
		            modelo1.addRow(fila);
		            if(res > 0){
		                JOptionPane.showMessageDialog(null, "Modificado");
		            } else {
		                 JOptionPane.showMessageDialog(null,"Error al Modificar Producto");
		            }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		modificar.setBounds(273, 286, 89, 23);
		contentPanel.add(modificar);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();
		            int Fila = table.getSelectedRow();
		            String codigo = table.getValueAt(Fila,0).toString();
					ps = con.prepareStatement("DELETE FROM eproduccion  WHERE id_prod=? ");
		            ps.setString(1,codigo);
		            int res = ps.executeUpdate();
		            modelo1.removeRow(Fila);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		eliminar.setBounds(162, 322, 89, 23);
		contentPanel.add(eliminar);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
	             fecha1.setDate(null);
	             fecha2.setDate(null);
	             prod.setSelectedItem(null);
	             cant.setValue(0);
	            
			}
		});
		btnNewButton_3.setBounds(20, 318, 89, 23);
		contentPanel.add(btnNewButton_3);
		
	}
}
