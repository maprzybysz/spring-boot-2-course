package pl.maprzybysz.springboot2.gui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.maprzybysz.springboot2.manager.CarManager;
import pl.maprzybysz.springboot2.model.Car;

@Route("show-car")
public class CarShowGui extends VerticalLayout {

    private CarManager carManager;

    @Autowired
    public CarShowGui(CarManager carManager){
        this.carManager = carManager;

        Grid<Car> grid = new Grid<>(Car.class);
        grid.setItems(carManager.getCarList());

        add(grid);
    }

}
