package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CardServiceMain {

    private Card card;

    @Autowired
    public CardServiceMain(@Qualifier("visaCardService") Card card) {
        this.card = card;
        String info = card.getInfo();
        System.out.println(info);
    }
}
