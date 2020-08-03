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
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.ClienteCrud;
import modelo.ClienteM;
import modelo.Conexion;
import vista.Menu2;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Cliente extends JDialog {
DefaultTableModel modelo1 = new DefaultTableModel();

	
	private final JPanel dir = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField dni;
	private JTextField nombre;
	private JTextField dire;
	private JTextField email;
	private JTable table;
	int id;
	PreparedStatement ps;
	ResultSet rs;
	private JTextField busqueda;
	
	ClienteCrud cr = new ClienteCrud();
	ClienteM cm = new ClienteM();
	
	
	void listar() {
		List<ClienteM> lista = cr.listar();
		modelo1 = (DefaultTableModel)table.getModel();
		Object[]ob = new Object[5];
		for(int i = 0;i<lista.size();i++) {
			ob[0] = lista.get(i).getId();
			ob[1] = lista.get(i).getDni();
			ob[2] = lista.get(i).getNom();
			ob[3] = lista.get(i).getEmail();
			ob[4] = lista.get(i).getDir();
			modelo1.addRow(ob);
		}	
		
		table.setModel(modelo1);
	}
	
	
	
	public static void main(String[] args) {
		try {
			Cliente dialog = new Cliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public Cliente() {
		setTitle("Clientes");
		setBounds(100, 100, 581, 530);
		getContentPane().setLayout(new BorderLayout());
		dir.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(dir, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(453, 204, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		dir.setLayout(null);
		dir.setLayout(null);
		dir.add(btnNewButton);
		
		JLabel lblIdCliente = new JLabel("Dni Cliente:");
		lblIdCliente.setBounds(12, 13, 78, 16);
		dir.add(lblIdCliente);
		
		dni = new JTextField();
		dni.setBounds(122, 10, 78, 22);
		dir.add(dni);
		dni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 54, 78, 16);
		dir.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(122, 51, 116, 22);
		dir.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblDirreccion = new JLabel("Direccion:");
		lblDirreccion.setBounds(12, 97, 62, 16);
		dir.add(lblDirreccion);
		
		dire = new JTextField();
		dire.setBounds(122, 94, 205, 22);
		dir.add(dire);
		dire.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Correo:");
		lblNewLabel.setBounds(12, 137, 56, 16);
		dir.add(lblNewLabel);
		
		email = new JTextField();
		email.setBounds(122, 142, 205, 22);
		dir.add(email);
		email.setColumns(10);
		
		
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregar();
				limpiarTabla();
				listar();
		}
			
			
			
		});
		btnNuevo.setBounds(12, 240, 97, 25);
		dir.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizar();
				limpiarTabla();
				listar();
			}
		});
		btnModificar.setBounds(122, 240, 97, 25);
		dir.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				limpiarTabla();
				listar();
			}
				
		});
		btnEliminar.setBounds(231, 240, 97, 25);
		dir.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(453, 240, 97, 25);
		dir.add(btnSalir);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 276, 463, 194);
		dir.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila =table.getSelectedRow();
				if(fila == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				}else {
					id =Integer.parseInt (modelo1.getValueAt(fila,0).toString());
					String dn = modelo1.getValueAt(fila,1).toString();	
					String nom = modelo1.getValueAt(fila,2).toString();
					String dr = modelo1.getValueAt(fila,3).toString();
					String em = modelo1.getValueAt(fila,4).toString();
					dni.setText(dn);	
					nombre.setText(nom);
					dire.setText(dr);
					email.setText(em);
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Dni", "Nombre", "email", "direccion"
			}
		));
		scrollPane.setViewportView(table);
		
		busqueda = new JTextField();
		busqueda.setBounds(345, 205, 86, 20);
		dir.add(busqueda);
		busqueda.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Limpiar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dni.setText("");
	             nombre.setText(null);
	            
	            email.setText(null);
	        	dire.setText(null);
	            
			}
		});
		btnNewButton_2.setBounds(239, 204, 89, 23);
		dir.add(btnNewButton_2);
		listar();
	}
	
	void limpiarTabla() {
		for (int i = 0; i<modelo1.getRowCount();i++) {
			modelo1.removeRow(i);
			i=i-1;
		}
	}
	
	void agregar() {
		String dn = dni.getText();	
		String nom = nombre.getText();
		String dr = dire.getText();
		String em = email.getText();
		Object[] ob = new Object[4];
		ob[0] = dn;
		ob[1] = nom;
		ob[2] = dr;
		ob[3] = em;
		cr.add(ob);
		
	}
	
	void actualizar() {
		int fila = table.getSelectedRow();
		if(fila ==-1) {
			JOptionPane.showMessageDialog(null, "Seleccione fila");
		}
		String dn = dni.getText();	
		String nom = nombre.getText();
		String dr = dire.getText();
		String em = email.getText();
		Object[] ob = new Object[5];
		ob[0] = dn;
		ob[1] = nom;
		ob[2] = dr;
		ob[3] = em;
		ob[4] = id;
		cr.actualizar(ob);

	}
	
	void eliminar() {
		int fila = table.getSelectedRow();
		int ids = Integer.parseInt(table.getValueAt(fila,0).toString());
		if(fila ==-1) {
			JOptionPane.showMessageDialog(null, "Seleccione fila");
		}else {
			cr.eliminar(ids);
		}
	}
	
	
}
