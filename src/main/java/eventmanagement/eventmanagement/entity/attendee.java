package eventmanagement.eventmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class attendee {
    @Id
    @GeneratedValue
    private  Long Attendeeid;
    @NonNull
    @Column(unique = true)
    private String username;
    @NonNull
    @Column(unique = true)
    private String password;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private Long phone;
    private String roles;
    private  Boolean enable;
 @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "attendeeList")
    private List<Event> eventList;


}
