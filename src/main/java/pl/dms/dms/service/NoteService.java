package pl.dms.dms.service;

import pl.dms.dms.domain.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();
    Note findNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Long id, Note note);
    boolean delete(Long id);
}
