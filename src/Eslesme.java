import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Helper.DBHelper;


public class Eslesme {

	List<String> cikantakimlar = new ArrayList<String>();
	List<String> cikangruplar = new ArrayList<String>();
	List<Grup> gruplar = new ArrayList<Grup>();
	List<Torba> torbalar = new ArrayList<Torba>();
	torbaHelper torba1 = new torbaHelper();
	String ulke;
	boolean flag = false;
	int ulkesize = 0;
	String group;
	List<String> lst = new ArrayList<String>();
    List<FootballTeam> listFootballTeam = new ArrayList<FootballTeam>();
	List<Torba> istenlenTorba = new ArrayList<>();
	int teamId = 0;
	int rindex = 0;
	
	
	public void grupOlustur() throws ClassNotFoundException, SQLException{
		getTorba();
		getTeamToDB();
		
			for (int i = 1 ; i < 5; i++) {
			
			getistenilenTorba(i);
			getGroupToDB();
			while (istenlenTorba.size()>0) {
				
				String team = getTeam().getName();
				System.out.println(getGroup() + " " + team);
			}
		}
	
		//System.out.println(teamId + " " +torbaTeamId);
		/*
		ulke = getRandomUlke();
		while (!flag) {
			//for (int i = 0; i < torba1.getTorba1().size(); i++) {
				
				if(torba1.getTorba1().containsKey(ulke)){
					
					takim = getTeam();
					g = getGroup();
					createGroup(takim, g);
					for(Map.Entry<String, List <String>> entry : groups.entrySet()) {
						
						System.out.println(entry.getKey());
						List<String> takıms = entry.getValue();
						for (String string : takıms) {
							System.out.println(string);
						}
						for (String string : cikangruplar) {
							System.out.println(string);
						}
					}
					flag=true;
				}
				
				else{
					
					ulke = getRandomUlke();			
				}
			//}
		}*/         

         /*
		 String insert = "select * from teams";  
	     PreparedStatement ps = con.prepareStatement(insert);
	     for (int i = 0; i < team.size(); i++) {
	    	 
	    	 ps.setInt(1, team.get(i).getId());
	    	 ps.setString(2, team.get(i).getName());
	    	 ps.setInt(3, team.get(i).getCountry_ID());
	    	 ps.executeUpdate();
		}
	     con.close();
		*/
	}
	/*
	public void teamCreate(){
		
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
	}
	
	public void insertDB(ArrayList<FootballTeam> team) throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;		 
		 try {
			
			 con = DriverManager.getConnection(DBHelper.dbUrl, DBHelper.userName, DBHelper.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB bağlantısında hata oluştu.");
			e.printStackTrace();
		}
		 String insert = "insert into teams values(?,?,?)";  
	     PreparedStatement ps = con.prepareStatement(insert);
	     for (int i = 0; i < team.size(); i++) {
	    	 
	    	 ps.setInt(1, team.get(i).getId());
	    	 ps.setString(2, team.get(i).getName());
	    	 ps.setInt(3, team.get(i).getCountry_ID());
	    	 ps.executeUpdate();
		}
	     con.close();
	}	
	*/

	public ArrayList<Grup> getGroupToDB() throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;		 
		 try {
			
			 con = DriverManager.getConnection(DBHelper.dbUrl, DBHelper.userName, DBHelper.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB bağlantısında hata oluştu.");
			e.printStackTrace();
		}
		 
		 PreparedStatement smt = con.prepareStatement(DBHelper.gruplar);
         ResultSet rs = smt.executeQuery();
         Grup g = new Grup();
         while (rs.next()) {
        	 
			g = new Grup();
			g.setId(rs.getInt(1));
			g.setName(rs.getString(2));
			gruplar.add(g);
		}
         return (ArrayList<Grup>) gruplar;
	} 
	
	public String getGroup(){
		
		Random rn = new Random();
        int n = rn.nextInt(gruplar.size() + 0);
        String group = gruplar.get(n).getName();
        gruplar.remove(n);
        //System.out.println(n);
        //System.out.println(gruplar.size());
        return group;
	}
	
	public ArrayList<FootballTeam> getTeamToDB() throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;		 
		 try {
			
			 con = DriverManager.getConnection(DBHelper.dbUrl, DBHelper.userName, DBHelper.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB bağlantısında hata oluştu.");
			e.printStackTrace();
		}
		 
        	 PreparedStatement smt = con.prepareStatement(DBHelper.teams);
             ResultSet rs = smt.executeQuery();
	         FootballTeam ft = new FootballTeam();
	         while (rs.next()) {
	        	 
	        	 ft = new FootballTeam();
	        	 ft.setId(rs.getInt(1));
	        	 ft.setName(rs.getString(2));
	        	 ft.setCountryId(rs.getInt(3));
	        	 listFootballTeam.add(ft);/*
	        	 System.out.println("Takım id: " + ft.getId());
	    		 System.out.print(" Takım adı: " + ft.getName());
	    		 System.out.print(" Takımın ülke id: " + ft.getCountryId());*/
	         }	          
         return (ArrayList<FootballTeam>) listFootballTeam;
	}
	
	
	public ArrayList<Torba> getistenilenTorba(int torbaId){
		
		for (int i = 0; i < torbalar.size(); i++) {
			
			Torba tb = new Torba();
			if(torbalar.get(i).getId() == torbaId){
				
				tb = new Torba();
				tb.setId(torbalar.get(i).getId());
				tb.setTeamId(torbalar.get(i).getTeamId());
				istenlenTorba.add(tb);
			}
		}
		return (ArrayList<Torba>) istenlenTorba;
		
	}
	
	public FootballTeam getTeam(){
		
		Random rn = new Random();
        int index = rn.nextInt(istenlenTorba.size());
        teamId = (istenlenTorba.get(index).getTeamId());
        istenlenTorba.remove(index);
        return getFTFromId(teamId);
	}
	
	private FootballTeam getFTFromId(int teamId){
		
		for (int i = 0; i < listFootballTeam.size(); i++) {
			if (teamId == listFootballTeam.get(i).getId()) {
				return listFootballTeam.get(i);	
			}
		}
		return null;
	}
	
	
	public void getTorba() throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;		 
		 try {
			
			 con = DriverManager.getConnection(DBHelper.dbUrl, DBHelper.userName, DBHelper.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB bağlantısında hata oluştu.");
			e.printStackTrace();
		}
		 
		 PreparedStatement smt = con.prepareStatement(DBHelper.torbalar);
         ResultSet rs = smt.executeQuery();
         Torba trb = new Torba();
         while (rs.next()) {
        	 
        	trb = new Torba();
			trb.setId(rs.getInt(1));
			trb.setTeamId(rs.getInt(2));
			torbalar.add(trb);
		}
	}
}