package pl.dms.dms.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dms.dms.domain.Npc;
import pl.dms.dms.repository.NpcRepository;
import pl.dms.dms.service.NpcService;

import java.util.List;

@Service
@AllArgsConstructor
public class NpcServiceImpl implements NpcService {
    private final NpcRepository npcRepository;

    @Override
    public List<Npc> findAll() {
        return npcRepository.findAll();
    }

    @Override
    public Npc findNpcById(Long id) {
        return npcRepository.findById(id).orElse(null);
    }

    @Override
    public Npc createNpc(Npc npc) {
        return npcRepository.save(npc);
    }

    @Override
    public Npc updateNpc(Long id, Npc npc) {
        Npc existingNpc = npcRepository.findById(id).orElse(null);
        if (existingNpc != null) {
            existingNpc.setName(npc.getName());
            existingNpc.setInformation(npc.getInformation());
            existingNpc.setAvatar(npc.getAvatar());
            return npcRepository.save(existingNpc);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (npcRepository.existsById(id)) {
            npcRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
