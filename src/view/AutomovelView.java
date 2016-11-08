package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import entidade.Automovel;

public class AutomovelView extends JFrame {
	
	public AutomovelView( ArrayList<Automovel> listaAutomovel) {
		JTable automovelJTable = new JTable(new AdapterJTable(listaAutomovel));
		add(automovelJTable);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	

}
