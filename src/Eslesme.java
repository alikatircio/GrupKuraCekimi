import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Eslesme {

	String[] ulkeler = new String[]{"İspanya", "İngiltere", "Almanya", "Fransa","Portekiz","İtalya", "Rusya", "İsviçre", "Ukrayna", "Hollanda", "İskoçya","Türkiye","Polonya","Bulgaristan","Hırvatistan","Danimarka"};
	HashMap<String, List<String>> groups = new HashMap<>();
	String[] cikantakimlar = new String[]{};
	String[] cikangruplar = new String[]{};
	int n;
	String takim;
	torbaHelper torba1 = new torbaHelper();
	String ulke;
	boolean flag = false;
	int ulkesize = 0;
	char c;
	String grupNo;
	String g;
	String t;
	List<String> lst = new ArrayList<String>();
	
	
	
	public void grupOlustur(){
		
		ulke = getRandomUlke();
		while (!flag) {
			if(torba1.getTorba1().containsKey(ulke)){
				takim = getTeam();
				g = getGroup();
				System.out.println(g);
				createGroup(takim, g);
				for(Map.Entry<String, List <String>> entry : groups.entrySet()) {
					System.out.println(entry.getKey());
					List<String> takıms = entry.getValue();
					for (String string : takıms) {
						System.out.println(string);
					}
					
				}
				flag=true;
			}
			
			else
			{
				
				ulke = getRandomUlke();			
			}
		}
	}
	
public void createGroup(String takim, String group){
	lst.add(takim);
	groups.put(group, lst);
}

	public String getRandomUlke(){
		
		int random =0;
		Random rand = new Random();
		random = rand.nextInt(ulkeler.length);
		return ulkeler[random];
	}
	
	public String getGroup(){
		
		String gruplar = "ABCDEFGI";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		c = gruplar.charAt(rnd.nextInt(gruplar.length()));
		sb.append(c);
		grupNo = sb.toString();
		return grupNo;
	}
	
	public String getTeam(){
		
		ulkesize = torba1.getTorba1().get(ulke).length;
		Random rand = new Random();
		n = rand.nextInt(ulkesize)+0;
		t = torba1.getTorba1().get(ulke)[n];
		return t;
	}
}