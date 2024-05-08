package ucentral.edu.co.PruebaQuiz.servicio;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.PruebaQuiz.dto.UniversidadDto;
import ucentral.edu.co.PruebaQuiz.entidades.Universidad;
import ucentral.edu.co.PruebaQuiz.repositorio.RepositorioUniversidad;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioUniversidad implements Serializable {

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final RepositorioUniversidad repositorioUniversidad;

    public UniversidadDto registrar(UniversidadDto universidadDto) {
        Universidad laUniversidad = repositorioUniversidad.save(modelMapper.map(universidadDto, Universidad.class));
        return modelMapper.map(laUniversidad, UniversidadDto.class);
    }

    public List<UniversidadDto> obtenerUniversidad() {
        TypeToken<List<UniversidadDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioUniversidad.findAll(), typeToken.getType());
    }

    public UniversidadDto obtenerUniversidad(long serial){
    Universidad universidad = repositorioUniversidad.findById(serial).orElseThrow(null);;
        return modelMapper.map(universidad, UniversidadDto.class);
    }

    public UniversidadDto actualizar(UniversidadDto universidadDto) {
        repositorioUniversidad.save(modelMapper.map(universidadDto, Universidad.class));
        return universidadDto;

    }

    public void eliminar(long serial) {
        repositorioUniversidad.deleteById(serial);

    }



}
