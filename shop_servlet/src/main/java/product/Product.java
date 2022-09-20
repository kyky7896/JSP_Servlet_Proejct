package product;

public class Product {
    private int num;
    private String name;
    private String info;
    private int price;
    private int amount;
    private String seller;
    private String img1;


    public Product() {
    }

    public Product(int num, String name, String info, int price, int amount, String seller, String img1) {
        this.num = num;
        this.name = name;
        this.info = info;
        this.price = price;
        this.amount = amount;
        this.seller = seller;
        this.img1 = img1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", seller='" + seller + '\'' +
                ", img1='" + img1 + '\'' +
                '}';
    }
}
