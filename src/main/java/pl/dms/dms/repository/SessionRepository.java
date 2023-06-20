package pl.dms.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dms.dms.domain.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {}
