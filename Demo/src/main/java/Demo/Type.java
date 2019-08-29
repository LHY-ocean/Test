package Demo;

public class Type implements TypeInterface {
	private int id;
	private String name;
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		int a = Integer.valueOf("s");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
