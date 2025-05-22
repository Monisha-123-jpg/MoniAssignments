package week3.day2;

public class Chrome  extends Browser {
	
	public void openIncognito() {
		System.out.println("open in incognito ----baseclass1 method 1");
	}
	
	public void clearCache() {
		System.out.println("clear cache---baseclass 1 method 2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chrome  c = new Chrome();
		c.openUrl();
		c.closeBrowser();
		c.navigateBack();
		c.clearCache();
		c.openIncognito();
	}

}
