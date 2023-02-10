package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.controller.attendeecontroller;
import eventmanagement.eventmanagement.dao.Eventdao;
import eventmanagement.eventmanagement.entity.Event;
import eventmanagement.eventmanagement.exception.Enumerror;
import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.models.Eventdto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class eventservicee implements  eventservice {
    @Autowired
    private Eventdao eventdao;
    private static Logger LOGGER = LoggerFactory.getLogger(attendeecontroller.class);


    @Override
    public ResponseEntity<String> createevent(Eventdto eventdto) throws applicationex {
       Event event=maptoentity(eventdto);
        eventdao.save(event);
        return new ResponseEntity<String>("sucess",HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> updateevent(Eventdto eventdto, Long id) throws applicationex{
        try{
            Optional<Event> event= eventdao.findById(id);
           Event event1 =event.get();
            event1.builder()
                    .eventname(eventdto.getEventname())
                    .date(eventdto.getDate())
                    .location(eventdto.getLocation())
                    .attendeeList(eventdto.getAttendeeList())
                    .build();
            eventdao.save(event1);

        }catch (Exception ex){
            new applicationex("check the id",ex, Enumerror.Event_not_found);

        }
        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteevent(Long id) throws applicationex{
        try{
        eventdao.deleteById(id);
     ;
        }catch(Exception ex){
            new applicationex("check the id",ex, Enumerror.Event_not_found);
        }
        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updatedateand(Long id, Date date, String location) throws applicationex {
        try{
           Optional<Event> event= eventdao.findById(id);
           event.get().setDate(date);
           event.get().setLocation(location);
           eventdao.save(event.get());
        }catch(Exception ex){
            new applicationex("check the id",ex, Enumerror.Event_not_found);

        }
        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }

    @Override
    public List<Eventdto> getevents() throws applicationex {
        return eventdao.findAll().stream().map(this::entitytodto).collect(Collectors.toList());
    }

    private Event maptoentity(Eventdto eventdto) {
        return Event.builder()
                .eventname(eventdto.getEventname())
                .date(eventdto.getDate())
                .location(eventdto.getLocation())
                .attendeeList(eventdto.getAttendeeList())
                .build();
    }
    private Eventdto entitytodto(Event event){
        LOGGER.info("iam in mapping");
        return Eventdto.builder().eventname(event.getEventname())
                .eventid(event.getEventid())
                .date(event.getDate())
                .location(event.getLocation())
                .attendeeList(event.getAttendeeList()).
                build();

    }


}
