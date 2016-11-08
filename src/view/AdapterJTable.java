package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidade.Automovel;

public class AdapterJTable  extends AbstractTableModel{
	private String[] colunasNome = {"ID", "PLACA", "ANO"};
	private ArrayList<Automovel> listaAutomovel;

	public AdapterJTable(ArrayList<Automovel> listaAutomovel) {
		this.listaAutomovel = listaAutomovel;
	}
	
	
	@Override
	public int getColumnCount() {
		return colunasNome.length;
	}

	@Override
	public int getRowCount() {
		return listaAutomovel.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
		
		case 0 : return listaAutomovel.get(rowIndex).getId();
		case 1 : return listaAutomovel.get(rowIndex).getPlaca();
		case 2 : return listaAutomovel.get(rowIndex).getAno();
		default : return "";
		}
	}

}
