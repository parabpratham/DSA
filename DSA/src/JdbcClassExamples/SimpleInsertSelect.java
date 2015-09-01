package JdbcClassExamples;


import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;



public class SimpleInsertSelect {

	/**
	 * @param args
	 */
	public static void main (String[] args) throws Exception {
		
		Connection conn = null;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521","hr","hr");
		
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Insert 1 or search 2")); 
		switch(choice)
		{
			case 1:insert(conn);
					break;
			case 2:
			int c = Integer.parseInt(JOptionPane.showInputDialog("Hire_Date 1 or EmpId 2"));	
				switch(c)
				{	case 1: 
					search(conn,JOptionPane.showInputDialog("Enter date(yyyy-mm-dd)"));
					break;
					default:
						search(conn);
				}
			break;
		}
		//conn.close();
	}

	private static void search(Connection conn) throws SQLException {
		
		int empId = Integer.parseInt(JOptionPane.showInputDialog("Enter Empid"));
		search(conn,empId);

	}
	

	private static void search(Connection conn,int empId) throws SQLException {
		
		
		PreparedStatement sqlState = conn.prepareStatement("select first_name,last_name,salary,job_id,manager_id,employee_id from employees where employee_id=?");
		sqlState.setInt(1,empId);
//		Statement sqlState = conn.createStatement();
//		ResultSet rs = sqlState.executeQuery("select first_name,last_name,salary,job_id,manager_id from employees where salary>12000");
		ResultSet rs = sqlState.executeQuery();
		String first_name,last_name,salary,job_id,manager_id;
		if(!rs.next())
		{ System.out.println("No match found");}
		
		else
		{
			do
			{
				System.out.print(" Employee ID:"+rs.getString(6));
				System.out.print(" First name:"+rs.getString(1));
				System.out.print(" Last name:"+rs.getString(2));
				System.out.print(" Salary:"+rs.getString(3));
				System.out.print(" JOB ID:"+rs.getString(4));
				System.out.print(" Manager ID:"+rs.getString(5));
				System.out.println();
				
			}while(rs.next());
		}
		rs.close();
		sqlState.close();
		conn.close();
	}

	private static void insert(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String first_name,last_name,salary,job_id,manager_id;
		
		String sql="select max(employee_id)+1 from employees";
		Statement sqlEmpState = conn.createStatement();
		ResultSet rs = sqlEmpState.executeQuery(sql);
		rs.next();
		int empId = rs.getInt(1);
		//sudhir,mane,12000,it_prog,100
//		first_name = "Sudhir";
//		last_name = "mane";
//		salary ="12000";
//		job_id = "IT_PROG";
//		manager_id = "100";
		
		first_name = JOptionPane.showInputDialog("Enter Fname");
		last_name = JOptionPane.showInputDialog("Enter Lname");
		salary = JOptionPane.showInputDialog("Enter salary");
		job_id = JOptionPane.showInputDialog("Enter job id");
		manager_id = JOptionPane.showInputDialog("Enter manager id");
		
		
		PreparedStatement sqlState = conn.prepareStatement("insert into employees(employee_id,first_name,last_name,salary,job_id,manager_id) values (?,?,?,?,?,?)");
			sqlState.setInt(1,empId);
			sqlState.setString(2,first_name);
			sqlState.setString(3,last_name);
			sqlState.setString(4,salary);
			sqlState.setString(5,job_id);
			sqlState.setString(6,manager_id);
		if(sqlState.executeUpdate() == 1)
		{
			System.out.print("Succesfully inserted");
			search(conn,empId);
		}
		else
		{
			System.out.print("Not inserted");
			
		}
		conn.close();
		
	}
	
	
	public static void search(Connection conn,String date) throws SQLException
	{
		Date dat = Date.valueOf(date);
		PreparedStatement sqlState = conn.prepareStatement("select first_name,last_name,salary,job_id,manager_id,employee_id,hire_date from employees where hire_date<?");
		sqlState.setDate(1, dat);
//		Statement sqlState = conn.createStatement();
//		ResultSet rs = sqlState.executeQuery("select first_name,last_name,salary,job_id,manager_id from employees where salary>12000");
		ResultSet rs = sqlState.executeQuery();
		String first_name,last_name,salary,job_id,manager_id;
		ResultSetMetaData rsm = rs.getMetaData();
		for(int ic=1;ic<rsm.getColumnCount();ic++)
		{
			System.out.print(rsm.getColumnClassName(ic)+"\t");
		}
		if(!rs.next())
		{ System.out.println("No match found");}
		
		else
		{
			do
			{
				System.out.print(" Employee ID:"+rs.getString(6));
				System.out.print(" First name:"+rs.getString(1));
				System.out.print(" Last name:"+rs.getString(2));
				System.out.print(" Salary:"+rs.getString(3));
				System.out.print(" JOB ID:"+rs.getString(4));
				System.out.print(" Manager ID:"+rs.getString(5));
				System.out.print(" Hire date:"+rs.getDate(7).toString());
				System.out.println();
				
			}while(rs.next());
		}
		rs.close();
		sqlState.close();
		conn.close();
	}
	
	

}