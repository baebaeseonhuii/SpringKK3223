package com.kk3223.app.weather;

import java.io.UnsupportedEncodingException;
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
		request.setCharacterEncoding("UTF-8");
		List<WeatherDTO> weatherList = weatherService.getList();
		request.setAttribute("weatherList", weatherList);
		return "weather/list";
	}

	@RequestMapping("/weather/detail")
	public String getDetail(HttpServletRequest request) {
		WeatherDTO wDTO = new WeatherDTO();
		wDTO.setNum(Long.parseLong(request.getParameter("num")));
		wDTO = weatherService.getDetail(wDTO);
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (wDTO != null) {
			request.setAttribute("weatherDetail", wDTO);
			return "weather/detail";
		} else {
			request.setAttribute("messages", "정보가 없습니다");
			return "commons/messages";
		}
	}

	@RequestMapping(value = "/weather/delete", method = RequestMethod.GET)
	public String deleteWeather() {
		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/delete", method = RequestMethod.POST)
	public String deleteWeather2(HttpServletRequest request) {
		WeatherDTO wDTO = new WeatherDTO();
		wDTO.setNum(Long.parseLong(request.getParameter("num")));
		weatherService.deleteWeather(wDTO);
		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.GET)
	public String addWeather() {

		return "weather/add";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.POST)
	public String addWeather2(HttpServletRequest request) throws Exception {
		WeatherDTO weatherDTO = new WeatherDTO();
		String city = request.getParameter("city");
		double gion = Double.parseDouble(request.getParameter("gion"));
		String status = request.getParameter("status");
		int humidity = Integer.parseInt(request.getParameter("humidity"));
		weatherDTO.setCity(city);
		weatherDTO.setGion(gion);
		weatherDTO.setStatus(status);
		weatherDTO.setHumidity(humidity);
		weatherService.addWeather(weatherDTO);
		List<WeatherDTO> weatherList = weatherService.getList();

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("weatherList", weatherList);
		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.GET)
	public String updateWeather(HttpServletRequest request) {
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
		weatherDTO = weatherService.getDetail(weatherDTO);
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("weatherDTO", weatherDTO);
		return "weather/update";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.POST)
	public String updateWeather2(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
		String city = request.getParameter("city");
		double gion = Double.parseDouble(request.getParameter("gion"));
		String status = request.getParameter("status");
		int humidity = Integer.parseInt(request.getParameter("humidity"));
		weatherDTO.setCity(city);
		weatherDTO.setGion(gion);
		weatherDTO.setStatus(status);
		weatherDTO.setHumidity(humidity);
		weatherService.update(weatherDTO);
		return "redirect:/weather/list";
	}

}
