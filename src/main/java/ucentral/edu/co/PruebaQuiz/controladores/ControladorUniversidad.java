package ucentral.edu.co.PruebaQuiz.controladores;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.edu.co.PruebaQuiz.dto.UniversidadDto;
import ucentral.edu.co.PruebaQuiz.entidades.Universidad;
import ucentral.edu.co.PruebaQuiz.servicio.ServicioUniversidad;

import java.io.Serializable;

@Log4j2
@Controller
public class ControladorUniversidad implements Serializable {

    private static final Logger logger = LogManager.getLogger(ControladorUniversidad.class);

    @Autowired
    ServicioUniversidad servicioUniversidad;


    @GetMapping({"/principal"})
    public String listarComputador( Model model){
        logger.info("Verificando ");
        model.addAttribute("universidad",servicioUniversidad.obtenerUniversidad());
        return "universidadLista";
    }

    @GetMapping("/crear/producto")
    public String mostrarTablaLista(Model model){
        UniversidadDto universidadDto = new UniversidadDto();
        model.addAttribute("crearUniversidad", universidadDto);
        return "universidadCrear";
    }


    @PostMapping("/uni")
    public String registrarComputador(@ModelAttribute("crearUniversidad") UniversidadDto universidad) {
        servicioUniversidad.registrar(universidad);
        return "redirect:/principal";
    }

    @GetMapping("/universidad/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable int serial, Model model){
        model.addAttribute("crearUniversidad", servicioUniversidad.obtenerUniversidad(serial));
        return "universidadEditar";
    }

    @PostMapping("/universidades/{serial}")
    public String modificarEquipo(@PathVariable long serial,@ModelAttribute( "universidad") UniversidadDto universidadDto, Model model){
        model.addAttribute("universidad", servicioUniversidad.actualizar(universidadDto));
        return "redirect:/principal";
    }

    @GetMapping("/universidad/{serial}")
    public String eliminarEquipo(@PathVariable int serial){
        servicioUniversidad.eliminar(serial);
        return "redirect:/principal";
    }

}
