package ra.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.restapi.model.entity.Catalog;
import ra.restapi.model.service.ICatalogService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @GetMapping
    public List<Catalog> getAllCatalog(){
        return catalogService.findAll();
    }

    @GetMapping("/{catalogId}")
    public Catalog getCatalogById(@PathVariable ("catalogId") int catalogId){
        return (Catalog) catalogService.findById(catalogId);
    }

    @PostMapping
    public Catalog createCatalog(@RequestBody Catalog catalog){
        return (Catalog) catalogService.saveOrUpdate(catalog);
    }

    @PutMapping("/{catalogId}")
    public Catalog updateCatalog(@PathVariable ("catalogId") int catalogId, @RequestBody Catalog catalog){
        Catalog catUpdate = (Catalog) catalogService.findById(catalogId);
        catUpdate.setCatalogName(catalog.getCatalogName());
        catUpdate.setCatalogDescription(catalog.getCatalogDescription());
        catUpdate.setCatalogCreateDate(catalog.getCatalogCreateDate());
        catUpdate.setCatalogStatus(catalog.isCatalogStatus());
        return (Catalog) catalogService.saveOrUpdate(catUpdate);
    }

    @DeleteMapping("/{catalogId}")
    public void deleteCatalog(@PathVariable ("catalogId") int catalogId){
        catalogService.delete(catalogId);
    }

    @GetMapping("search")
    public List<Catalog> searchCatalog(@RequestParam("searchName") String searchName){
        return catalogService.searchCatalog(searchName);
    }
}
