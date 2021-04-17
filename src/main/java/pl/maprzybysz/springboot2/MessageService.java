package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private MessageSource messageSource;

    @Autowired
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
        String textEN = messageSource.getMessage("hello", new Object[]{"Mateusz", "Przybysz"}, Locale.ENGLISH);
        String textPL = messageSource.getMessage("hello", new Object[]{"Mateusz", "Przybysz"}, Locale.forLanguageTag(
                "pl"));
        System.out.println("EN: "+textEN);
        System.out.println("PL: "+textPL);
    }
}
