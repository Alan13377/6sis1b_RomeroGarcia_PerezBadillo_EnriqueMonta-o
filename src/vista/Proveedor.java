package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Conexion;

public class Proveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tel;
	private JTextField email;
	private JTextField id;
	private JTextField nombre;
	private JTextField ubi;
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
			Proveedor dialog = new Proveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Proveedor() {
		setTitle("Proveedores");
		setBounds(100, 100, 511, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(390, 204, 78, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(btnNewButton);
		
		tel = new JTextField();
		tel.setBounds(180, 157, 100, 20);
		contentPanel.add(tel);
		tel.setColumns(10);
		
		email = new JTextField();
		email.setBounds(180, 189, 141, 20);
		contentPanel.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Proveedor:");
		lblNewLabel.setBounds(12, 78, 114, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono:");
		lblNewLabel_1.setBounds(12, 157, 72, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("e-mail:");
		lblNewLabel_2.setBounds(12, 192, 59, 14);
		contentPanel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(390, 238, 78, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPanel.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("Codigo Proveedor:");
		lblId.setBounds(12, 33, 114, 16);
		contentPanel.add(lblId);
		
		id = new JTextField();
		id.setBounds(180, 30, 86, 22);
		contentPanel.add(id);
		id.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Ubicacion");
		lblApellidoPaterno.setBounds(12, 115, 114, 16);
		contentPanel.add(lblApellidoPaterno);
		
		nombre = new JTextField();
		nombre.setBounds(180, 74, 116, 22);
		contentPanel.add(nombre);
		nombre.setColumns(10);
		
		ubi = new JTextField();
		ubi.setBounds(180, 112, 116, 22);
		contentPanel.add(ubi);
		ubi.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String campo = busqueda.getText();
				String where = "";
				if(!"".equals(campo)) {
					where = "WHERE id_pro = '" + campo +"'";
				}
        		try {
        			DefaultTableModel modelo1 = new DefaultTableModel();
        			con = cn.conectar();
        			con = cn.conectar();        
        	        String sql = "SELECT id_pro, nom_empresa, ubi_pro, tel_pro, email_pro FROM cprovedor " + where;
        	        ps = con.prepareStatement(sql);
        	        rs = ps.executeQuery();
        	        table.setModel(modelo1);
        	        ResultSetMetaData rsMD = rs.getMetaData();
        	        int cantidadColumnas = rsMD.getColumnCount();
        	        modelo1.addColumn("Codigo");
        	        modelo1.addColumn("Nombre");
        	        modelo1.addColumn("Ubicacion");
        	        modelo1.addColumn("Telefono");
        	        modelo1.addColumn("email");
        	        
        	        while(rs.next()) {
        	        	Object[]  filas = new Object[cantidadColumnas];
        	        	
        	        	for (int i = 0; i < cantidadColumnas; i++) {
        					filas[i] = rs.getObject(i + 1 );
        				}
        	        	modelo1.addRow(filas);
        	        }
        	        		
        		} catch (Exception e1) {
        			JOptionPane.showMessageDialog(null, "Error");
        		}
				
			}
		});
		btnConsultar.setBounds(12, 238, 86, 25);
		contentPanel.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();
		            ps = con.prepareStatement("UPDATE cprovedor SET id_pro=?, nom_empresa=?, ubi_pro=?, tel_pro=?, email_pro=? WHERE id_pro=? ");
		            ps.setString(1, id.getText());
		            ps.setString(2, nombre.getText());
		            ps.setString(3, ubi.getText());
		            ps.setString(4, tel.getText());
		            ps.setString(5, email.getText());
		            ps.setString(6, busqueda.getText());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[6];
		            fila[0] = id.getText();
		            fila[1] = nombre.getText();
		            fila[2] = ubi.getText();
		            fila[3] = tel.getText();
		            fila[4] = email.getText();
		            busqueda.setText("");
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
		btnModificar.setBounds(108, 238, 86, 25);
		contentPanel.add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();
					ps = con.prepareStatement("INSERT INTO cprovedor (id_pro, nom_empresa, ubi_pro, tel_pro, email_pro) VALUES(?,?,?,?,?) ");
					ps.setString(1, id.getText());
		            ps.setString(2, nombre.getText());
		            ps.setString(3,ubi.getText());
		            ps.setString(4, tel.getText());
		            ps.setString(5, email.getText());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[5];
		            fila[0] = id.getText();
		            fila[1] = nombre.getText();
		            fila[2] = ubi.getText();
		            fila[3] = tel.getText();
		            fila[4] = email.getText();
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
		btnGuardar.setBounds(204, 238, 78, 25);
		contentPanel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();
		            int Fila = table.getSelectedRow();
		            String codigo = table.getValueAt(Fila,0).toString();
					ps = con.prepareStatement("DELETE FROM cprovedor  WHERE id_pro=? ");
		            ps.setString(1,codigo);
		            int res = ps.executeUpdate();
		            modelo1.removeRow(Fila);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnEliminar.setBounds(292, 238, 78, 25);
		contentPanel.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 274, 385, 200);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Proveedor", "Ubicacion", "Telefono", "email"
			}
		));
		scrollPane.setViewportView(table);
		
		busqueda = new JTextField();
		busqueda.setBounds(382, 174, 86, 20);
		contentPanel.add(busqueda);
		busqueda.setColumns(10);
		
	}
}
