package pl.maprzybysz.springboot2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import pl.maprzybysz.springboot2.model.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class VehicleControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    Flyway flyway;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnSelectedVehicle() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

        Vehicle[] vehicles = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Vehicle[].class);
        Assertions.assertEquals("Alfa Romeo", vehicles[0].getBrand());
    }
    @Test
    public void shouldReturn404WhenGet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles/10"))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andReturn();

        String actual = mvcResult.getResolvedException().getMessage();
        Assertions.assertEquals("No vehicle with such id: 10", actual);

    }
    @Test
    public void shouldReturnCorrectValue() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles/1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
    }

    @Test
    public void shouldAddNewElement() throws Exception{
        Vehicle vehicle = new Vehicle();
        vehicle.setColor("red");
        vehicle.setModel("model1");
        vehicle.setBrand("brand1");
        vehicle.setId(1L);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/vehicles")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(vehicle))
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();
    }

    @AfterEach
    public void get(){
        flyway.clean();
        flyway.migrate();
    }
}