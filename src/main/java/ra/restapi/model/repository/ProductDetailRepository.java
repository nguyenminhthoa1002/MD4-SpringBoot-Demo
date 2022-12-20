package ra.restapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import ra.restapi.model.entity.ProductDetail;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
    @Query(value = "select * from productDetail where colorId=:searchName or sizeId=:searchName",nativeQuery = true)
    List<ProductDetail> searchProduct(@Param("searchName") int searchName);
}
