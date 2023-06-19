package pl.dms.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dms.dms.domain.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {}
