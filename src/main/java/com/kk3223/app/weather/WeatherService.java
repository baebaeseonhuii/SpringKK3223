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
}
