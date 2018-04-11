package ones.quzhigang.product.service;

import ones.quzhigang.product.model.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> findByCateGoryTypeIn(List<Integer> cateGoryTypes);
}
