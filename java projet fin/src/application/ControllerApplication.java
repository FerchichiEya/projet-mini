package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;





public class ControllerApplication implements Initializable {
		
		
		
		
		
		
		@FXML
		private TextField nom;
		
		
		@FXML
		private TextField Mat;
		
		@FXML
		private TextField email;
		
		@FXML
		private TextField Rec;
		
		@FXML
		private TextField Vent;
		
		@FXML
		private TextField Sal;
		
		
		@FXML 
		private Button Ajout;
		
		@FXML 
		private Button Modif;
		
		@FXML 
		private Button Supp;
		
		
		@FXML 
		private RadioButton employee;
		
		@FXML 
		private RadioButton vandeur;
		
		
		@FXML
		private TableView<Salarié>table;
		
		@FXML 
		private TableColumn<Salarié,Integer> matc;
		
		@FXML 
		private TableColumn<Salarié,String> nomc;
		
		@FXML 
		private TableColumn<Salarié,String> emailc;
		
		@FXML 
		private TableColumn<Salarié,String> type;
		
		@FXML 
		private TableColumn<Salarié,Double> Salc;
		
		
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			matc.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
			
			nomc.setCellValueFactory(new PropertyValueFactory<>("Nom"));
			
			emailc.setCellValueFactory(new PropertyValueFactory<>("Email"));

			Salc.setCellValueFactory(new PropertyValueFactory<>("salaire"));

			type.setCellValueFactory(new PropertyValueFactory<>("cat"));


			
		}
		
		
		
		
		
			
		/*
		public List<Salarié> listerVendeur() {
			List<Salarié> vdrs = new ArrayList<>();
			try {
				Statement st =connexion.getCon().createStatement();

				String reqV = "SELECT  matricule, nom, email, recrutement, (salaire + vente * pourcentage)"
						+ " as salaireTot from Salarié s, vendeur v where s.matricule = v.Matricule;";
				ResultSet rsE = st.executeQuery(reqV);

				while (rsE.next()) {
					vdrs.add(new Salarié(rsE.getDouble(5),rsE.getInt(1), rsE.getString(2), rsE.getString(3), rsE.getDouble(4)));
				}
				return vdrs;
			} catch (SQLException ex) {
				System.out.println("Erreur SQL" + ex);
			}
			
			return null ;
		}*/
		
		
		

			public boolean AjouterEmp(Employes emp) {
				try {
					Statement st =connexion.getCon().createStatement();
					int res=st.executeUpdate("INSERT INTO Employes(Recrutement,Matricule,Nom,Email,salaire,Hsupp,PHsupp)VALUES('"+emp.getRecrutement()+"','"+emp.getMatricule()+"','"+emp.getNom()+"','"+emp.getEmail()+"','"+emp.getSalaire()+"','"+emp.getHsupp()+"','"+emp.getPHsupp()+"')");
					if(res!=0) {
						System.out.println("1 ligne ajouter dun employee");
						return true;
					}
				} catch (SQLException exp) {
					// TODO Auto-generated catch block
					exp.printStackTrace();
				}
				return false;
				}
			
			
			
			public boolean SupprimerEmp(Employes e) {
				try {
					PreparedStatement pst=connexion.getCon().prepareStatement("DELETE  FROM employes WHERE Matricule=?");
					pst.setLong(1, e.getMatricule());
					int res=pst.executeUpdate();
					if(res!=0) {
						System.out.println("Un employe supprimer");
						return true;
					}
				} catch (SQLException exp) {
					// TODO Auto-generated catch block
					exp.printStackTrace();
				}
				return false;
				
			}
	
			
			
			
			boolean ModifEmp (Employes  emp)
			{
		        try {
		        	PreparedStatement statement = connexion.getCon().prepareStatement("update Employes set nom ='Ibtihel'  where Matricule = 11");

		        		//statement.setString(3, e.getNomE());

		        		statement.executeUpdate();
						System.out.println("1 ligne Modifier dun salarié");

		                return true;
		        } catch (SQLException ex) {
		            System.out.println("Erreur");
		        }
		        return false;
		    }
			
	 	
			
			
			
			
			
			
			
			
			public boolean AjouterV(Vendeur s) {
				try {
					Statement st =connexion.getCon().createStatement();
					int res=st.executeUpdate("INSERT INTO Vendeur(Recrutement,Matricule,Nom,Email,salaire,vente,pourcentage)VALUES('"+s.getRecrutement()+"','"+s.getMatricule()+"','"+s.getNom()+"','"+s.getEmail()+"','"+s.getSalaire()+"','"+s.getVente()+"','"+s.getPourcentage()+"')");
					if(res!=0) {
						System.out.println("1 ajout dun vendeur");
						return true;
					}
				} catch (SQLException exp) {
					// TODO Auto-generated catch block
					exp.printStackTrace();
				}
				return false;
				}
			
			
		
			public boolean SupprimerV(Vendeur s) {
				try {
					PreparedStatement pst=connexion.getCon().prepareStatement("DELETE  FROM Vendeur WHERE Matricule=?");
					pst.setLong(1, s.getMatricule());
					int res=pst.executeUpdate();
					if(res!=0) {
						System.out.println("Un Vendeur supprimer");
						return true;
					}
				} catch (SQLException exp) {
					// TODO Auto-generated catch block
					exp.printStackTrace();
				}
				return false;
			}



			
			
			/*
			
			public boolean ModifS(Salarié s) {
		        try {
		        	PreparedStatement statement = connexion.getCon().prepareStatement("update Salarié set nom ='Ibtihel'  where Matricule = 1");

		        		//statement.setString(3, e.getNomE());

		        		statement.executeUpdate();
						System.out.println("1 ligne Modifier dun salarié");

		                return true;
		        } catch (SQLException ex) {
		            System.out.println("Erreur");
		        }
		        return false;
		    }*/
			
			
			
			
			public boolean AjouterS(Salarié emp) {
				try {
					Statement st =connexion.getCon().createStatement();
					int res=st.executeUpdate("INSERT INTO salarié(Recrutement,Matricule,Nom,Email,salaire,cat)VALUES('"+emp.getRecrutement()+"','"+emp.getMatricule()+"','"+emp.getNom()+"','"+emp.getEmail()+"','"+emp.getSalaire()+"','"+emp.getCat()+"')");
					if(res!=0) {
						System.out.println("1 ligne ajouter dun salarié");
						return true;
					}
				} catch (SQLException exp) {
					// TODO Auto-generated catch block
					exp.printStackTrace();
				}
				return false;
				}
			
			
			
			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

