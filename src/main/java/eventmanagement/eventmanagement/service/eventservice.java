package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.exception.applicationex;
import eventmanagement.eventmanagement.models.Eventdto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import javax.persistence.metamodel.EntityType;
import java.util.Date;
import java.util.List;

@Service
public interface eventservice {

   public ResponseEntity<String> createevent(Eventdto eventdto) throws applicationex;

  public  ResponseEntity<String> updateevent(Eventdto eventdto, Long id) throws applicationex;

  public  ResponseEntity<String> deleteevent(Long id) throws applicationex;

  public  ResponseEntity<String> updatedateand(Long id, Date date, String location) throws applicationex;

 public   List<Eventdto> getevents() throws applicationex;
}
