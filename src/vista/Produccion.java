package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


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
	private JTextField busqueda;

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
		setBounds(100, 100, 559, 624);
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
		btnNewButton.setBounds(432, 249, 95, 25);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(432, 211, 95, 25);
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
				
			}
		});
		btnConsulat.setBounds(413, 23, 97, 25);
		contentPanel.add(btnConsulat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 287, 515, 285);
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
		busqueda.setBounds(307, 25, 86, 20);
		contentPanel.add(busqueda);
		busqueda.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_2.setBounds(12, 249, 95, 25);
		contentPanel.add(btnNewButton_2);
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		modificar.setBounds(119, 246, 95, 25);
		contentPanel.add(modificar);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		eliminar.setBounds(226, 249, 95, 25);
		contentPanel.add(eliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				fecha1.setDate(null);
				fecha2.setDate(null);
				prod.setSelectedItem(null);
				cant.setValue(0);
			}
		});
		btnLimpiar.setBounds(333, 249, 95, 25);
		contentPanel.add(btnLimpiar);
		
	}
}
