import java.sql.DriverManager;


public class Prueba {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DriverManager.getConnection(
		"jdbc:sqlserver://localhost:1433;database=localesnet;user=localesnetusr;password=pwd");
			System.out.println("Conexion Exitosa");
			
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
