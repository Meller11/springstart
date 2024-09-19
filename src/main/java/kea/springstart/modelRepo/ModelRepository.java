package kea.springstart.modelRepo;

import kea.springstart.model.ModelDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<ModelDeveloper, Integer> {
    Optional<ModelDeveloper> findByName(String name);

}
