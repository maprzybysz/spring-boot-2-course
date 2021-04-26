package pl.maprzybysz.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maprzybysz.springboot2.model.WeatherWrapper;

public interface WeatherWrapperRepo extends JpaRepository<WeatherWrapper, Long> {
}
