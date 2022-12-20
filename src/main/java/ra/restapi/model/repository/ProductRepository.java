package ra.restapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.restapi.model.entity.Product;
import ra.restapi.model.entity.ProductDetail;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> searchProductByProductNameContaining(String searchName);

    @Query(value = "select *\n" +
            "from productDetail where productId=1", nativeQuery = true)
    List<ProductDetail> getAllProductDetailByProductId(@Param("searchName") int searchName);
}
