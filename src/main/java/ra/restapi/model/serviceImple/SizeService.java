package ra.restapi.model.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.restapi.model.entity.Size;
import ra.restapi.model.repository.SizeRepository;
import ra.restapi.model.service.ISizeService;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackFor = SQLException.class)
public class SizeService implements ISizeService<Size,Integer> {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size findById(Integer id) {
        return sizeRepository.findById(id).get();
    }

    @Override
    public Size saveOrUpdate(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public void delete(Integer id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public List<Size> searchSize(String searchName) {
        return sizeRepository.searchSizeBySizeName(searchName);
    }
}
