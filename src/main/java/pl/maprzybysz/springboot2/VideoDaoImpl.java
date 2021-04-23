package pl.maprzybysz.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VideoDaoImpl implements VideoDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VideoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public void saveVideo(Video video) {
        String sql = "INSERT INTO videos VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, video.getVideoId(), video.getTitle(), video.getUrl());
    }

    @Override
    public List<Video> findAll() {
        String sql = "SELECT * FROM videos";
        List<Video> videoList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> videoList.add(new Video(
                Long.parseLong(String.valueOf(element.get("video_id"))),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("url"))
        )));

        return videoList;
    }
    @Override
    public Video findById(long id) {
        String sql = "SELECT * FROM videos WHERE video_id = ?";

//       return jdbcTemplate.queryForObject(sql, new RowMapper<Video>() {
//           @Override
//           public Video mapRow(ResultSet resultSet, int i) throws SQLException {
//               return new Video(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
//           }
//       }, id);
//        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> new Video(resultSet.getLong(1),
//                resultSet.getString(2), resultSet.getString(3)), id);
        return jdbcTemplate.queryForObject(sql, (resultSet, rowName) -> new Video(resultSet.getLong("video_id"),
                resultSet.getString("title"), resultSet.getString("url")), id);
    }


    @Override
    public void updateVideo(Video newVideo) {
        String sql = "UPDATE videos SET videos.title=?, videos.url=? WHERE videos.video_id=?";
        jdbcTemplate.update(sql, newVideo.getTitle(), newVideo.getUrl(), newVideo.getVideoId());
    }

    @Override
    public void deleteVideo(long id) {
        String sql = "DELETE FROM videos WHERE video_id = ?";
        jdbcTemplate.update(sql, id);

    }
}
