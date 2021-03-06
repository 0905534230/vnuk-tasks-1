package vn.edu.vnuk.tasks.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sql5010InsertIntoTasks {
	
	private final Connection connection;
	private final String sqlQuery;
	
	public Sql5010InsertIntoTasks(Connection connection) {
		this.connection = connection;
		
		this.sqlQuery = "insert into tasks (description) values (?)";
	}
	
	public void run() throws SQLException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(">  Sql5010InsertIntoTasks started");
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sqlQuery);

            //	Replacing "?" through values
            statement.setString(1, "Homework");
//            statement.setBoolean(2, true);
//            statement.setDate(3, new java.sql.Date(
//                            Calendar.getInstance().getTimeInMillis()
//                    )
//            );

            // 	Executing statement
			statement.execute();
			statement.close();
	        System.out.println("   DATA successfully loaded in \'tasks\'");
		
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			System.out.println("<  Sql5010InsertIntoTasks ended");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
		}
			
	}
}
