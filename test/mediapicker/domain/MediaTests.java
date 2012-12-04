package mediapicker.domain;

import junit.framework.TestCase;

import mediapicker.domain.Media;

public class MediaTests extends TestCase {

    private Media media;

    protected void setUp() throws Exception {
        media = new Media();
    }

    public void testSetAndGetName() {
        String testName = "aName";
        assertNull(media.getName());
        media.setName(testName);
        assertEquals(testName, media.getName());
    }

}