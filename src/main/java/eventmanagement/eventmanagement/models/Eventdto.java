package eventmanagement.eventmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import eventmanagement.eventmanagement.entity.Event;
import eventmanagement.eventmanagement.entity.attendee;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Eventdto {
    @Id
    @GeneratedValue
    private Long  eventid;
    private String eventname;
    private Date date;
    private  String location;
    private attendee attendeeList;


}
