import dao.AutomovelDAO;
import entidade.Automovel;
import view.AutomovelView;

public class Principal {

	public static void main(String[] args) {
		new AutomovelDAO().inserir(new Automovel("ZZZ 3434", "2000"));
		new AutomovelDAO().inserir(new Automovel("AAA 3434", "2010"));
		
		
		new AutomovelView(new AutomovelDAO().listar());
		

	}

}
