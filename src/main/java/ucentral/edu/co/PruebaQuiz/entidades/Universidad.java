package ucentral.edu.co.PruebaQuiz.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Universidad")
@Table(name = "UNIVERSIDAD")
@ToString

public class Universidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UNIVERSIDAD")
    @SequenceGenerator(name = "SEQ_UNIVERSIDAD", sequenceName = "SEQ_UNIVERSIDAD", allocationSize = 1)


    @Column(name = "UNI_SERIAL", nullable = false)
    private long serial;

    @Column(name = "UNI_NOMBREUNIVERSIDAD", nullable = false)
    private String nombreUniversidad;

    @Column(name = "UNI_UBICACION", nullable = false)
    private String ubicacion;

    @Column(name = "UNI_FACULTADES", nullable = false)
    private String facultades;

    @Column(name = "UNI_CARRERAS", nullable = false)
    private String carreras;

    @Column(name = "UNI_NIT", nullable = false)
    private long nit;



}
