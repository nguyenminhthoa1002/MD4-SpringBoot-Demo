package ra.restapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.restapi.model.entity.Size;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size,Integer> {
    List<Size> searchSizeBySizeName(String searchName);
}
