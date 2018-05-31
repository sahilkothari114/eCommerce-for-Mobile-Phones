package ECoMoPho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class JDBC {
	
	private static JDBC jdbc;
	
    private final static String ADRESS   = "jdbc:postgresql://127.0.0.1";
    private final static String DATABASE = "flipmart";
    private final static String USER     = "postgres";
    private final static String PASSWORD = "root";
    private final static String PORT     = "5432";
    // private final static String DRIVER   = "org.postgresql.Driver";
	
	private JDBC() {}
	
	public static JDBC getInstance() {
		if (jdbc==null) {
			jdbc =  new JDBC();
		}
		return jdbc;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			con=DriverManager.getConnection(ADRESS + ":" + PORT + "/" + DATABASE,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
