package fatec.alertamulher.repository;

import fatec.alertamulher.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoRepository extends JpaRepository<Login, Long> {
}
