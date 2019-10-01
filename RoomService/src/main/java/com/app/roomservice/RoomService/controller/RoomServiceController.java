package com.app.roomservice.RoomService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.roomservice.RoomService.service.RoomInfoService;

@RefreshScope
@RestController
@RequestMapping("/roomservice")
public class RoomServiceController
{
	@Autowired
	private RoomInfoService ris;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello()
	{
		return ris.helloService();
	}

}
