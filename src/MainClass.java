import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*List<FootballTeam> listFootballTeam = new ArrayList<FootballTeam>();

		
		FootballTeam ft = new FootballTeam();
		 ft.setId(1);
		 ft.setName("Barcelona");
		 ft.setCountry_ID(1);
		 listFootballTeam.add(ft);
		 ft = new FootballTeam();
		 ft.setId(2);
		 ft.setName("Real Madrid");
		 ft.setCountry_ID(1);
		 listFootballTeam.add(ft);
		 
		 for (int i = 0; i < listFootballTeam.size(); i++) {
			 System.out.println("Takım id si" + listFootballTeam.get(i).getId() + 
					 " Takımın adı " + listFootballTeam.get(i).getName() + 
					 " Takımın ülke id " + listFootballTeam.get(i).getCountry_ID());
			
		}*/
		// TODO Auto-generated method stub
		 Eslesme eslesme = new Eslesme();
		eslesme.grupOlustur();
		// eslesme.insertDB((ArrayList<FootballTeam>) listFootballTeam);		 
	}
}
