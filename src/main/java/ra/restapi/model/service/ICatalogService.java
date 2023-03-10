package ra.restapi.model.service;

import java.util.List;

public interface ICatalogService<T,V> extends IShopService<T,V>{
    List<T> searchCatalog(String searchName);
}
