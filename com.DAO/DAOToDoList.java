import java.sql.ResultSet;


public class DAOToDoList {
	Conexion conexion;
	ResultSet result;
	public DAOToDoList() {
	 this.setConexion( new Conexion());
	 
	}
	
	void removeTask(String aTask){
		try {
			conexion.getStatement().executeUpdate("DELETE FROM TODOLIST WHERE TASK ='"+ aTask +"';;");
			System.out.println(aTask + ", task removed" );
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}

	void updateTask(String aOldTask ,String aNewTask ){
		
		try {
			System.out.println(aNewTask + " viejo "+ aOldTask );
			this.getConexion().getStatement().executeUpdate("UPDATE TODOLIST SET TASK='" + aNewTask +"' WHERE TASK='"+ aOldTask +"';");
			System.out.println(aOldTask + ", task update " );
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	void addTask( String aTask ){
		
		try {
			this.getConexion().getStatement().executeUpdate("INSERT INTO TODOLIST (TASK ) VALUES('" + aTask +"');");
			System.out.println(aTask + ", task added" );
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	// metodo para ver la base de datos en consola
	void showTable(){
		try {
			 this.setResult(this.getConexion().getStatement().executeQuery("select * from todolist"));
			while(this.getResult().next())
			{
				System.out.println(this.getResult().getString("TASK"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}

	
}
