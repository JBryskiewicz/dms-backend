package pl.dms.dms.service;

import pl.dms.dms.domain.Npc;

import java.util.List;

public interface NpcService {
    List<Npc> findAll();
    Npc findNpcById(Long id);
    Npc createNpc(Npc npc);
    Npc updateNpc(Long id, Npc npc);
    boolean delete(Long id);
}
