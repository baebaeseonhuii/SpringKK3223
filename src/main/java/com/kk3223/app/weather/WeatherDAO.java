package com.kk3223.app.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAO {

	private File file;

	public WeatherDAO() {
		this.file = new File("C://study//weather.txt");
	}

	public List<WeatherDTO> getList() throws Exception {

		FileReader fr = new FileReader(file); // 읽는 객체
		BufferedReader br = new BufferedReader(fr); // 연결해주는 애

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		while (true) {
			String s = br.readLine();// 한줄씩 읽는 애

			if (s == null) {
				break;
			}
			s = s.replace("-", ",");
			StringTokenizer st = new StringTokenizer(s, ",");
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

	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getList();
		WeatherDTO result = null;
		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				result = w;
				break;
			}
		}

		return result;
	}

	public void addWeather(WeatherDTO weatherDTO) throws Exception {
		Calendar ca = Calendar.getInstance();
		File file = new File("C:\\study\\weather.txt");
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
			String s = ca.getTimeInMillis() + "-" + weatherDTO.getCity() + "-" + weatherDTO.getGion() + "-"
					+ weatherDTO.getStatus() + "-" + weatherDTO.getHumidity();
			fw.write(s + "\n");
			System.out.println(s);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fw.close();
		}
	}

	public void deleteWeather(WeatherDTO weatherDTO) throws Exception {
		// 리스트로 받아와서 입력된 정보랑 일치하는 애를 찾아서 그걸 지우기?
		// 파일 전체를 다시 쓰기, 새로운 데이터로 덮어씌우기
		// 기존 weatherDTOs 리스트에서 해당 도시명이면 건너뛰기
		List<WeatherDTO> ar = this.getList();

		File file = new File("C:\\study\\weather.txt");
		FileWriter fw = new FileWriter(file, false);// 덮어씌워야해서 false

		int flag = 0;
		for (WeatherDTO dto : ar) {
			if (dto.getNum() == weatherDTO.getNum()) {
				flag++;
				continue;
			}
			String s = dto.getNum() - flag + "-" + dto.getCity() + "-" + dto.getGion() + "-" + dto.getStatus() + "-"
					+ dto.getHumidity();
			fw.write(s + "\n");
		}

		fw.close();

	}

	public void updateWeather(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getList(); // 먼저 실행 -> getWeathers 메소드로 감↑
		// getWeathers 메소드에서 fw, fr IO스트림 열었다가 닫힘
		File file = new File("C:\\study\\weather.txt");
		FileWriter fw = new FileWriter(file, false);
		FileReader fr = new FileReader(file); // 읽는 객체
		BufferedReader br = new BufferedReader(fr); // 연결해주는 애

		for (int i = 0; i < ar.size(); i++) {
			if (weatherDTO.getNum() == ar.get(i).getNum()) {
				// 일치하면 데이터를 하나하나 다 바꾸기
				ar.get(i).setCity(weatherDTO.getCity());
				// i번째에서 아예 교체
				ar.set(i, weatherDTO);
				break;
			}

		}
		for (WeatherDTO dto : ar) {
			String s = dto.getNum() + "-" + dto.getCity() + "-" + dto.getGion() + "-" + dto.getStatus() + "-"
					+ dto.getHumidity();
			fw.write(s + "\n");
		}

		fw.close();

	}

}
