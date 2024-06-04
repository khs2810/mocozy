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
	
	@RequestMapping("adminBlock.ad")
	public String showAdminBlock(Model model) {    
	    return "admin/adminBlock/adminBlock";
    }
	
	@RequestMapping("adminChat.ad")
	public String showAdminChat(Model model) {    
	    return "admin/adminChat/adminChat";
    }
	
	@RequestMapping("adminClub.ad")
	public String showAdminClub(Model model) {    
	    return "admin/adminClub/adminClub";
    }
	
	@RequestMapping("adminComment.ad")
	public String showAdminComment(Model model) {    
	    return "admin/adminComment/adminComment";
    }
	
	@RequestMapping("adminManager.ad")
	public String showAdminManager(Model model) {    
	    return "admin/adminManager/adminManager";
    }
	
	@RequestMapping("adminNotice.ad")
	public String showAdminNotice(Model model) {    
	    return "admin/adminNotice/adminNotice";
    }
	
	@RequestMapping("adminPoint.ad")
	public String showAdminPoint(Model model) {    
	    return "admin/adminPoint/adminPoint";
    }
	
	@RequestMapping("adminReview.ad")
	public String showAdminReview(Model model) {    
	    return "admin/adminReview/adminReview";
    }
	
	@RequestMapping("adminTerms.ad")
	public String showAdminTerms(Model model) {    
	    return "admin/adminTerms/adminTerms";
    }
	
	@RequestMapping("adminUserlist.ad")
	public String showAdminUserlist(Model model) {    
	    return "admin/adminUserlist/adminUserlist";
    }
}
