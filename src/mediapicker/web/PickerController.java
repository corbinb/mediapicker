package mediapicker.web;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import mediapicker.domain.Media;
import mediapicker.service.MediaSourceManager;

public class PickerController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    private MediaSourceManager mediaManager;

	public static final int numberSongs = 3;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);

		List<Media> medias = new ArrayList<Media>();
		List<Media> theMedia = this.mediaManager.getAllMedia();
        for (int i = 0; i < numberSongs; i++) {
			medias.add(mediaManager.getRandomMedia());
		}
        myModel.put("media", medias);

        logger.info("Returning picker view with " + myModel.get("now"));
        logger.info("Returning picker view with " + myModel.get("media") + " songs.");

		// The view name is resolved using the viewResolver in MediaPicker-servlet.xml
        return new ModelAndView("mpicker", "model", myModel);
    }

    public void setMediaManager(MediaSourceManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	public MediaSourceManager getMediaManager() {
		return mediaManager;
	}
}