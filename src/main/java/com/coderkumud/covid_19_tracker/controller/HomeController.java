package com.coderkumud.covid_19_tracker.controller;

import com.coderkumud.covid_19_tracker.model.LocationStats;
import com.coderkumud.covid_19_tracker.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
   private CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalCases = allStats.stream().mapToInt(stats -> stats.getLatestTotalCases()).sum();
        int newCases = allStats.stream().mapToInt(stats -> stats.getDiffFromPreviousDay()).sum();
        model.addAttribute("totalCases", totalCases);
        model.addAttribute("latestStats", allStats);
        model.addAttribute("newCases", newCases);
        return "home";
    }
}
