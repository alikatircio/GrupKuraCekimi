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

	List<FootballTeam> cikanTakimlar = new ArrayList<FootballTeam>();
	List<Grup> cikanGruplar = new ArrayList<Grup>();
	private static List<Grup> staticGroup = new ArrayList<Grup>();
	List<Torba> torbalar = new ArrayList<Torba>();
	List<FootballTeam> listFootballTeam = new ArrayList<FootballTeam>();
	List<Torba> istenlenTorba = new ArrayList<>();
	List<GroupTeam> groupTeam = new ArrayList<>();
	List<Grup> randomGroup = new ArrayList<Grup>();
	List<Grup> sameCountryNotInGroup = new ArrayList<Grup>();
	FootballTeam team;
	Grup group;

	public void grupOlustur() throws ClassNotFoundException, SQLException {
		getTorba();
		getTeamToDB();
		getGroupToDB();
		for (int i = 1; i < 5; i++) {

			getistenilenTorba(i);
			getGroupsFromDB();
			randomGroup = new ArrayList<Grup>(staticGroup);
			while (istenlenTorba.size() > 0) {
				
				team = getTeam();
				group = notInSameCountryGroup(team);
				insertDB(group.getId(), team.getId());
				System.out.println(group.getName() + " " + team.getName());

			}
		}
	}

	public void insertDB(int groupId, int teamID) throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;
		try {

			con = DriverManager.getConnection(DBHelper.dbUrl, DBHelper.userName, DBHelper.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB bağlantısında hata oluştu.");
			e.printStackTrace();
		}
		String insert = "insert into groups values(?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, groupId);
			ps.setInt(2, teamID);
			ps.executeUpdate();
		con.close();
	}
	
	private List<GroupTeam> getGroupsFromDB() throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;
		try {

			con = DriverManager.getConnection(DBHelper.dbUrl, DBHelper.userName, DBHelper.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB bağlantısında hata oluştu.");
			e.printStackTrace();
		}
		PreparedStatement smt = con.prepareStatement(DBHelper.groups);
		ResultSet rs = smt.executeQuery();
		GroupTeam g = new GroupTeam();
		while (rs.next()) {

			g = new GroupTeam();
			g.setGroupId(rs.getInt(1));
			g.setTeamId(rs.getInt(2));
			groupTeam.add(g);
		}
		con.close();
		return groupTeam;

	}

	public ArrayList<Grup> getGroupToDB() throws ClassNotFoundException, SQLException {

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
			staticGroup.add(g);
		}
		con.close();
		return (ArrayList<Grup>) staticGroup;

	}
	
	private Grup notInSameCountryGroup(FootballTeam team){
		
		FootballTeam ft = null;
		GroupTeam grp = null;
		Grup grup = null;
		if (groupTeam.size() <= 0) {
			
			grup = getGroup();
		}
		else{
			for (int i = 0; i < groupTeam.size(); i++) {
				
				sameCountryNotInGroup = new ArrayList<Grup>(randomGroup);
				int tm = groupTeam.get(i).getTeamId();
				
				for (int j = 0; j < listFootballTeam.size(); j++) {
					
					if(listFootballTeam.get(j).getId()==tm){
						
						ft = listFootballTeam.get(j);
						grp = groupTeam.get(i);
						if(team.getCountryId() == ft.getCountryId()){
							
							for (int k = 0; k < sameCountryNotInGroup.size(); k++) {
								
								if(sameCountryNotInGroup.get(k).getId()==grp.getGroupId()){
									
									sameCountryNotInGroup.remove(k);
									Random rn = new Random();
									int n = rn.nextInt(sameCountryNotInGroup.size());
									Grup gr = new Grup();
									gr = sameCountryNotInGroup.get(n);
									removeIDFromRandom(gr.getId());
									grup = gr;
									break;
								}
							}
						}
						else {
							
							grup =  getGroup();
						}
					}
				}
				/*if(team.getCountryId() == ft.getCountryId()){
					
					for (int j = 0; j < sameCountryNotInGroup.size(); j++) {
						
						if(sameCountryNotInGroup.get(j).getId()==grp.getGroupId()){
							
							sameCountryNotInGroup.remove(j);
							Random rn = new Random();
							int n = rn.nextInt(sameCountryNotInGroup.size());
							Grup gr = new Grup();
							gr = sameCountryNotInGroup.get(n);
							removeIDFromRandom(gr.getId());
							grup = gr;
						}
					}
				}
				else {
					
					grup =  getGroup();
				}*/
			}
		}
		return grup;
	}

	public Grup getGroup() {
		
		
		Random rn = new Random();
		int n = rn.nextInt(randomGroup.size());
		Grup gr = new Grup();
		gr = randomGroup.get(n);
		randomGroup.remove(n);
		return gr;
	}

	private Grup removeIDFromRandom(int groupId) {

		for (int i = 0; i < randomGroup.size(); i++) {
			if (groupId == randomGroup.get(i).getId()) {
				randomGroup.remove(i);
				return randomGroup.get(i);
			}
		}
		return null;
	}

	public ArrayList<FootballTeam> getTeamToDB() throws ClassNotFoundException, SQLException {

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
						 * System.out.println("Takım id: " + ft.getId());
						 * System.out.print(" Takım adı: " + ft.getName());
						 * System.out.print(" Takımın ülke id: " +
						 * ft.getCountryId());
						 */
		}
		con.close();
		return (ArrayList<FootballTeam>) listFootballTeam;
	}

	public ArrayList<Torba> getistenilenTorba(int torbaId) {

		for (int i = 0; i < torbalar.size(); i++) {

			Torba tb = new Torba();
			if (torbalar.get(i).getId() == torbaId) {

				tb = new Torba();
				tb.setId(torbalar.get(i).getId());
				tb.setTeamId(torbalar.get(i).getTeamId());
				istenlenTorba.add(tb);
			}
		}
		return (ArrayList<Torba>) istenlenTorba;

	}

	public FootballTeam getTeam() {

		Random rn = new Random();
		int index = rn.nextInt(istenlenTorba.size());
		int teamId = (istenlenTorba.get(index).getTeamId());
		istenlenTorba.remove(index);
		return getFTFromId(teamId);
	}

	private FootballTeam getFTFromId(int teamId) {

		for (int i = 0; i < listFootballTeam.size(); i++) {
			if (teamId == listFootballTeam.get(i).getId()) {
				return listFootballTeam.get(i);
			}
		}
		return null;
	}

	public void getTorba() throws ClassNotFoundException, SQLException {

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
		con.close();
	}
}