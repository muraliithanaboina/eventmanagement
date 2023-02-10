package eventmanagement.eventmanagement.entity;

import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue
    private Long  eventid;
    @Column(name = "eventname")
    private String eventname;
    private Date date;
    private  String location;

   @ManyToOne(cascade = CascadeType.ALL)
   @JsonBackReference
    private attendee attendeeList;




}
