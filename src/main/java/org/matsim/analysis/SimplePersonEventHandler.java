package org.matsim.analysis;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

    @Override
    public void handleEvent(PersonArrivalEvent PersonArrivalEvent) {
        System.out.println("Arrival: "+ PersonArrivalEvent.getTime() + ": " + PersonArrivalEvent.getPersonId());
    }

    @Override
    public void handleEvent(PersonDepartureEvent PersonDepartureEvent) {
        System.out.println("Departure: "+ PersonDepartureEvent.getTime() + ": " + PersonDepartureEvent.getPersonId());
    }

}

