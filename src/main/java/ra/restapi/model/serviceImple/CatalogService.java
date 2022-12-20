package ra.restapi.model.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.restapi.model.entity.Catalog;
import ra.restapi.model.repository.CatalogRepository;
import ra.restapi.model.service.ICatalogService;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackFor = SQLException.class)
public class CatalogService implements ICatalogService<Catalog,Integer> {
    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public List<Catalog> searchCatalog(String searchName) {
        return catalogRepository.searchCatalogByCatalogNameContaining(searchName);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(Integer id) {
        return catalogRepository.findById(id).get();
    }

    @Override
    public Catalog saveOrUpdate(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(Integer id) {
        catalogRepository.deleteById(id);
    }
}
