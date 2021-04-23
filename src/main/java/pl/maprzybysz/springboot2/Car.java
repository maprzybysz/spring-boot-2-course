package pl.maprzybysz.springboot2;

public class Car {
    private long id;
    private String mark;
    private String model;
    private String color;
    private int dateOfProduction;

    public Car() {
    }

    public Car(long id, String mark, String model, String color, int dateOfProduction) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.dateOfProduction = dateOfProduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(int dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", dateOfProduction=" + dateOfProduction +
                '}';
    }
}
