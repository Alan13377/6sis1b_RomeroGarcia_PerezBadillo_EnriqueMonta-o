package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Menu2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JButton prov;
	public JButton emp;
	public JButton vent;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Menu2 dialog = new Menu2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Menu2() {
		setBounds(100, 100, 603, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JButton inv = new JButton("Almacen");
		inv.setBounds(26, 64, 180, 101);
		inv.setHorizontalTextPosition(SwingConstants.CENTER);
		inv.setVerticalTextPosition(SwingConstants.BOTTOM);
		ImageIcon inven = new ImageIcon(Menu2.class.getResource("/img/box.png"));
		ImageIcon iconoI = new ImageIcon(inven.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		inv.setIcon(iconoI);
		inv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPanel.setLayout(null);
		inv.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		contentPanel.add(inv);
		
		JButton emp = new JButton("Empleados");
		emp.setBounds(217, 64, 180, 101);
		emp.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		emp.setHorizontalTextPosition(SwingConstants.CENTER);
		emp.setVerticalTextPosition(SwingConstants.BOTTOM);
		ImageIcon dd = new ImageIcon(Menu2.class.getResource("/img/usuario.png"));
		ImageIcon icono2 = new ImageIcon(dd.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		emp.setIcon(icono2);
		emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPanel.add(emp);
		
		JButton prov = new JButton("Proveedores");
		prov.setBounds(26, 186, 180, 106);
		prov.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		prov.setVerticalTextPosition(SwingConstants.BOTTOM);
		prov.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon prove = new ImageIcon(Menu2.class.getResource("/img/frontal-truck.png"));
		ImageIcon iconoP = new ImageIcon(prove.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		prov.setIcon(iconoP);
		prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPanel.add(prov);
		
		JButton vent = new JButton("Ventas");
		vent.setBounds(217, 189, 180, 101);
		vent.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		vent.setVerticalTextPosition(SwingConstants.BOTTOM);
		vent.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon venta = new ImageIcon(Menu2.class.getResource("/img/ventas.png"));
		ImageIcon iconoV = new ImageIcon(venta.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		vent.setIcon(iconoV);
		vent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas venta = new Ventas();
				venta.setVisible(true);
				dispose();
			}
		});
		contentPanel.add(vent);
		
		JLabel lblNewLabel = new JLabel("Elija una Operacion");
		lblNewLabel.setBounds(167, 11, 244, 42);
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 29));
		contentPanel.add(lblNewLabel);
		
		JButton clientes = new JButton("Clientes");
		clientes.setBounds(407, 64, 160, 101);
		clientes.setHorizontalTextPosition(SwingConstants.CENTER);
		clientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		clientes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		ImageIcon cliente = new ImageIcon(Menu2.class.getResource("/img/clientes.png"));
		ImageIcon iconoC = new ImageIcon(cliente.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		clientes.setIcon(iconoC);
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente client = new Cliente();
				client.setVisible(true);
				dispose();
				
			}
		});
		contentPanel.add(clientes);
		
		JButton btnProduccion = new JButton("Produccion");
		btnProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnProduccion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProduccion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProduccion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		ImageIcon produccion = new ImageIcon(Menu2.class.getResource("/img/production.png"));
		ImageIcon iconoProd = new ImageIcon(cliente.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		btnProduccion.setBounds(407, 186, 160, 101);
		btnProduccion.setIcon(iconoProd);
		contentPanel.add(btnProduccion);
		
	}
}
