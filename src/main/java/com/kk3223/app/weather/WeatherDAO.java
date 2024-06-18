package com.kk3223.app.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAO {

	public List<WeatherDTO> getList() throws Exception {

		File file = new File("C:\\study\\weather.txt");
		FileReader fr = new FileReader(file); // 읽는 객체
		BufferedReader br = new BufferedReader(fr); // 연결해주는 애

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		while (true) {
			String s = br.readLine();// 한줄씩 읽는 애

			if (s == null) {
				break;
			}
			s = s.replace(",", "-");
			StringTokenizer st = new StringTokenizer(s, "-");
			WeatherDTO dto = new WeatherDTO();

			while (st.hasMoreTokens()) {
				dto.setNum(Long.parseLong(st.nextToken().trim()));
				dto.setCity(st.nextToken().trim());
				dto.setGion(Double.parseDouble(st.nextToken().trim()));
				dto.setStatus(st.nextToken().trim());
				dto.setHumidity(Integer.parseInt(st.nextToken().trim()));
			}
			ar.add(dto);
		}
		br.close();
		fr.close();
		return ar;
	}

}
