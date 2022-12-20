package ra.restapi.model.service;

import ra.restapi.model.entity.ProductDetail;

import java.util.List;

public interface IProductService<T,V> extends IShopService<T,V> {
    List<T> searchProduct(String searchName);
    List<ProductDetail> getAllProductDetailByProductId(int productId);
}
