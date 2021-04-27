package pl.maprzybysz.springboot2.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.maprzybysz.springboot2.model.Vehicle;
import pl.maprzybysz.springboot2.repository.VehicleRepository;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@SpringBootTest
class VehicleServiceImplTest {

    private VehicleRepository vehicleRepository = mock(VehicleRepository.class);
    private VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);

    @BeforeEach
    private void setUpRepository() {

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setColor("red");
        vehicle1.setModel("model1");
        vehicle1.setBrand("brand1");
        vehicle1.setId(1L);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setColor("blue");
        vehicle2.setModel("model2");
        vehicle2.setBrand("brand2");
        vehicle2.setId(2L);
        Iterable<Vehicle> all = Arrays.asList(vehicle1, vehicle2);

        doReturn(all).when(vehicleRepository).findAll();
    }

    @Test
    //@DisplayName("Should Return Selected Color")
    public void shouldReturnSelectedColor(){
        //when
        List<Vehicle> actual = vehicleService.findAllVehiclesByColor("red");

        Assertions.assertEquals("red", actual.get(0).getColor());
    }

    @Test
    public void shouldNoReturnAnyColor(){
        //when
        List<Vehicle> actual = vehicleService.findAllVehiclesByColor("black");

        assertTrue(actual.isEmpty());
    }




}