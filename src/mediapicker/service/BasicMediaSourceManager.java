package mediapicker.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import mediapicker.domain.Media;
import mediapicker.repository.MediaDao;

public class BasicMediaSourceManager implements MediaSourceManager {

	//private List<Media> medias;
	private MediaDao mediaDao;

	public void setMediaDao(MediaDao mediaDao) {
		this.mediaDao = mediaDao;
	}

    public List<Media> getAllMedia() {
        return mediaDao.getMediaList();
    }

    public List<Media> getMedias() {
		return getAllMedia();
	}

    public void addMedia(Media media) {
        mediaDao.saveMedia(media);
    }

    public Media getRandomMedia() {
		int size = mediaDao.getMediaList().size();
        Media media = null;
        if (size > 0) {
			Random generator = new Random();
			int random = generator.nextInt(size); // returns in range [0,size)
			media = mediaDao.getMediaList().get(random);
		}
		return media;
    }
}