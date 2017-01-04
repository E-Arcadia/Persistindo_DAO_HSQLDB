package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.Automovel;

public class AutomovelView extends JFrame {
	
	public AutomovelView( ArrayList<Automovel> listaAutomovel) {
		setBounds(200, 100, 300, 380);
		JTable automovelJTable = new JTable(new AdapterJTable(listaAutomovel));
		automovelJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane jScrollPane = new JScrollPane(automovelJTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(jScrollPane);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		pack();
		setVisible(true);
	}
	

}
