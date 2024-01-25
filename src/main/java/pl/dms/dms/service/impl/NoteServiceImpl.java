package pl.dms.dms.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dms.dms.domain.Note;
import pl.dms.dms.repository.NoteRepository;
import pl.dms.dms.service.NoteService;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note note) {
        Note existingNote = noteRepository.findById(id).orElse(null);
        if (existingNote != null) {
            existingNote.setName(note.getName());
            existingNote.setInformation(note.getInformation());
            return noteRepository.save(existingNote);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
