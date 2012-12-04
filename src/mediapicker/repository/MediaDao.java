package mediapicker.repository;

import java.util.List;

import mediapicker.domain.Media;

public interface MediaDao {

    public List<Media> getMediaList();

    public void saveMedia(Media media);

}