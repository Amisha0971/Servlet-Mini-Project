package Model;

public class products {
	

	private int id;
    private String name;
    private String price;
    private String image;
    private String description;
 
    	public products(int id, String name, String  price,String image, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
	}

	public products( String name,String price,String image, String description) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
	}

	public products(int id, String name, String price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	
	public products() {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String  price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	@Override
	public String toString() {
		return "products [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", description="
				+ description + "]";
	}
	
    
}
