import java.util.Random;

public class Eslesme {

	String[] ulkeler = new String[]{"İspanya", "İngiltere", "Almanya", "Fransa","Porktekiz","İtalya", "Rusya", "İsviçre", "Ukrayna", "Hollanda", "İskoçya","Türkiye","Polonya","Bulgaristan","Hırvatistan","Danimarka"};
	
	torbaHelper torba1 = new torbaHelper();
	
	public void grupEslesme(){
		
		torba1.torba1.get(0);
		System.out.println(torba1.getTorba1().get(getRandomUlke())[0]);
	}
	
	public String getRandomUlke(){
		
		int random =0;
		Random rand = new Random();
		random = rand.nextInt(ulkeler.length)+0;
		return ulkeler[random];
	}
}