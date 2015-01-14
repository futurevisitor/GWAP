package dbhelper;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;



public class sql {

	public static void main(String[] args) throws SQLException {

		String sql = "select * from users ";
		ResultSet rs = DBHelper.executeQuery(sql);
		while (rs.next())
		{
			String userid = rs.getString("userid") ;
			String password = rs.getString("password");
			System.out.printf(userid +  password);	
		}
		DBHelper.free(rs);
		
	    String sql2="Select * From users Where userid=?";

	    Object[] obj = new Object[]{"admin"};


	    ResultSet rs2 = DBHelper.executeQuery(sql2,obj);
	    while(rs2.next()){

            System.out.println("Ñ§ºÅ£º"+rs2.getString("password"));

        }


        DBHelper.free(rs2);

	    

	}

}
