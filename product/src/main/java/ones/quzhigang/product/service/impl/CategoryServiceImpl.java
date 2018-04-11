package ones.quzhigang.product.service.impl;

import ones.quzhigang.product.dao.ProductCategoryRepository;
import ones.quzhigang.product.model.ProductCategory;
import ones.quzhigang.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository ProductCategoryRepository;

    /**
     * @see ones.quzhigang.product.service.CategoryService#findByCateGoryTypeIn(java.util.List<java.lang.Integer> )
     */
    @Override
    public List<ProductCategory> findByCateGoryTypeIn(List<Integer> cateGoryTypes){
        return ProductCategoryRepository.findByCategoryTypeIn(cateGoryTypes);
    }

}
