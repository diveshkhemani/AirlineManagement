package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.repositories.CityRepository;
import airline.repositories.FlightRepository;
import airline.services.FlightPriceCalculator;
import airline.services.FlightSearchService;
import airline.viewModels.FlightSearchCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;

@Controller
public class FlightSearchController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        CityRepository cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();

        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new FlightSearchCriteria());
        model.addAttribute("searchResults",null);
        model.addAttribute("travelClasses", Arrays.asList(TravelClass.values()));
        model.addAttribute("today", LocalDate.now().toString());
        return "FlightSearch";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String search(@ModelAttribute(value = "searchCriteria") FlightSearchCriteria searchCriteria, Model model) {
        CityRepository cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        FlightSearchService flightSearch = new FlightSearchService();
        FlightRepository flightRepository = new FlightRepository();
        FlightPriceCalculator flightPriceCalculator = new FlightPriceCalculator();
        List<Flight> availableFlights = flightSearch.search(flightRepository.getFlights(),searchCriteria);

        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", searchCriteria);
        model.addAttribute("searchResults",availableFlights);
        model.addAttribute("travelClasses", Arrays.asList(TravelClass.values()));
        model.addAttribute("today", LocalDate.now().toString());
        model.addAttribute("priceCalculator", flightPriceCalculator);
        return "FlightSearch";
    }

}
