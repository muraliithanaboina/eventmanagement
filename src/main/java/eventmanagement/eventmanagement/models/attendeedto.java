package eventmanagement.eventmanagement.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import eventmanagement.eventmanagement.entity.Event;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Component
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class attendeedto {
    private  Long Attendeeid;

    private String username;

    private String password;
    private String name;

    private String email;

    private Long phone;
    private String roles;
    private  Boolean enable;

    private List<Event> eventList;
}
