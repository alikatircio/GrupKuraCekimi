import java.util.Random;

public class Eslesme {

	String[] ulkeler = new String[]{"İspanya", "İngiltere", "Almanya", "Fransa","Portekiz","İtalya", "Rusya", "İsviçre", "Ukrayna", "Hollanda", "İskoçya","Türkiye","Polonya","Bulgaristan","Hırvatistan","Danimarka"};
	String[] grupA = new String[]{};
	String[] grupB = new String[]{};
	String[] grupC = new String[]{};
	String[] grupD = new String[]{};
	String[] grupE = new String[]{};
	String[] grupF = new String[]{};
	String[] grupG = new String[]{};
	String[] grupI = new String[]{};
	int n;
	String takim;
	torbaHelper torba1 = new torbaHelper();
	String ulke;
	
	public void grupOlustur(){
		
		Random rand = new Random();
		n = rand.nextInt(2)+0;
		System.out.println(n);
		ulke = getRandomUlke();
		System.out.println(ulke);
		
		System.out.println(torba1.getTorba1().get(ulke));
		takim = torba1.getTorba1().get(ulke)[n];
		System.out.println(takim);
		
	}
	
	public String getRandomUlke(){
		
		int random =0;
		Random rand = new Random();
		random = rand.nextInt(ulkeler.length);
		return ulkeler[random];
	}
}