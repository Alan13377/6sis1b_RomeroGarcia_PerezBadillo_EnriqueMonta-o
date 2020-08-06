package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen frame = new Almacen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Almacen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ID. del Producto:");
		label.setBounds(12, 16, 101, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Seleccione Armadora:");
		label_1.setBounds(12, 49, 132, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Seleccione Modelo:");
		label_2.setBounds(12, 89, 112, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Seleccione A\u00F1o:");
		label_3.setBounds(12, 125, 100, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("No. de piezas:");
		label_4.setBounds(12, 158, 132, 16);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(182, 13, 93, 20);
		contentPane.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(182, 46, 93, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(182, 86, 93, 20);
		contentPane.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(182, 122, 93, 20);
		contentPane.add(textField_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(208, 155, 67, 22);
		contentPane.add(spinner);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(343, 16, 93, 20);
		contentPane.add(textField_2);
		
		JButton button = new JButton("Mostrar");
		button.setBounds(341, 49, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Limpiar");
		button_1.setBounds(425, 171, 95, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Salir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setBounds(425, 209, 95, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Atras");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		button_3.setBounds(321, 209, 95, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Eliminar");
		button_4.setBounds(221, 209, 95, 25);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Modificar");
		button_5.setBounds(119, 209, 95, 25);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Guardar");
		button_6.setBounds(12, 209, 95, 25);
		contentPane.add(button_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 245, 508, 196);
		contentPane.add(scrollPane);
	}
}
