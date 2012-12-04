package mediapicker.repository;

import java.util.List;

import mediapicker.domain.Media;

public class InMemoryMediaDao implements MediaDao {

    private List<Media> mediaList;

    public InMemoryMediaDao(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void saveMedia(Media media) {
    }

}