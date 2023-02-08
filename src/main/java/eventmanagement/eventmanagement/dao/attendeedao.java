package eventmanagement.eventmanagement.dao;

import eventmanagement.eventmanagement.entity.attendee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.util.Optional;

public interface attendeedao extends JpaRepository<attendee,Long> {

 Optional<attendee> findByUsername(String username);
}
