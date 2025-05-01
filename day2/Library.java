package week2.day2;

public class Library {
	  String addBook(String bookTitle) {
		  System.out.println("Book added successfully");
		return bookTitle;
		  
	  }
	  void issueBook() {
		  System.out.println("Book issued successfully");
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library l = new Library();
	    String bookTitle =	l.addBook("Fiction");
	    System.out.println("Book title is "+bookTitle);
	    l.issueBook();

	}

}
