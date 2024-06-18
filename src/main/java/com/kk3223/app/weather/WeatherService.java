package com.kk3223.app.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private WeatherDAO weatherDAO;

	public List<WeatherDTO> getList() throws Exception {
		List<WeatherDTO> ar = weatherDAO.getList();
		return ar;
	}

	public WeatherDTO getDetail(WeatherDTO wDTO) {
		try {
			wDTO = this.weatherDAO.getDetail(wDTO);
			return wDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void addWeather(WeatherDTO wDTO) {
		try {
			weatherDAO.addWeather(wDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteWeather(WeatherDTO weatherDTO) {
		try {
			weatherDAO.deleteWeather(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(WeatherDTO weatherDTO) {
		try {
			weatherDAO.updateWeather(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
