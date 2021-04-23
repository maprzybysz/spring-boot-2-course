package pl.maprzybysz.springboot2;

import java.util.List;

public interface VideoDao {

    void saveVideo(Video video);
    List<Video> findAll();
    void updateVideo(Video video);
    void deleteVideo();
}
