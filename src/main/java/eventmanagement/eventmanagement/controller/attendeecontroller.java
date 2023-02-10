package eventmanagement.eventmanagement.controller;

import eventmanagement.eventmanagement.dao.attendeedao;
import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.models.attendeedto;
import eventmanagement.eventmanagement.service.Registationservice;
import eventmanagement.eventmanagement.service.attendeeservicee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/attendee")
public class attendeecontroller {
    @Autowired
    private attendeeservicee attendeeservicee;
    @Autowired
    private Registationservice registationservice;
    private static Logger LOGGER = LoggerFactory.getLogger(attendeecontroller.class);
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteattendee(@PathVariable Long id) throws applicationex {
        return attendeeservicee.deleteattendee(id);

    }
    @PutMapping("upadateattendee/{id}")
     public ResponseEntity<String> updateattendee(@RequestBody attendeedto attendeedto,Long id) throws applicationex{

       return attendeeservicee.updatemapping(attendeedto ,id);

     }
     @PostMapping("registor")
    public ResponseEntity<String> registorattendee(  @Valid @RequestBody  attendeedto attendeedto) throws applicationex{
        LOGGER.info("post method call in attende controller");
        return attendeeservicee.registorattendee(attendeedto );

    }

     @GetMapping("/attendees")
     public List<attendeedto> getattendee() throws applicationex{
       return attendeeservicee.getattendee();

     }


}
