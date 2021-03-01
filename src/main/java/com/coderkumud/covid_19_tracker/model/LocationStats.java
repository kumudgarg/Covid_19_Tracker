package com.coderkumud.covid_19_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationStats {
    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPreviousDay;
}
