package pl.maprzybysz.springboot2;

public class Customer {
    private String name;
    private String idCard;

    public Customer() {
    }

    public Customer(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
