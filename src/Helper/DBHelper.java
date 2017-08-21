package Helper;

public class DBHelper {

	public static String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static String userName = "ALI";
	public static String password = "a.1993.1907";
	public static String teams = "select * from teams order by id asc";
	public static String gruplar = "select * from grup";
	public static String torbalar = "select * from torba order by team_id asc";
	//public static String teams = "select tm.* from TORBA trb, teams tm where TRB.TEAM_ID =TM.ID and trb.id=?";
}
