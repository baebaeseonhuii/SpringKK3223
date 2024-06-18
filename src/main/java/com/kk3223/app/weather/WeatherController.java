package com.kk3223.app.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	public WeatherController() {
		this.weatherService = new WeatherService();
	}

	@RequestMapping("/weather/list")
	public String getList(HttpServletRequest request) throws Exception {

		List<WeatherDTO> weatherList = weatherService.getList();
		request.setAttribute("weatherList", weatherList);
		return "weather/list";
	}

	@RequestMapping("/weather/detail")
	public String getDetail() {
		return "weather/detail";
	}

	@RequestMapping("/weather/delete")
	public String deleteWeather() {
		return "redirect:/list";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.GET)
	public String addWeather() {

		return "weather/add";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.POST)
	public String addWeather2() {

		return "redirect:/list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.GET)
	public String updateWeather() {
		return "weather/update";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.POST)
	public String updateWeather2() {
		return "redirect:/list";
	}

}
