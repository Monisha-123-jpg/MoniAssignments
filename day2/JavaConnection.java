package week3.day2;

public class JavaConnection extends MySqlConnection implements  DatabaseConnection {

	

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("provide connection");
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println(" disconnect database connection");
		
	}

	@Override
	public void executeUpdate() {
		// TODO Auto-generated method stub
		System.out.println("execute updates");
		
	}
	public static void main(String[] args) {
		JavaConnection jC = new JavaConnection();
		jC.connect();
		jC.disconnect();
		jC.executeUpdate();
		jC.executeQuery();
		// TODO Auto-generated method stub

	}

}
