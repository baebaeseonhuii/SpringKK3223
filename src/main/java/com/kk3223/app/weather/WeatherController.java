package com.kk3223.app.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/list")
	public String getList() {
		System.out.println("list 가져오기");
		weatherService.getList();

		return "weather/list";
	}

	@RequestMapping("/weather/detail")
	public String getDetail() {
		return "weather/detail";
	}

}
