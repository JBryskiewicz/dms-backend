package pl.dms.dms.service;

import pl.dms.dms.domain.Session;

import java.util.List;

public interface SessionService {
    List<Session> findAll();
    Session findSessionById(Long id);
    Session createSession(Session session);
    Session updateSession(Long id, Session session);
    boolean delete(Long id);
}
