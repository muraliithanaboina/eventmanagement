package eventmanagement.eventmanagement.service;

import eventmanagement.eventmanagement.entity.attendee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class attendeedetails implements UserDetails {
    private String username;
    private  Boolean enable;
    private String password;
  private   List<GrantedAuthority> authorityList;
    public attendeedetails() {
    }
    public attendeedetails(attendee attende){
        this.username=attende.getUsername();
        this.enable=attende.getEnable();
        this.password=attende.getPassword();
        this.authorityList= Arrays.stream(attende.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
