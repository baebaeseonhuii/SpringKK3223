package com.kk3223.app.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/list")
	public String getList(HttpServletRequest request) throws Exception {

		System.out.println("list 가져오기");
		List<WeatherDTO> weatherList = weatherService.getList();
		request.setAttribute("weatherList", weatherList);
		return "weather/list";
	}

	@RequestMapping("/weather/detail")
	public String getDetail() {
		return "weather/detail";
	}

}
