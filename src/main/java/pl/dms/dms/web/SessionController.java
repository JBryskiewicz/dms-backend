package pl.dms.dms.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dms.dms.domain.Session;
import pl.dms.dms.domain.User;
import pl.dms.dms.service.SessionService;
import pl.dms.dms.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = sessionService.findAll();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        Session session = sessionService.findSessionById(id);
        if (session == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(session, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        Session createdSession = sessionService.createSession(session);
        return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable Long id, @RequestBody Session session) {

        session.setEdited(true);
        session.setEditedDate(
                LocalDateTime
                        .now()
                        .format(DateTimeFormatter.ISO_DATE_TIME));
        Session updatedSession = sessionService.updateSession(id, session);

        if (updatedSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(updatedSession, HttpStatus.OK);
    }

    @DeleteMapping("/{userID}/delete/{sessionID}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long userID, @PathVariable Long sessionID) {
        Optional<User> user = userService.findById(userID);
        if (user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User modifiedUser = user.get();
        List<Session> filteredSessions = modifiedUser.getSessions()
                .stream()
                .filter((session) -> !Objects.equals(session.getId(), sessionID))
                .collect(Collectors.toList());
        modifiedUser.setSessions(filteredSessions);
        userService.updateUser(userID, modifiedUser);

        boolean deleted = sessionService.delete(sessionID);
        if(!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
