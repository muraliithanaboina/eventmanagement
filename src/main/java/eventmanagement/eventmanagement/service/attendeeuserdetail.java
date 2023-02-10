package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.entity.attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class attendeeuserdetail implements UserDetailsService {
    @Autowired
    private attendeeservicee attendeeservicee;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      attendee attendee=attendeeservicee.findbyusername(username);
      return new  attendeedetails(attendee);
    }
}
