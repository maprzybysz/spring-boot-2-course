package pl.maprzybysz.springboot2.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.maprzybysz.springboot2.manager.CarManager;
import pl.maprzybysz.springboot2.model.Car;

@Route("add-car")
public class CarAdderGui extends VerticalLayout {

    private CarManager carManager;

    @Autowired
    public CarAdderGui(CarManager carManager) {
        this.carManager = carManager;

        TextField textFieldMark = new TextField("Mark");
        TextField textFieldModel = new TextField("Model");
        Button buttonAdd = new Button("Add");

        buttonAdd.addClickListener(buttonClickEvent -> {
            Car car = new Car(textFieldMark.getValue(), textFieldModel.getValue());
            carManager.addCar(car);
        });



        add(textFieldMark, textFieldModel, buttonAdd);
    }
}
