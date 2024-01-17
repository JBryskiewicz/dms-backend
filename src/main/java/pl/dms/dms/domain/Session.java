package pl.dms.dms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String description;
    private String creationDate;
    private String plannedDate;
    private String editedDate;
    private boolean isEdited;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Note> notes;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Npc> npcs;
}