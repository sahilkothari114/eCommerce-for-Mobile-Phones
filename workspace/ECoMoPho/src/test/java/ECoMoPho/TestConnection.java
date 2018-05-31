package ECoMoPho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ECoMoPho.model.State;

public class TestConnection {

	public static void main(String[] args) throws SQLException  {
		
		State state = new State("rajasthan");
		insertState(state);
		
	}
	public static boolean insertState(State state) throws SQLException {
		PreparedStatement ps = null;
		Connection c = null ;
		int recordCounter=0;
		try {	JDBC jdbc = JDBC.getInstance();
				c = jdbc.getConnection();
				ps = c.prepareStatement("INSERT INTO public.state(\r\n" + 
						"	 state_name)\r\n" + 
						"	VALUES ( ?);");
				ps.setString(1, state.getStateName());
				recordCounter = ps.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            if (ps!=null){  
                ps.close();  
            }if(c!=null){  
                c.close();  
            }  
		}
        if (recordCounter>0){  
        	System.out.println(" Data has been inserted successfully");
        	return true;
        }else{  
            System.out.println("Data has not been inserted ");
            return false;
        }
	}
	
}
