package eventmanagement.eventmanagement.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.models.Eventdto;
import eventmanagement.eventmanagement.service.eventservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/event")
public class eventcontroller {
    @Autowired
    private eventservice eventservice;
    @PostMapping("createevent")
    public ResponseEntity<String>  createevent(@RequestBody Eventdto eventdto) throws applicationex {
        return eventservice.createevent(eventdto);

    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateevent(@RequestBody Eventdto eventdto,@PathVariable Long id) throws applicationex{
        return eventservice.updateevent(eventdto,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteevent(@PathVariable Long id) throws applicationex{
        return eventservice.deleteevent(id);
    }
    @PatchMapping("{id}/{date}/{location}")
    public   ResponseEntity<String> updatedateandlocation(@PathVariable Long id, @PathVariable  @JsonFormat(pattern="yyyy-MM-dd")Date date, @PathVariable String location) throws applicationex{
        return eventservice.updatedateand(id,date,location);
    }
    @GetMapping("/events")
    public List<Eventdto> getallevents() throws applicationex{
        return eventservice.getevents();

    }

}
