import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.mainPage.service.MainService;

@RestController
public class MainController {
	
	@Autowired
    private MainService MainService;
	
	@RequestMapping("social.ma")
    public String selectSocial(MainService MainService) {
        this.MainService = MainService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getSocialList() {
    	ModelAndView modelAndView = new ModelAndView("jsonView");

        ArrayList<Club> clist = MainService.socialList(c.getclubNo);

		/*
		 * for (Club c : clist) { Attachment at = MainService.pickclub(c.getClubNo());
		 * c.setAt(at); }
		 */

        modelAndView.addObject("clist", clist);

        return modelAndView;
    }
}