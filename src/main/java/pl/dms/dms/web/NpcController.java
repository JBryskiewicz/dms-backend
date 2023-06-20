package pl.dms.dms.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dms.dms.domain.Npc;
import pl.dms.dms.service.NpcService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/npcs")
public class NpcController {
    private final NpcService npcService;

    @GetMapping
    public ResponseEntity<List<Npc>> getAllNpcs(){
        List<Npc> npc = npcService.findAll();
        return new ResponseEntity<>(npc, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Npc> getNpcById(@PathVariable Long id) {
        Npc npc = npcService.findNpcById(id);
        if (npc == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(npc, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Npc> createNpc(@RequestBody Npc npc) {
        Npc createdNpc = npcService.createNpc(npc);
        return new ResponseEntity<>(createdNpc, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Npc> updateNpc(@PathVariable Long id, @RequestBody Npc npc) {
        Npc updatedNpc = npcService.updateNpc(id, npc);
        if (updatedNpc == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedNpc, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNpc(@PathVariable Long id) {
        boolean deleted = npcService.delete(id);
        if(!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
