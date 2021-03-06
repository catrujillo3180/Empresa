package interfaz;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class DialogoNovedadesHoras extends JDialog implements ActionListener
{
	private InterfazNomina principal;
	private ArrayList<Integer> indices;
	private Date fecha;
	private int cont;
	private JTable tableNovedaesHoras;
	private DecimalFormat formatea;
	private String titulo;
	private JPanel panel;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	public DialogoNovedadesHoras( InterfazNomina ventana) {
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoNovedadesHoras.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		//		titulo = "Horas Extras Diurnas";
		cont = 0;
		setTitle("Devengado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 688, 384);


		panel = new JPanel();
		panel.setLayout(null);
		//		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 652, 288);
		getContentPane().add(panel);
		Object[] dataHoras = { "", "",""};
		Object[] columnsHoras = {"Fecha Ingreso","Usuario","Fecha Realización", "Cantidad","Concepto","Valor Unitario","SubTotal"};
		DefaultTableModel modN = new DefaultTableModel(columnsHoras, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tableNovedaesHoras = new JTable(modN);
		tableNovedaesHoras.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tableNovedaesHoras);
		scrollPane.setBounds(10, 22, 632, 221);
		panel.add(scrollPane);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(164, 254, 169, 23);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		panel.add(btnModificar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(343, 254, 169, 23);
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("Agregar");
		panel.add(btnAgregar);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(165, 310, 186, 23);
		btnAnterior.addActionListener(this);
		btnAnterior.setActionCommand("Anterior");
		getContentPane().add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(361, 310, 164, 23);
		btnSiguiente.addActionListener(this);
		btnSiguiente.setActionCommand("Siguiente");
		getContentPane().add(btnSiguiente);

		actualizarTitulo();
		//		actualizarAbonos();
		//		actualizarNotas();
	}


	public void actualizarTitulo( )
	{

		switch ( cont ) {
		case 0: titulo = "Ordinaria - Extra Diurno";  btnAnterior.setEnabled(false); break;
		case 1: titulo = "Ordinaria - Extra Nocturno";  btnAnterior.setEnabled(true); break;
		case 2: titulo = "Dominical y Festivo - Extra Diurno";  break;
		case 3: titulo = "Dominical y Festivo - Extra Nocturno";  btnSiguiente.setEnabled(true); break;
		case 4: titulo = "Dominical y Festivo - Dominical y Festivo"; btnSiguiente.setEnabled(false); break;
		default:  titulo = "Ordinaria - Extra Diurno"; btnAnterior.setEnabled(false); break;
		}
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	private void actualizarAbonos() {
		//		ArrayList nuevaLista = actual.getAbonos();
		//
		//		if( !nuevaLista.isEmpty( ) ){
		//			for (int i = 0; i < nuevaLista.size(); i++){
		//				Abono a = (Abono) nuevaLista.get(i);
		//				DefaultTableModel model = (DefaultTableModel) tableAbonos.getModel();
		//				model.addRow(new Object[]{a.getFecha().toLocaleString(),
		//						formatea.format(a.getAbono())});
		//			}
		//		}
		//

	}

	private void actualizarNotas() {
		//		ArrayList nuevaListaNotas = actual.getNotasCredito();
		//
		//		if( !nuevaListaNotas.isEmpty( ) ){
		//			for (int i = 0; i < nuevaListaNotas.size(); i++){
		//				NotaCredito nc = (NotaCredito) nuevaListaNotas.get(i);
		//				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
		//				int pos = i + 1;
		//				model.addRow(new Object[]{"NOTA - "+pos,
		//						nc.getFecha(),
		//						formatea.format(nc.getTotal())});
		//			}
		//		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println( command );
		if(command.equals("Agregar"))
		{
		}
		else if (command.equals("Modificar")){
			
		}
		else if( command.equals("Anterior")){
			cont--;
			actualizarTitulo();
		}
		else if( command.equals("Siguiente")){
			cont++;
			actualizarTitulo();
		}
	}

}
