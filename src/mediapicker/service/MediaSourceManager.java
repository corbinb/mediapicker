package mediapicker.service;

import java.io.Serializable;
import java.util.List;

import mediapicker.domain.Media;

public interface MediaSourceManager extends Serializable{

    public Media getRandomMedia();

    public List<Media> getAllMedia();

    public List<Media> getMedias();

}