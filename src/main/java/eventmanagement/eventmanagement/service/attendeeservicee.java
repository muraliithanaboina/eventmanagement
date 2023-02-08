package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.entity.attendee;
import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.models.attendeedto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface attendeeservicee {
   public  ResponseEntity<String> deleteattendee(Long id) throws applicationex;

  public ResponseEntity<String> updatemapping(attendeedto attendeedto,Long id) throws applicationex;

  public List<attendeedto> getattendee() throws applicationex;

  public   ResponseEntity<String> registorattendee(attendeedto attendeedto) throws applicationex;
    public attendee findbyusername(String username);
}
