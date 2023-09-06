package lt.vitalis.budget.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "pajamos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pajamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "suma")
    private Double suma;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "tipas")
    private String tipas;

    public Pajamos(Double suma, String pavadinimas, LocalDateTime data, String tipas) {
        this.suma = suma;
        this.pavadinimas = pavadinimas;
        this.data = data;
        this.tipas = tipas;
    }
}
