package eventmanagement.eventmanagement.dao;

import eventmanagement.eventmanagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Eventdao extends JpaRepository<Event,Long> {
}
