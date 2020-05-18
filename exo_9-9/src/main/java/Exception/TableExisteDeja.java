package Exception;

public class TableExisteDeja extends Exception{

	public TableExisteDeja(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.out.println(message);
	}

}
