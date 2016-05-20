/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.clases.ejemplo.paises;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author arturo@kunder.cl
 */
@WebService(serviceName = "Paises")
public class Paises {

  /**
   * This is a sample web service operation
   */
  @WebMethod(operationName = "obtenerCiudades")
  public String[] obtenerCiudades(@WebParam(name = "pais") String pais) {
    // se crea cliente para servicio global weather
    GlobalWeather gw = new GlobalWeather();
    
    // se obtiene cliente soap
    GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
    
    // se llama a servicio
    // llamada se produce de manera síncrona, por lo que el retorno
    // queda en variable cities
    String cities = gwSoap.getCitiesByCountry(pais);
    
    
    // se crea cliente para servicio global weather
    Airport airp = new Airport();
    
    // se obtiene cliente soap
    AirportSoap airpSoap = airp.getAirportSoap();
    
    // se llama a servicio
    // llamada se produce de manera síncrona, por lo que el retorno
    // queda en variable cities
    String airps = airpSoap.getAirportInformationByCountry(pais);
    
    String[] mirespuesta = new String[2];
    
    mirespuesta[0] = cities;
    mirespuesta[1] = airps;
    return mirespuesta;
  }
}
