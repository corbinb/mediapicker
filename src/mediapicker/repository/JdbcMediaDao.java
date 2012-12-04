package mediapicker.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import mediapicker.domain.Media;

public class JdbcMediaDao extends SimpleJdbcDaoSupport implements MediaDao {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    public List<Media> getMediaList() {
        logger.info("Getting media!");
        List<Media> media = getSimpleJdbcTemplate().query(
                "select id, name from medias",
                new MediaMapper());
        return media;
    }

    public void saveMedia(Media media) {
        logger.info("Saving media: " + media.getName());
        int count = getSimpleJdbcTemplate().update(
            "update medias set name = :name where id = :id",
            new MapSqlParameterSource().addValue("name", media.getName())
                .addValue("id", media.getId()));
        logger.info("Rows affected: " + count);
    }

    private static class MediaMapper implements ParameterizedRowMapper<Media> {

        public Media mapRow(ResultSet rs, int rowNum) throws SQLException {
            Media media = new Media();
            media.setId(rs.getInt("id"));
            media.setName(rs.getString("name"));
            return media;
        }

    }

}