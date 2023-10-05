package org.matsim.analysis;

import java.util.HashMap;
import java.util.Map;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {
    
    private final Map<Id<Person>, Double> personToDepartureTime = new HashMap<>(0) ;

    @Override
    public void handleEvent(PersonDepartureEvent PersonDepartureEvent) {
        var departureTime = PersonDepartureEvent.getTime();
        var personId = PersonDepartureEvent.getPersonId();
        personToDepartureTime.put(personId, departureTime);
    }
    
    @Override
    public void handleEvent(PersonArrivalEvent PersonArrivalEvent) {
        var arrivalTime = PersonArrivalEvent.getTime();

        var departureTime = personToDepartureTime.get(PersonArrivalEvent.getPersonId());
        var travelTime = arrivalTime - departureTime;

        System.out.println("Person: " + PersonArrivalEvent.getPersonId() + "travelled: " + travelTime + "s.");
        
    }



}

