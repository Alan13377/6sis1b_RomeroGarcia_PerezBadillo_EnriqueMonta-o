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
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Conexion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class almacenes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField busqueda;
	private JTextField id;
	private JTextField ano;
	private Object comboBox1;
	private Object comboBox2;
	private JTable table;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Conexion cn = new Conexion();

	
	
	public String[]datos(String datos){
		String[]informacion=new String[3];
		if(datos.equalsIgnoreCase("Nissan")) {
			informacion[0]="Altima";
			informacion[1]="Platina";
			informacion[2]="Sentra";
		}
		if(datos.equalsIgnoreCase("Chevrollet")) {
			informacion[0]="Aveo";
			informacion[1]="Chevy";
			informacion[2]="Corsa";
		}
		return informacion;
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			almacenes dialog = new almacenes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public almacenes() {
		setTitle("Almacen");
		setBounds(100, 100, 520, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox modelo = new JComboBox();
		modelo.setModel(new DefaultComboBoxModel(new String[] {"Chevrolet", "Aveo ", "Chevi", "Corsa"}));
		modelo.setBounds(182, 106, 93, 20);
		contentPanel.add(modelo);
		
		JComboBox armadora = new JComboBox();
		armadora.setModel(new DefaultComboBoxModel(new String[] {"Nissan", "Altima", "Platina", "Sentra"}));
		armadora.setBounds(182, 66, 93, 20);
		contentPanel.add(armadora);
		
		JLabel lblNewLabel = new JLabel("Seleccione Armadora:");
		lblNewLabel.setBounds(24, 69, 132, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Modelo:");
		lblNewLabel_1.setBounds(24, 109, 112, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione A\u00F1o:");
		lblNewLabel_2.setBounds(24, 145, 100, 14);
		contentPanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(408, 195, 86, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		contentPanel.add(btnNewButton);
		
		busqueda = new JTextField();
		busqueda.setBounds(123, 231, 87, 20);
		busqueda.setToolTipText("");
		contentPanel.add(busqueda);
		busqueda.setColumns(10);
		
		id = new JTextField();
		id.setBounds(182, 33, 93, 20);
		contentPanel.add(id);
		id.setColumns(10);
		
		ano = new JTextField();
		ano.setBounds(182, 142, 93, 20);
		contentPanel.add(ano);
		ano.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID. del Producto:");
		lblNewLabel_3.setBounds(24, 39, 101, 14);
		contentPanel.add(lblNewLabel_3);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(408, 229, 86, 25);
		contentPanel.add(btnSalir);
		
		JLabel lblPiezasEnExistencia = new JLabel("No. de piezas:");
		lblPiezasEnExistencia.setBounds(24, 185, 132, 16);
		contentPanel.add(lblPiezasEnExistencia);
		
		JSpinner piezas = new JSpinner();
		piezas.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		piezas.setBounds(208, 175, 67, 22);
		contentPanel.add(piezas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 264, 461, 200);
		contentPanel.add(scrollPane);
		 JButton carfar = new JButton("Mostrar");
	        carfar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		String campo = busqueda.getText();
					String where = "";
					if(!"".equals(campo)) {
						where = "WHERE id_alm = '" + campo +"'";
					}
	        		try {
	        			DefaultTableModel modelo1 = new DefaultTableModel();
	        			con = cn.conectar();       
	        	        String sql = "SELECT id_alm, arm_prod, mod_prod, num_exis, ano_prod FROM ealmacen " + where;
	        	        ps = con.prepareStatement(sql);
	        	        rs = ps.executeQuery();
	        	        table.setModel(modelo1);
	        	        ResultSetMetaData rsMD = rs.getMetaData();
	        	        int cantidadColumnas = rsMD.getColumnCount();
	        	        modelo1.addColumn("Codigo");
	        	        modelo1.addColumn("Armadora");
	        	        modelo1.addColumn("Modelo");
	        	        modelo1.addColumn("No.Existencia");
	        	        modelo1.addColumn("Año Produccion");
	        	        
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
	        carfar.setBounds(24, 230, 89, 23);
	        contentPanel.add(carfar);
		table = new JTable();	
		table.setModel(new DefaultTableModel());
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();  
					ps = con.prepareStatement("INSERT INTO ealmacen (id_alm, arm_prod, mod_prod, ano_prod, num_exis ) VALUES(?,?,?,?,?) ");
					ps.setString(1, id.getText());
		            ps.setString(2, armadora.getSelectedItem().toString());
		            ps.setString(3,modelo.getSelectedItem().toString());
		            ps.setString(4, ano.getText());
		            ps.setString(5, piezas.getValue().toString());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[5];
		            fila[0] = id.getText();
		            fila[1] = armadora.getSelectedItem();
		            fila[2] = modelo.getSelectedItem();
		            fila[3] = ano.getText();
		            fila[4] = piezas.getValue();
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
		btnNewButton_1.setBounds(331, 32, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton mod = new JButton("Modificar");
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();  
		            ps = con.prepareStatement("UPDATE ealmacen SET id_alm=?, arm_prod=?, mod_prod=?, ano_prod=?, num_exis=? WHERE id_alm=? ");
		            ps.setString(1, id.getText());
		            ps.setString(2, armadora.getSelectedItem().toString());
		            ps.setString(3, modelo.getSelectedItem().toString());
		            ps.setString(4, ano.getText());
		            ps.setString(5, piezas.getValue().toString());
		            ps.setString(6, busqueda.getText());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[5];
		            fila[0] = id.getText();
		            fila[1] = armadora.getSelectedItem();
		            fila[2] = modelo.getSelectedItem();
		            fila[3] = ano.getText();
		            fila[4] = piezas.getValue();
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
		mod.setBounds(220, 230, 89, 23);
		contentPanel.add(mod);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					con = cn.conectar();  
		            int Fila = table.getSelectedRow();
		            String codigo = table.getValueAt(Fila,0).toString();
					ps = con.prepareStatement("DELETE FROM ealmacen  WHERE id_alm=? ");
		            ps.setString(1,codigo);
		            int res = ps.executeUpdate();
		            modelo1.removeRow(Fila);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBounds(309, 230, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
	             modelo.setSelectedItem(null);
	             armadora.setSelectedItem(null);
	             ano.setText(null);
	            piezas.setValue(0);
			}
		});
		btnNewButton_3.setBounds(292, 195, 89, 23);
		contentPanel.add(btnNewButton_3);
		
		
	}
}
