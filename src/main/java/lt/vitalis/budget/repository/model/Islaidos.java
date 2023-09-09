package lt.vitalis.budget.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "islaidos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Islaidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @Column(name = "suma")
    private Double suma;

    @Column(name = "tipas")
    private String tipas;

    public Islaidos(LocalDateTime data, String pavadinimas, Double suma, String tipas) {
        this.data = data;
        this.pavadinimas = pavadinimas;
        this.suma = suma;
        this.tipas = tipas;
    }
}
