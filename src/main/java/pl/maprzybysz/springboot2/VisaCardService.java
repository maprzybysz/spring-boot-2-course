package pl.maprzybysz.springboot2;

import org.springframework.stereotype.Service;

@Service
public class VisaCardService implements Card{
    public VisaCardService() {}

    @Override
    public String getInfo() {
        return "VisaCardService";
    }
}
