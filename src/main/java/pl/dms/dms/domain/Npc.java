package pl.dms.dms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "npcs")
public class Npc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @Size(max = 5000)
    @Column(length = 5000)
    private String information;

    private String avatar;
}