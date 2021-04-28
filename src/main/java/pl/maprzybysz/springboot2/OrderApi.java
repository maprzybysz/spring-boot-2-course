package pl.maprzybysz.springboot2;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    private ModelMapper modelMapper;
    private List<OrderDTO> orderDTOList;

    @Autowired
    public OrderApi(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.orderDTOList = new ArrayList<>();
        Order order1 = new Order(
                new Customer("Anna Nowak", "CARD123"),
                new Address("Jana Pawła II", "Warszawa"));
        Order order2 = new Order(
                new Customer("Tadeusz Norek", "CARD456"),
                new Address("Rynek", "Kraków"));

        orderDTOList.add(modelMapper.map(order1, OrderDTO.class));
        orderDTOList.add(modelMapper.map(order2, OrderDTO.class));
    }


           
    @GetMapping
    public List<OrderDTO> getOrderList(){
        return orderDTOList;
    }

}
