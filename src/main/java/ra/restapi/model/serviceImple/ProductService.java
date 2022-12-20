package ra.restapi.model.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.restapi.model.entity.Product;
import ra.restapi.model.entity.ProductDetail;
import ra.restapi.model.repository.ProductRepository;
import ra.restapi.model.service.IProductService;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackFor = SQLException.class)
public class ProductService implements IProductService<Product,Integer> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> searchProduct(String searchName) {
        return productRepository.searchProductByProductNameContaining(searchName);
    }

    @Override
    public List<ProductDetail> getAllProductDetailByProductId(int productId) {
        return productRepository.getAllProductDetailByProductId(productId);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
