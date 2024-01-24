package pl.dms.dms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @Size(max = 500)
    @Column(length = 500)
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