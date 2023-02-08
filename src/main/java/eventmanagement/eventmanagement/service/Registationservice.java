package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.controller.attendeeregistationcontroller;
import eventmanagement.eventmanagement.entity.attenderegistation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface Registationservice{

   public ResponseEntity<String> sendSimpleMail(attenderegistation details);





}
