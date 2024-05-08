package ucentral.edu.co.PruebaQuiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ucentral.edu.co.PruebaQuiz.entidades.Universidad;

public interface RepositorioUniversidad extends JpaRepository<Universidad, Long>, JpaSpecificationExecutor<Universidad> {



}
