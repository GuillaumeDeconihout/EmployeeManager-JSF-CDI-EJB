package fr.treeptik.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.treeptik.clientservice.wsimport.WeatherReturn;
import fr.treeptik.clientservice.wsimport.WeatherSoap;

@ManagedBean(name = "transversalMB")
public class transversalManagedBean {

	
	@Inject
	private WeatherSoap weatherSoap ;

	public StringBuilder getWeather() throws Exception {
		WeatherReturn cityWeather = weatherSoap.getCityWeatherByZIP("10007");
		StringBuilder weather = new StringBuilder();
		weather.append("New york T° : ").append(cityWeather.getTemperature());
		return weather;
	}

}
