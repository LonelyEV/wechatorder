package ones.quzhigang.product.service;

import ones.quzhigang.product.ProductApplicationTests;
import ones.quzhigang.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService ProductService;

    @Test
    public void findUpAll() {

        List<ProductInfo> list =  ProductService.findUpAll();
        System.out.print("list.size(): "+list.size());
        Assert.assertTrue(list.size() > 0);
    }
}