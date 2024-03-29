package Model;

import javax.servlet.http.Part;



public class Category {
    private int id;
    private String name;
    private String image;
    private String description;
    
	public Category (int id, String name, String image, String description) {
		super();
		this.id = id;
		this.name = name;
		this.image=image;
		this.description = description;
	}
	public Category (String name, String  image, String description) {
		super();
		this.name = name;
		this.image=image;
		this.description = description;
	}
	
	public Category() {
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
		return "image [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
    
}
