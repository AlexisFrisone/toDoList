import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conexion {
	
	Connection conexion;
	Statement statement;
	String path = "C:/Users/u574681/Desktop/Facu/toDoList-master/toDoList/toDoListProyect/";
	
	public Conexion() {
		
		try {
			Class.forName("org.h2.Driver");
			//user vacio 
			//pass vacia
			conexion = DriverManager.getConnection("jdbc:h2:"+ path +"lib/dataBase", "" , "");
			statement= conexion.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Connection getConexion() {
		return conexion;
	}

	public Statement getStatement() {
		return statement;
	}

	public String getPath() {
		return path;
	}
	
}
