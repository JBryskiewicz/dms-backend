package pl.dms.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dms.dms.domain.Npc;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Long> {}
