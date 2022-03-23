package ar.com.mercadolibre.statisticproxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ar.com.mercadolibre.commons.locators.ServiceLocator;
import ar.com.mercadolibre.commons.model.Proxy;
import ar.com.mercadolibre.commons.model.statistics.ClientStatistic;
import ar.com.mercadolibre.commons.model.statistics.ProxyStatistics;
import ar.com.mercadolibre.commons.model.statistics.SystemStatistics;
import ar.com.mercadolibre.statisticproxy.controller.services.StatisticsService;


@RestController
@Validated
@RequestMapping("/StatisticsController")
public class StatisticsController {
	
	@Autowired(required=true)
	StatisticsService estatisticsService;
	
	@GetMapping(value = "/findServiceProxyByPort/{port}")
	@Operation(description = "search the service proxy/s by port number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description  = "OK") })
	@ResponseStatus(HttpStatus.OK)
	public List<Proxy>  findServiceProxyByPort(@PathVariable(required = true) Integer port) throws JsonProcessingException{
		
		return ServiceLocator.getDataBaseService().findByPort(port);
	}
	
	@GetMapping(value = "/findStatisticsProxyBy/{id}")
	@Operation(description = "search a service proxy/s by id and return self stadistics")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description  = "OK") })
	@ResponseStatus(HttpStatus.OK)
	public ProxyStatistics  findStatisticsProxyBy(@PathVariable(required = true) String id) throws JsonProcessingException{
		
		return estatisticsService.findStatisticsProxyBy(id);
	}
	
	
	@GetMapping(value = "/findSystemStatistics")
	@Operation(description = "find the system stadistics")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description  = "OK") })
	@ResponseStatus(HttpStatus.OK)
	public SystemStatistics  findSystemStatistics() throws JsonProcessingException{
		
		return estatisticsService.getSystemStatistics();
	}
	
	@GetMapping(value = "/findStatisticsClientBy/{id}")
	@Operation(description = "search a client's proxy by id and return self stadistics")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description  = "OK") })
	@ResponseStatus(HttpStatus.OK)
	public ClientStatistic  findClientStatisticsBy(@PathVariable(required = true) String id) throws JsonProcessingException{
		
		return estatisticsService.findClientStatisticsById(id);
	}

}
