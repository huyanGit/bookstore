package xcxxx.entity;

public class Book {
    /*
     * create table book
       (
              id varchar(40) primary key,
              name varchar(100) not null unique,
              author varchar(100) not null,
              price double not null,
              image varchar(100),
              description varchar(255),
              category_id varchar(40),
              constraint category_id_FK foreign key(category_id) references category(id)
       );
     */
    private String id;
    private String name;
    private String author;
    private double price;
    private String image;
    private String description;
    private String category_id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
