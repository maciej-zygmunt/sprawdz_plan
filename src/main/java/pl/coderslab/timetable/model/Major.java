package pl.coderslab.timetable.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="major")
/*
      <major nazwa="EiP-E-2-COiK" specjalnosc="Ciepłownictwo, ogrzewnictwo i klimatyzacja" stopien="IIst" rodzaj="S" CzyRekrutacjaZimowa="1" ileSemestrow="3"/>
 */
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
