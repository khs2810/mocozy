package com.kh.mocozy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("admin.ad")
	public String showAdmin(Model model) {    
	    return "admin/admin";
    }
	
	@RequestMapping("adminChat.ad")
	public String showAdminChat(Model model) {    
	    return "admin/adminChat/adminChat";
    }
	
	@RequestMapping("privateChat.ad")
	public String showPrivateChat(Model model) {    
	    return "admin/adminChat/privateChat";
    }

	@RequestMapping("publicChat.ad")
	public String showPublicChat(Model model) {    
	    return "admin/adminChat/publicChat";
    }
	
	@RequestMapping("insertClub.ad")
	public String showinsertClub(Model model) {    
	    return "admin/adminClub/insertClub";
    }

	@RequestMapping("adminManager.ad")
	public String showAdminManager(Model model) {    
	    return "admin/adminManager/adminManager";
    }
	
	@RequestMapping("insertManager.ad")
	public String showinsertManager(Model model) {    
	    return "admin/adminManager/insertManager";
    }

	@RequestMapping("adminNotice.ad")
	public String showAdminNotice(Model model) {    
	    return "admin/adminNotice/adminNotice";
    }
	
	@RequestMapping("adminPoint.ad")
	public String showAdminPoint(Model model) {    
	    return "admin/adminPoint/adminPoint";
    }
	
	@RequestMapping("adminUserlist.ad")
	public String showAdminUserlist(Model model) {    
	    return "admin/adminUserlist/adminUserlist";
    }

	@RequestMapping("insertUser.ad")
	public String showinsertUser(Model model) {    
	    return "admin/adminUserlist/insertUser";
    }
}
