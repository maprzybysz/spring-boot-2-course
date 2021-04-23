package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private VideoDao videoDao;

    @Autowired
    public Start(VideoDao videoDao) {
        this.videoDao = videoDao;


        videoDao.updateVideo(new Video(1L, "New video", "New url"));

    }


}
