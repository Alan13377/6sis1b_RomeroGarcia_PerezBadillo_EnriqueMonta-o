package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import modelo.ClienteM;
import modelo.Conexion;
import modelo.Evendedor;
import modelo.Vendedor;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Empleado extends JDialog {
	DefaultTableModel modelo1 = new DefaultTableModel();
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField codigo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tel;
	private JTextField pue;
	private JTextField user;
	private JTable table;
	private JTable table_1;
	private JTextField busqueda;
	PreparedStatement ps;
	ResultSet rs;
	Vendedor vend = new Vendedor();
	Evendedor even = new Evendedor();
	Connection con;
	Conexion cn = new Conexion();
	int id;
	
	/*void listar() {
		List<Evendedor> lista = vend.listar();
		modelo1 = (DefaultTableModel)table.getModel();
		Object[]ob = new Object[6];
		for(int i = 0;i<lista.size();i++) {
			ob[0] = lista.get(i).getId();
			ob[1] = lista.get(i).getDni();
			ob[2] = lista.get(i).getNom();
			ob[3] = lista.get(i).getEsta();
			ob[4] = lista.get(i).getTel();
			ob[5] = lista.get(i).getUser();
			modelo1.addRow(ob);
		}	
		
		table.setModel(modelo1);
	}*/
	
	public static void main(String[] args) {
		try {
			Empleado dialog = new Empleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Empleado() {
		setTitle("Empleados");
		setBounds(100, 100, 624, 651);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(372, 517, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		contentPanel.add(btnNewButton);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales --------------------------------------------------------------------------------------------\r\n\r\n");
		lblDatosPersonales.setBounds(12, 13, 576, 16);
		contentPanel.add(lblDatosPersonales);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 122, 79, 16);
		contentPanel.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(132, 119, 116, 22);
		contentPanel.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(12, 72, 79, 16);
		contentPanel.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(132, 69, 67, 22);
		contentPanel.add(codigo);
		codigo.setColumns(10);
		ImageIcon usuario =  new ImageIcon(getClass().getResource("/img/empleado.png"));
		ImageIcon iconoU = new ImageIcon(usuario.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
		
		JButton btnConsultar = new JButton("Consultar ");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String campo = codigo.getText();
					String where = "";
					if(!"".equals(campo)) {
						where = "WHERE id_vend = '" + campo +"'";
					}
					DefaultTableModel modelo1 = new DefaultTableModel();
					con =cn.conectar();
					String sql = "SELECT dni,nombre,telefono,estado,user FROM vendedor"+where;
					
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					table_1.setModel(modelo1);
					ResultSetMetaData rsMD = rs.getMetaData();
					int catidadColumnas = rsMD.getColumnCount();
					modelo1.addColumn("codigo");
					modelo1.addColumn("Nom");
					
					modelo1.addColumn("Puesto");
					
					modelo1.addColumn("Tele");
					modelo1.addColumn("User");
					while(rs.next()) {
						Object[] filas = new Object[catidadColumnas];
						
						for (int i = 0; i < catidadColumnas; i++) {
							filas[i] = rs.getObject(i + 1);
						}
						modelo1.addRow(filas);
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
				
        	    
		});
		btnConsultar.setBounds(12, 566, 97, 25);
		contentPanel.add(btnConsultar);
		
	
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(372, 566, 97, 25);
		contentPanel.add(btnSalir);
		
		JLabel lblTelefon = new JLabel("Telefono:");
		lblTelefon.setBounds(12, 197, 56, 16);
		contentPanel.add(lblTelefon);
		
		tel = new JTextField();
		tel.setBounds(117, 194, 149, 22);
		contentPanel.add(tel);
		tel.setColumns(10);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setBounds(12, 156, 56, 16);
		contentPanel.add(lblPuesto);
		
		pue = new JTextField();
		pue.setBounds(132, 153, 116, 22);
		contentPanel.add(pue);
		pue.setColumns(10);
		
		JLabel lbluser = new JLabel("User");
		lbluser.setBounds(12, 242, 56, 16);
		contentPanel.add(lbluser);
		
		user = new JTextField();
		user.setBounds(117, 239, 149, 22);
		contentPanel.add(user);
		user.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 272, 530, 237);
		contentPanel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Puesto", "telefono", "User"
			}
		));
		scrollPane.setViewportView(table_1);
		
		busqueda = new JTextField();
		busqueda.setBounds(12, 534, 86, 20);
		contentPanel.add(busqueda);
		busqueda.setColumns(10);
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con =cn.conectar();
				actualizar();
				limpiarTabla();
				//listar();
			}
		});
		btnModificar.setBounds(132, 566, 97, 25);
		contentPanel.add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
				limpiarTabla();
				//listar();
			}
		});
		btnGuardar.setBounds(252, 566, 97, 25);
		contentPanel.add(btnGuardar);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con =cn.conectar();
		            int Fila = table_1.getSelectedRow();
		            String codigo = table_1.getValueAt(Fila,0).toString();
					ps = con.prepareStatement("DELETE FROM vendedor  WHERE dni=? ");
		            ps.setString(1,codigo);
		            int res = ps.executeUpdate();
		            modelo1.removeRow(Fila);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				eliminar();
				limpiarTabla();
			}
				
				//listar();
			
		});
		eliminar.setBounds(481, 567, 107, 23);
		contentPanel.add(eliminar);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 codigo.setText("");
	             nombre.setText(null);
	             pue.setText(null);
	            tel.setText(null);
	             user.setText(null);
			}
		});
		btnNewButton_1.setBounds(481, 517, 107, 23);
		contentPanel.add(btnNewButton_1);


		
	}
	void limpiarTabla() {
		for (int i = 0; i<modelo1.getRowCount();i++) {
			modelo1.removeRow(i);
			i=i-1;
		}
	}
	
	void agregar() {
		String dn = codigo.getText();	
		String nom = nombre.getText();
		String pues = pue.getText();
		String tele = tel.getText();
		String us = user.getText();
		Object[] ob = new Object[5];
		ob[0] = dn;
		ob[1] = nom;
		ob[2] = pues;
		ob[3] = tele;
		ob[4] = us;
		vend.add(ob);
		
	}
	
	void actualizar() {
		int fila = table.getSelectedRow();
		if(fila ==-1) {
			JOptionPane.showMessageDialog(null, "Seleccione fila");
		}
		String dn = codigo.getText();	
		String nom = nombre.getText();
		String pues = pue.getText();
		String tele = tel.getText();
		String us = user.getText();
		Object[] ob = new Object[6];
		ob[0] = dn;
		ob[1] = nom;
		ob[2] = pues;
		ob[3] = tele;
		ob[4] = us;
		ob[5] = id;
		vend.actualizar(ob);

	}
	
	void eliminar() {
		int fila = table.getSelectedRow();
		int ids = Integer.parseInt(table.getValueAt(fila,0).toString());
		if(fila ==-1) {
			JOptionPane.showMessageDialog(null, "Seleccione fila");
		}else {
			vend.eliminar(id);
		}
	}
	
}
