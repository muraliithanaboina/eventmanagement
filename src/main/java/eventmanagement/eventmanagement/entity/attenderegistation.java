package eventmanagement.eventmanagement.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class attenderegistation {
private  String desricption;
private String Email;
    private String url;


}
