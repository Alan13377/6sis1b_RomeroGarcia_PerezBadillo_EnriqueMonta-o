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
import modelo.ProductoCrud;
import modelo.ProductoM;
import vista.Menu2;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;


public class Producto extends JDialog {
DefaultTableModel modelo1 = new DefaultTableModel();

	
	private final JPanel dir = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField dni;
	private JTextField nombre;
	private JTable table;
	int ide;

	
	PreparedStatement ps;
	ResultSet rs;
	
	ClienteCrud cr = new ClienteCrud();
	ClienteM cm = new ClienteM();
	ProductoCrud proc = new ProductoCrud();
	ProductoM prodM = new ProductoM();
	private JTextField precio;
	private JTextField stock;
	
	
	void listar() {
		List<ProductoM> lista = proc.listar();
		modelo1 = (DefaultTableModel)table.getModel();
		Object[]ob = new Object[5];
		for(int i = 0;i<lista.size();i++) {
			ob[0] = lista.get(i).getId();
			ob[1] = lista.get(i).getProd();
			ob[2] = lista.get(i).getPrecio();
			ob[3] = lista.get(i).getStock();
			modelo1.addRow(ob);
		}	
		
		table.setModel(modelo1);
	}
	
	
	
	public static void main(String[] args) {
		try {
			Producto dialog = new Producto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Producto() {
		setTitle("Producto");
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
		
		JLabel lblIdCliente = new JLabel("ID");
		lblIdCliente.setBounds(12, 13, 78, 16);
		dir.add(lblIdCliente);
		
		dni = new JTextField();
		dni.setBounds(122, 10, 78, 22);
		dir.add(dni);
		dni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Producto");
		lblNombre.setBounds(12, 54, 78, 16);
		dir.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(122, 51, 116, 22);
		dir.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblDirreccion = new JLabel("Precio");
		lblDirreccion.setBounds(12, 97, 62, 16);
		dir.add(lblDirreccion);
		
		JLabel lblNewLabel = new JLabel("Stock");
		lblNewLabel.setBounds(12, 137, 56, 16);
		dir.add(lblNewLabel);
		
		
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
					ide = Integer.parseInt(modelo1.getValueAt(fila,0).toString());
					String dn = modelo1.getValueAt(fila,0).toString();	
					String nom = modelo1.getValueAt(fila,1).toString();
					String prec = modelo1.getValueAt(fila,2).toString();
					String sto = modelo1.getValueAt(fila,3).toString();
					dni.setText(dn);	
					nombre.setText(nom);
					precio.setText(prec);
					stock.setText(sto);
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Producto", "Precio", "Stock"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton_2 = new JButton("Limpiar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dni.setText("");
	             nombre.setText(null);
	             precio.setText(null);
				 stock.setText(null);
	            
			}
		});
		btnNewButton_2.setBounds(239, 204, 89, 23);
		dir.add(btnNewButton_2);
		
		precio = new JTextField();
		precio.setBounds(132, 84, 86, 20);
		dir.add(precio);
		precio.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(114, 135, 86, 20);
		dir.add(stock);
		stock.setColumns(10);
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
		String prec =precio.getText();
		String sto = stock.getText().toString();
		Object[] ob = new Object[4];
		ob[0] = dn;
		ob[1] = nom;
		ob[2] = prec;
		ob[3] = sto;
		proc.add(ob);
		
	}
	
	void actualizar() {
		int fila = table.getSelectedRow();
		if(fila ==-1) {
			JOptionPane.showMessageDialog(null, "Seleccione fila");
		}
		String dn = dni.getText();	
		String nom = nombre.getText();
		Object prec =precio.getText();
		Object sto = stock.getText();
		Object[] ob = new Object[4];
		ob[0] = nom;
		ob[1] = prec;
		ob[2] = sto;
		ob[3] = ide;
		proc.actualizar(ob);

	}
	
	void eliminar() {
		int fila = table.getSelectedRow();
		int ids = Integer.parseInt(table.getValueAt(fila,0).toString());
		if(fila ==-1) {
			JOptionPane.showMessageDialog(null, "Seleccione fila");
		}else {
			proc.eliminar(ide);
		}
	}
}
