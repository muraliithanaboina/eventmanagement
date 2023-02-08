package eventmanagement.eventmanagement.controller;

import eventmanagement.eventmanagement.entity.attenderegistation;
import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.service.Registationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attenderegistation")
public class attendeeregistationcontroller {
    @Autowired
    private Registationservice registationservice;
     @PostMapping
    public ResponseEntity<String> sendregistation(@RequestBody attenderegistation attenderegistation) throws applicationex {
        return registationservice.sendSimpleMail(attenderegistation);

     }
}
