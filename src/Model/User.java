package Model;

public class User
{
	private int id;
	private String name;
	private String email;
	private String city;
	private String pass;
	
	public User(int id, String name, String email, String city, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.pass = pass;
	}

	public User(String name, String email, String city, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.pass = pass;
	}

	public User(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public User() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
		  
}	