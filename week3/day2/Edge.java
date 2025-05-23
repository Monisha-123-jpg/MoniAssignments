package week3.day2;

public class Edge extends Browser {
	public void takeSnap() {
		
		System.out.println("takesnap---subclass2 method1 ");
	}

	public void clearCookies() {
		System.out.println("clear cookies----subclss2 method2");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Edge e = new Edge();
		e.closeBrowser();
		e.navigateBack();
		e.openUrl();
		e.clearCookies();
		e.takeSnap();
	}

}
