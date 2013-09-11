package fr.treeptik.controller;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.treeptik.clientservice.wsimport.WeatherReturn;
import fr.treeptik.clientservice.wsimport.WeatherSoap;

@ManagedBean(name = "transversalMB")
public class transversalManagedBean {

	@Inject
	private WeatherSoap weatherSoap;

	
	@Inject
	private ResourceBundle config;
	
	

	public StringBuilder getWeather() throws Exception {
		String zipcode = config.getString("zipcode.for.weather");
		WeatherReturn cityWeather = weatherSoap.getCityWeatherByZIP(zipcode);
		StringBuilder weather = new StringBuilder();
		weather.append(cityWeather.getCity()+" : ").append(cityWeather.getTemperature());
		return weather;
	}

	
}
