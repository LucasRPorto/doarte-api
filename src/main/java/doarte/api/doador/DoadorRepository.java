package doarte.api.doador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoadorRepository extends JpaRepository<Doador, Long> {
    Page<Doador> findAllByAtivoTrue(Pageable paginacao);
}
