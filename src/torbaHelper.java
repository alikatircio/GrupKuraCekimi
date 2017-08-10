
import java.util.HashMap;

public class torbaHelper {

	HashMap<String, String[]> torba1 =new HashMap<>();
	HashMap<String, String[]> torba2 =new HashMap<>();
	HashMap<String, String[]> torba3 =new HashMap<>();
	HashMap<String, String[]> torba4 =new HashMap<>();
	String[][] torba11 = new String[6][1];
	
	
	public torbaHelper(){
		
		torba11[0][0]= "";
		
		torba1.put("İspanya", new String[]{"Real Madrid","Barcelona"});
		torba1.put("İngiltere", new String[]{"Leicester City"});
		torba1.put("Almanya", new String[]{"Bayern Munih"});
		torba1.put("İtalya", new String[]{"Juventus"});
		torba1.put("Portekiz", new String[]{"Benfica"});
		torba1.put("Fransa", new String[]{"Paris Saint-Germain"});
		torba1.put("Rusya", new String[]{"CSKA Moskova"});
		
		torba2.put("İspanya", new String[]{"Atletico Madrid"});
		torba2.put("Almanya", new String[]{"Borussia Dortmund", "Bayern Leverkusen"});
		torba2.put("İngiltere", new String[]{"Arsenal","Manchester City"});
		torba2.put("İspanya", new String[]{"Sevilla"});
		torba2.put("Portekiz", new String[]{"Porto"});
		torba2.put("İtalya", new String[]{"Napoli"});
		
		torba3.put("İsviçre", new String[]{"Basel"});
		torba3.put("İngiltere", new String[]{"Tottenham"});
		torba3.put("Ukrayna", new String[]{"Dinamo Zagreb"});
		torba3.put("Fransa", new String[]{"Lyon"});
		torba3.put("Hollanda", new String[]{"PSV Eindhoven"});
		torba3.put("Portekiz", new String[]{"Sporting Lizbon"});
		torba3.put("Belçika", new String[]{"Club Brugge"});
		torba3.put("Almanya", new String[]{"Borussia Mönchengladbach"});
		
		torba4.put("İskoçya", new String[]{"Celtic"});
		torba4.put("Fransa", new String[]{"Monoca"});
		torba4.put("Türkiye", new String[]{"Beşiktaş"});
		torba4.put("Polonya", new String[]{"Legia Varşova"});
		torba4.put("Bulgaristan", new String[]{"Ludogorets"});
		torba4.put("Hırvatistan", new String[]{"Dinamo Zagreb"});
		torba4.put("Danimarka", new String[]{"Kopenhag"});
		torba4.put("Rusya", new String[]{"Rostov"});
	}
	
	public String[][] getTorba11() {
		return torba11;
	}

	public void setTorba11(String[][] torba11) {
		this.torba11 = torba11;
	}

	public String ulkeControl (String ulke){
		
		for (int i = 0; i < torba1.size(); i++) {
			
			if(ulke.equals(torba1.get(i)[0])){
				System.out.println(ulke);
				return ulke;
			}
		}
		return "bulunamadı";
	}

	public HashMap<String, String[]> getTorba2() {
		return torba2;
	}

	public void setTorba2(HashMap<String, String[]> torba2) {
		this.torba2 = torba2;
	}

	public HashMap<String, String[]> getTorba3() {
		return torba3;
	}

	public void setTorba3(HashMap<String, String[]> torba3) {
		this.torba3 = torba3;
	}

	public HashMap<String, String[]> getTorba4() {
		return torba4;
	}

	public void setTorba4(HashMap<String, String[]> torba4) {
		this.torba4 = torba4;
	}

	public HashMap<String, String[]> getTorba1() {
		
		return torba1;
	}

	public void setTorba1(HashMap<String, String[]> torba1) {
		this.torba1 = torba1;
	}
	
	
}
