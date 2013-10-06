
public abstract class Actor {
	 
	String image;
	String location;
	
	//TODO: Change type of image to "ImageIcon" and type of location to "Tile"
	public Actor(String image, String location)
	{
		this.image = image;
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	//TODO: Change type of image to "ImageIcon" and type of location to "Tile"
	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}
	
	//TODO: Change type of image to "ImageIcon" and type of location to "Tile"
	public void setLocation(String location) {
		this.location = location;
	}
	
}
