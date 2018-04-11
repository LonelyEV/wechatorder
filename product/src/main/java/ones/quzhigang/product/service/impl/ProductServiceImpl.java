package ones.quzhigang.product.service.impl;

import ones.quzhigang.product.dao.ProductCategoryRepository;
import ones.quzhigang.product.dao.ProductRepository;
import ones.quzhigang.product.enums.ProductStatusEnum;
import ones.quzhigang.product.model.ProductInfo;
import ones.quzhigang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository ProductRepository;


    @Override
    public List<ProductInfo> findUpAll() {
        return ProductRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
