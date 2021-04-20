package pl.maprzybysz.springboot2;


import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car extends RepresentationModel<Car> {
    @Min(1)
    private Long id;
    @NotNull(message = "mark cannot be null")
    @Size(min = 2)
    private String mark;
    @Size(min = 2)
    @NotNull(message = "model cannot be null")
    @Size(min = 2)
    private String model;
    @NotNull(message = "color cannot be null")
    @Size(min = 2)
    private String color;

    public Car() {
    }

    public Car(Long id, String mark, String model, String color) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
