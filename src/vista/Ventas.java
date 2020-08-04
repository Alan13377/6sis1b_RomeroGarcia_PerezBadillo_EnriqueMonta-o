package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import modelo.ClienteCrud;
import modelo.ClienteM;
import modelo.Conexion;
import modelo.ProductoCrud;
import modelo.ProductoM;
import modelo.VentasCRUD;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventas extends JDialog {
	
	ClienteCrud cdao = new ClienteCrud();
	ProductoCrud pcrud = new ProductoCrud();
	ProductoM p = new ProductoM();
	DefaultTableModel modelo = new DefaultTableModel();
	private final JPanel content = new JPanel();
	private JTextField id_1;
	private JTextField cost;
	private JTable table;
	PreparedStatement ps;
	ResultSet rs;
	private JTextField id_cli;
	private JTextField precioT;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	int idp,cant;
	double pre;
	public static void main(String[] args) {
		try {
			Ventas dialog = new Ventas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ventas() {
		setTitle("Ventas");
		setBounds(100, 100, 627, 539);
		getContentPane().setLayout(new BorderLayout());
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(content, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(202, 165, 90, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		content.setLayout(null);
		content.add(btnNewButton);
		
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setBounds(10, 40, 79, 14);
		content.add(lblIdProducto);
		
		id_1 = new JTextField();
		id_1.setBounds(93, 37, 108, 20);
		content.add(id_1);
		id_1.setColumns(10);
		
		JLabel lblPiezas = new JLabel("No. Piezas:");
		lblPiezas.setBounds(10, 102, 79, 14);
		content.add(lblPiezas);
		
		JSpinner piezas = new JSpinner();
		piezas.setBounds(93, 99, 108, 20);
		piezas.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		content.add(piezas);
		
		JLabel lblCostos = new JLabel("Costo:");
		lblCostos.setBounds(10, 71, 60, 14);
		content.add(lblCostos);
		
		cost = new JTextField();
		cost.setBounds(93, 68, 108, 20);
		content.add(cost);
		cost.setColumns(10);
		
		Label label = new Label("Fecha:");
		label.setBounds(10, 133, 47, 22);
		content.add(label);
		
		JDateChooser fecha1 = new JDateChooser();
		fecha1.setDateFormatString("yyyy/MM/d");
		fecha1.setBounds(93, 133, 108, 22);
		content.add(fecha1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(511, 165, 90, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		content.add(btnSalir);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(219, 76, 0, 0);
		content.add(label_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 217, 393, 234);
		content.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NRO", "Codigo", "Producto", "Cantidad", "Precio", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_1.setText("");
	             cost.setText(null);
	             piezas.setValue(0);
	             fecha1.setDate(null);
	           
			}
		});
		btnNewButton_1.setBounds(302, 165, 89, 23);
		content.add(btnNewButton_1);
		
		id_cli = new JTextField();
		id_cli.setBounds(93, 11, 86, 20);
		content.add(id_cli);
		id_cli.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 14, 46, 14);
		content.add(lblNewLabel);
		
		precioT = new JTextField();
		precioT.setBounds(322, 469, 86, 20);
		content.add(precioT);
		precioT.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(271, 472, 63, 14);
		content.add(lblNewLabel_1);
		
		
		
		JButton btn_bc = new JButton("Cliente");
		btn_bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente();
				
			}

			private void buscarCliente() {
				int r=0;
				String cod = id_cli.getText();
				if(id_cli.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo vacio");
				}else {
					ClienteM cliente = cdao.ListarId(cod);
					if(cliente.getDni()!=null) {
						textField_1.setText(cliente.getNom());
						textField_2.requestFocus();
					}else {
						JOptionPane.showMessageDialog(null, "No encontrado");
						if(r==0) {
							Cliente cf = new Cliente();
							cf.setVisible(true);
						}
					}
				}
				
			}
		
		});
		
		
		btn_bc.setBounds(10, 165, 89, 23);
		content.add(btn_bc);
		
		JButton btn_bp = new JButton("Producto");
		btn_bp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarProducto();
			}

			private void buscarProducto() {
				 int ide = Integer.parseInt(id_1.getText());
				if(id_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No ingreso el producto");
				}else {
					ProductoM p = pcrud.ListarId(ide);
					if(p.getId()!=0) {
						textField_2.setText(p.getProd());
						cost.setText(""+p.getPrecio());
						textField_3.setText(""+p.getStock());
					}else {
						JOptionPane.showMessageDialog(null, "No se encontro el producto");
						id_1.requestFocus();
					}
				}
				
			}
		});
		btn_bp.setBounds(103, 165, 89, 23);
		content.add(btn_bp);
		
		JButton btnNewButton_3 = new JButton("Agregar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
				Total();
			}

			private void agregarProducto() {
				int cont=0;
				modelo = (DefaultTableModel)table.getModel();
			    cont=cont+1;
				idp = p.getId();
				String nomprod= id_1.getText();
				int ide = Integer.parseInt(id_1.getText());
				 pre =Double.parseDouble(cost.getText());
				 cant = Integer.parseInt(piezas.getValue().toString());
				int stock = Integer.parseInt(textField_3.getText());
				double total;
				total = cant*pre;
				ArrayList lista = new ArrayList();
				if(stock>0) {
					lista.add(cont);
					lista.add(ide);
					lista.add(nomprod);
					lista.add(cant);
					lista.add(pre);
					lista.add(total);
					Object[] ob = new Object[6];
					ob[0]=lista.get(0);
					ob[1]=lista.get(1);
					ob[2]=lista.get(2);
					ob[3]=lista.get(3);
					ob[4]=lista.get(4);
					ob[5]=lista.get(5);
					
					modelo.addRow(ob);
					table.setModel(modelo);
				}else {
					JOptionPane.showMessageDialog(null, "Producto no disponible");
				}
				
			}
			void Total() {
				double pago = 0;
				for(int i = 0;i<table.getRowCount();i++) {
					cant = Integer.parseInt(table.getValueAt(i,3).toString());
					pre = Double.parseDouble(table.getValueAt(i,4).toString());
					pago  =pago+(cant*pre);
				}
				precioT.setText(""+pago);
			}
		});
		btnNewButton_3.setBounds(404, 165, 89, 23);
		content.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(267, 14, 46, 14);
		content.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Producto");
		lblNewLabel_3.setBounds(267, 40, 46, 14);
		content.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(343, 11, 86, 20);
		content.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(343, 37, 86, 20);
		content.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(343, 79, 86, 20);
		content.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(343, 120, 86, 20);
		content.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setBounds(267, 82, 46, 14);
		content.add(lblNewLabel_4);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(267, 123, 25, 0);
		content.add(label_2);
		
		JLabel lblNewLabel_5 = new JLabel("Vende");
		lblNewLabel_5.setBounds(267, 123, 46, 14);
		content.add(lblNewLabel_5);

		
	}	
}
