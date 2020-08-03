package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Evendedor;
import modelo.Vendedor;



public class Interfaz extends JFrame {
	
	Vendedor vend = new Vendedor();
	Evendedor ev = new Evendedor();
	
	private JPanel contentPane;
	private JTextField usu;
	private JPasswordField contra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/img/construct.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(65, 105, 225));
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setBounds(55, 26, 129, 115);
		ImageIcon user =  new ImageIcon(getClass().getResource("/img/multiple-users-silhouette.png"));
		ImageIcon icono = new ImageIcon(user.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(icono);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(35, 166, 149, 115);
		ImageIcon auto =  new ImageIcon(getClass().getResource("/img/automation.png"));
		ImageIcon icono2 = new ImageIcon(auto.getImage().getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_4.setIcon(icono2);
		panel1.add(lblNewLabel_4);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(47, 79, 79));
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(10, 11, 150, 42);
		panel2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(10, 87, 46, 14);
		panel2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3.setBounds(10, 160, 100, 14);
		panel2.add(lblNewLabel_3);
		
		usu = new JTextField();
		usu.setToolTipText("Usuario\r\n");
		usu.setBounds(10, 112, 179, 26);
		panel2.add(usu);
		usu.setColumns(10);
		
		contra = new JPasswordField();
		contra.setToolTipText("Contrase\u00F1a");
		contra.setBounds(10, 186, 179, 26);
		panel2.add(contra);
		
		
		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
				
			}
			public void validar() {
				String dni = contra.getText();
				String user = usu.getText();
				if(usu.getText().equals("") || contra.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No ingreso el Dato");
					usu.requestFocus();
				}else {
					ev = vend.ValidarVendedor(dni, user);
					if(ev.getUser() != null && ev.getDni() != null) {
						Menu2 menu = new Menu2();
						menu.setVisible(true);
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Datos Invalidos");
						usu.requestFocus();
					}
				}
			}
		});
		
			ingresar.setBounds(100, 238, 89, 23);
		panel2.add(ingresar);
		
	}

}
