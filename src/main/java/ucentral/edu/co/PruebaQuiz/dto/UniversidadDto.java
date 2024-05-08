package ucentral.edu.co.PruebaQuiz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UniversidadDto implements Serializable {

    private long serial;
    private String nombreUniversidad;
    private String ubicacion;
    private String facultades;
    private String carreras;
    private long nit;


}
