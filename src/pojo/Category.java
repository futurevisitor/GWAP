package pojo;

public class Category {
	private String categoryid;
	private String name;
	private String description;
	private String productid;
	private String basePrice;
	private String author;
	private String publish;	
	private String pages;
	private String images;
	private String catename;
	public String getCategoryID(){
		return categoryid;
	}
	public void setCategoryID(String categoryid){
		this.categoryid=categoryid;
	}
	public String getname(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getcatename(){
		return catename;
	}
	public void setcateName(String name){
		this.catename=name;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description=description;
		
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
}
