package application;

import java.util.List;

public interface IDao {
	boolean AjouterE(Entreprise e);
	boolean SupprimerE(Entreprise e );
	boolean ModifE(Entreprise e);
	boolean AjouterS(Salari� s);
	boolean SupprierS(Salari� s);
	boolean ModifS(Salari� s);
	boolean AjouterEmp(Employes emp);
	boolean SupprimerEmp(Employes e);
	boolean AjouterV(Vendeur s);
	boolean SupprimerV(Vendeur s);
	Entreprise findEntrepriseById(int id);
	List<Entreprise> findAll();
}
