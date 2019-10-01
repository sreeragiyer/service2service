package com.app.dashboardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RefreshScope
@RestController
@RequestMapping("/dashboard")
public class DashboardController 
{

	
	
	@Autowired 
	private RestTemplate restTemplate;
    
    @RequestMapping("/callrs")
    @ResponseBody
    public String callRoomService()
    {	  
		  String resp = restTemplate.getForObject("http://ROOMSERVICE/roomservice/hello", String.class);
		  System.out.println("Response......"+resp);
		  return "Transferring from dashboard to room service... "+resp;
		 
    }
    
    @GetMapping("/gotors")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("localhost:8084");
    }
    
    

}
