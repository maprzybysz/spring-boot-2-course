package pl.maprzybysz.springboot2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import pl.maprzybysz.springboot2.model.Vehicle;

import java.util.Objects;
import java.util.Vector;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class VehicleControllerE2ETest {

    @LocalServerPort
   private int port;

    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    public void shouldReturnElementsByColor(){
        ResponseEntity<Vehicle[]> actual = testRestTemplate.exchange("http://localhost:" + port + "/api/vehicles" +
                        "/filter?color=red",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Vehicle[].class);

        Assertions.assertEquals("Alfa Romeo", Objects.requireNonNull(actual.getBody())[0].getBrand());

    }
}