package model;

public class Book {
	private int id;
	private String name;
	private String author;
	private String imgUrl;
	private String publish;
	private float price;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Book(int id, String name, String author, String imgUrl, String publish, float price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.imgUrl = imgUrl;
		this.publish = publish;
		this.price = price;
	}
	public Book(int id, String name, String author, String publish, float price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.price = price;
	}
	public Book(String name, String author, String imgUrl, String publish, float price) {
		super();
		this.name = name;
		this.author = author;
		this.imgUrl = imgUrl;
		this.publish = publish;
		this.price = price;
	}
	public Book() {
		super();
	}
	

}
