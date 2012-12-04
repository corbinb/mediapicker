package mediapicker.repository;

import java.util.List;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import mediapicker.domain.Media;

public class JdbcMediaDaoTests extends AbstractTransactionalDataSourceSpringContextTests {

    private MediaDao mediaDao;


    public void setMediaDao(MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[] {"classpath:test-context.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.deleteFromTables(new String[] {"medias"});
        super.executeSqlScript("file:db/load_data.sql", true);
    }

    public void testGetMediaList() {

        List<Media> media = mediaDao.getMediaList();

        assertEquals("wrong number of media?", 10, media.size());

    }

    public void testSaveMedia() {

        List<Media> media = mediaDao.getMediaList();
		int i = 0;
        for (Media m : media) {
            m.setName("test " + ++i);
            mediaDao.saveMedia(m);
        }

        List<Media> updatedMedia = mediaDao.getMediaList();
		int j = 0;
        for (Media m : updatedMedia) {
            assertEquals("wrong name of media?", "test " + ++j, m.getName());
        }

    }

}