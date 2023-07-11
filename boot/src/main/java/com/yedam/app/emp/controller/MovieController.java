package com.yedam.app.emp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class MovieController {
	//RestTemplate 실습
	//RestTemplate -> 다른 서버의 정보를 ajax로 가져오는 방법

	@GetMapping("boxoffice1")
	@ResponseBody
	public JsonNode boxoffice(){
		RestTemplate rt = new RestTemplate();
		String uri ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230705";
		JsonNode  node = rt.getForObject(uri, JsonNode.class);
		return node.get("boxOfficeResult").get("dailyBoxOfficeList");
	}
	

	@GetMapping("boxoffice2")
	@ResponseBody
	public List<Object> boxoffice2(){
		RestTemplate rt = new RestTemplate();
		String uri ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230705";
		Map<String, Object>  map = rt.getForObject(uri, Map.class);
		return (List<Object>)((Map)map.get("boxOfficeResult")).get("dailyBoxOfficeList");
	}
	
	
	@GetMapping("boxoffice3")
	@ResponseBody
	public List<DailyBoxOffice> boxoffice3(){
		RestTemplate rt = new RestTemplate();
		String uri ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230705";
		BoxOffice  box = rt.getForObject(uri, BoxOffice.class);
		return box.getBoxOfficeResult().getDailyBoxOfficeList();
	}
}
