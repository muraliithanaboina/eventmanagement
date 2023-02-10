package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.dao.attendeedao;
import eventmanagement.eventmanagement.entity.attendee;
import eventmanagement.eventmanagement.exception.Enumerror;
import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.models.attendeedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class attendeeservice implements  attendeeservicee{
    @Autowired
    private attendeedao attendeedao;
    @Override
    public ResponseEntity<String> deleteattendee(Long id) throws applicationex{
        try{
            attendeedao.deleteById(id);
        }
        catch (Exception ex){
            new applicationex("check the id",ex, Enumerror.attendee_Not_found);

        }


        return new ResponseEntity<String>("sucess", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updatemapping(attendeedto attendeedto,Long id) throws applicationex{
        try {
           Optional<attendee>attendee= attendeedao.findById(id);
           attendee attendee1=attendee.get();
            attendee1.builder().email(attendeedto.getEmail())
                    .name(attendeedto.getName())
                    .phone(attendeedto.getPhone())
                    .username(attendeedto.getUsername())
                    .enable(attendeedto.getEnable())
                    .roles(attendeedto.getRoles())
                    .eventList(attendeedto.getEventList()).build();

            attendeedao.save(attendee1);
        }
        catch (Exception ex) {
            new applicationex("check the id",ex, Enumerror.attendee_Not_found);

        }


        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }

    @Override
    public List<attendeedto> getattendee() throws applicationex {
        return attendeedao.findAll().stream().map(s->maptodto(s)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> registorattendee(attendeedto attendeedto) throws applicationex{
        attendee ee=entitytodto(attendeedto);
        attendeedao.save(ee);

        return new ResponseEntity<String>("sucess",HttpStatus.OK);
    }

    private attendee entitytodto(attendeedto s)  {
        return attendee.builder()
                .name(s.getName())
                .email(s.getEmail())
                .phone(s.getPhone())
                .enable(s.getEnable())
                .password(s.getPassword())
                .username(s.getUsername())
                .Attendeeid(s.getAttendeeid())
                .roles(s.getRoles())
                .eventList(s.getEventList())
                .build();
    }

    private attendeedto maptodto(attendee s) {
        return attendeedto.builder().Attendeeid(s.getAttendeeid())
                .name(s.getName())
                .email(s.getEmail())
                .phone(s.getPhone())
                .enable(s.getEnable())
                .username(s.getUsername())
                .password(s.getPassword())
                .Attendeeid(s.getAttendeeid())
                .roles(s.getRoles())
                .eventList(s.getEventList())
                .build();
    }
    public  attendee findbyusername(String username){
        return attendeedao.findByUsername(username).get();

    }
}
