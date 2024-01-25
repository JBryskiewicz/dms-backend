package pl.dms.dms.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dms.dms.domain.Session;
import pl.dms.dms.repository.SessionRepository;
import pl.dms.dms.service.SessionService;

import java.util.List;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session findSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Long id, Session session) {
        Session existingSession = sessionRepository.findById(id).orElse(null);
        if (existingSession != null) {
            existingSession.setName(session.getName());
            existingSession.setDescription(session.getDescription());
            existingSession.setCreationDate(session.getCreationDate());
            existingSession.setPlannedDate(session.getPlannedDate());
            existingSession.setEditedDate(session.getEditedDate());
            existingSession.setEdited(true);
            existingSession.setNotes(session.getNotes());
            existingSession.setNpcs(session.getNpcs());
            return sessionRepository.save(existingSession);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (sessionRepository.existsById(id)) {
            sessionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
