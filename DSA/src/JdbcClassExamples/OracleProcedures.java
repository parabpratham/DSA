package JdbcClassExamples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class OracleProcedures {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		Connection conn = null;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521","hr","hr");
		String sql = "call count_emp(?,?)";
		CallableStatement callbale = conn.prepareCall(sql );
		callbale.setInt(1, 50);
		callbale.registerOutParameter(2, Types.INTEGER);
		callbale.execute();
		System.out.print("Total Employees are" + callbale.getInt(2));
		callbale.close();
		conn.close();
	}

}
