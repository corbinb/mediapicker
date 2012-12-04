package mediapicker.web;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.ArrayList;

import mediapicker.domain.Media;
import mediapicker.repository.InMemoryMediaDao;
import mediapicker.web.PickerController;
import mediapicker.service.BasicMediaSourceManager;

import junit.framework.TestCase;

public class PickerControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{
        PickerController controller = new PickerController();
        BasicMediaSourceManager bmm = new BasicMediaSourceManager();
        bmm.setMediaDao(new InMemoryMediaDao(new ArrayList<Media>()));
        controller.setMediaManager(bmm);
        //controller.setMediaManager(new BasicMediaSourceManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);

        assertEquals("mpicker", modelAndView.getViewName());

        assertNotNull(modelAndView.getModel());

        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");

        assertNotNull(nowValue);
    }
}