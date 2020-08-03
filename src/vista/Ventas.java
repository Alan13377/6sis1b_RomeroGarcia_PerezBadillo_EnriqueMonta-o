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
import modelo.Conexion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventas extends JDialog {

	private final JPanel id = new JPanel();
	private JTextField id_1;
	private JTextField des;
	private JTextField cost;
	private JTextField hora;
	private JTable table;
	PreparedStatement ps;
	ResultSet rs;
	private JTextField busqueda;
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
		setBounds(100, 100, 483, 539);
		getContentPane().setLayout(new BorderLayout());
		id.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(id, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(259, 214, 90, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2();
				menu.setVisible(true);
				dispose();
			}
		});
		id.setLayout(null);
		id.add(btnNewButton);
		
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setBounds(10, 11, 79, 14);
		id.add(lblIdProducto);
		
		id_1 = new JTextField();
		id_1.setBounds(93, 8, 108, 20);
		id.add(id_1);
		id_1.setColumns(10);
		
		JLabel lblDesProducto = new JLabel("Des. Producto:");
		lblDesProducto.setBounds(219, 14, 88, 14);
		id.add(lblDesProducto);
		
		des = new JTextField();
		des.setBounds(361, 8, 90, 20);
		id.add(des);
		des.setColumns(10);
		
		JLabel lblPiezas = new JLabel("No. Piezas:");
		lblPiezas.setBounds(10, 76, 79, 14);
		id.add(lblPiezas);
		
		JSpinner piezas = new JSpinner();
		piezas.setBounds(93, 73, 108, 20);
		piezas.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		id.add(piezas);
		
		JLabel lblCostos = new JLabel("Costo:");
		lblCostos.setBounds(10, 43, 60, 14);
		id.add(lblCostos);
		
		cost = new JTextField();
		cost.setBounds(93, 40, 108, 20);
		id.add(cost);
		cost.setColumns(10);
		
		Label label = new Label("Fecha:");
		label.setBounds(10, 113, 47, 22);
		id.add(label);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(219, 47, 33, 14);
		id.add(lblHora);
		
		JDateChooser fecha1 = new JDateChooser();
		fecha1.setDateFormatString("yyyy/MM/d");
		fecha1.setBounds(93, 111, 108, 22);
		id.add(fecha1);
		
		hora = new JTextField();
		hora.setBounds(361, 44, 90, 20);
		hora.setToolTipText("Hora: Minutos: Segundos:");
		id.add(hora);
		hora.setColumns(10);
		
		JButton buttonImprimir = new JButton("Imprimir");
		buttonImprimir.setBounds(26, 214, 97, 23);
		buttonImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String campo = busqueda.getText();
				String where = "";
				if(!"".equals(campo)) {
					where = "WHERE id_vent = '" + campo +"'";
				}
        		try {
        			DefaultTableModel modelo1 = new DefaultTableModel();
        			Conexion conn = new Conexion();
        	        Connection con = conn.conectar();        
        	        String sql = "SELECT id_vent, cost_vent, piezas_vent, fecha_vent, hora_vent, desc_prod_vent,stock FROM mventas " + where;
        	        ps = con.prepareStatement(sql);
        	        rs = ps.executeQuery();
        	        table.setModel(modelo1);
        	        ResultSetMetaData rsMD = rs.getMetaData();
        	        int cantidadColumnas = rsMD.getColumnCount();
        	        modelo1.addColumn("Codigo");
        	        modelo1.addColumn("Costo");
        	        modelo1.addColumn("Piezas");
        	        modelo1.addColumn("Fecha de Venta");
        	        modelo1.addColumn("Hora");
        	        modelo1.addColumn("Descripcion");
        	        modelo1.addColumn("Stock");
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
		id.add(buttonImprimir);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(361, 214, 90, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		id.add(btnSalir);
		
		JButton guardar = new JButton("Guardar");
		guardar.setBounds(142, 214, 91, 23);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					Conexion conn = new Conexion();
		            Connection con = conn.conectar();
					ps = con.prepareStatement("INSERT INTO mventas (id_vent, cost_vent, piezas_vent, fecha_vent, hora_vent, desc_prod_vent) VALUES(?,?,?,?,?,?)");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(fecha1.getDate());
					ps.setString(1, id_1.getText());
		            ps.setString(2, cost.getText());
		            ps.setString(3,piezas.getValue().toString());
		            ps.setString(4, date);
		            ps.setString(5, hora.getText().toString());
		            ps.setString(6, des.getText().toString());
		            int res = ps.executeUpdate();
		            Object[] fila = new Object[6];
		            fila[0] = id_1.getText();
		            fila[1] = cost.getText();
		            fila[2] = piezas.getValue();
		            fila[3] = fecha1.getDate();
		            fila[4] = hora.getText();
		            fila[5] = des.getText();
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
		
		id.add(guardar);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(219, 76, 0, 0);
		id.add(label_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 255, 393, 234);
		id.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Costo", "No.Piezas", "Fecha", "Hora", "Descripcion","Stock"
			}
		));
		scrollPane.setViewportView(table);
		
		busqueda = new JTextField();
		busqueda.setBounds(26, 177, 86, 20);
		id.add(busqueda);
		busqueda.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_1.setText("");
	             cost.setText(null);
	             piezas.setValue(0);
	             fecha1.setDate(null);
	            hora.setText(null);
	            des.setText(null);
			}
		});
		btnNewButton_1.setBounds(163, 176, 89, 23);
		id.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel modelo1 = new DefaultTableModel();
					Conexion conn = new Conexion();
		            Connection con = conn.conectar();
		            
		            int piez;
		            int sr = 0;
		            int sa = 0;
		            int stock;
		            piez = Integer.parseInt(piezas.getValue().toString());
	            	JOptionPane.showMessageDialog(null, piez);
		            for(int i = 0; i < table.getRowCount();i++) { 
		            	Ventas vent = new Ventas();
			             sr = Integer.parseInt(table.getValueAt(i,0).toString());
			             stock = Integer.parseInt(table.getValueAt(i, 6).toString());
			           
			             sa = stock -piez;
			            System.out.println(sa);
			            table.setValueAt(sa, i, 6);
			            
					}
		            ps = con.prepareStatement("UPDATE mventas SET stock=? WHERE id_vent=? ");
		            ps.setString(2, id_1.getText());
		            ps.setLong(1,sa);
		            ps.executeUpdate();
		            
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnNewButton_2.setBounds(287, 176, 89, 23);
		id.add(btnNewButton_2);

		
	}	
}
