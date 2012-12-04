package mediapicker.service;

import java.util.List;

import junit.framework.TestCase;

import mediapicker.domain.Media;
import mediapicker.repository.InMemoryMediaDao;
import mediapicker.repository.MediaDao;

import java.util.ArrayList;

public class BasicMediaPickerManagerTests extends TestCase {

    private BasicMediaSourceManager mediaManager;
    private List<Media> medias;

    protected void setUp() throws Exception {
        mediaManager = new BasicMediaSourceManager();

		medias = new ArrayList<Media>();

		// stub up a list of media
		Media media = new Media();
		media.setName("song 0");
		medias.add(media);

		media = new Media();
		media.setName("song 1");
		medias.add(media);

		//mediaManager.setMedias(medias);
		MediaDao mediaDao = new InMemoryMediaDao(medias);
        mediaManager.setMediaDao(mediaDao);
    }

    public void testGetAllMediaWithNoMedia() {
        mediaManager = new BasicMediaSourceManager();
        mediaManager.setMediaDao(new InMemoryMediaDao(null));
        assertNull(mediaManager.getAllMedia());
    }

    public void testGetAllMedia() {
		List<Media> medias = mediaManager.getAllMedia();
		assertNotNull(medias);
		assertEquals(2, mediaManager.getAllMedia().size());

		Media media = medias.get(0);
		assertEquals("song 0", media.getName());

		media = medias.get(1);
		assertEquals("song 1", media.getName());
	}

    public void testGetRandomMedia() {
		Media media = mediaManager.getRandomMedia();
		assertTrue(media.getName() == "song 0" || media.getName() == "song 1");
	}
}