package ones.quzhigang.product.service;

import ones.quzhigang.product.ProductApplicationTests;
import ones.quzhigang.product.model.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private CategoryService CategoryService;

    @Test
    public void findByCateGoryTypeIn() {

        List<ProductCategory> list =  CategoryService.findByCateGoryTypeIn(Arrays.asList(11,22));
        System.out.print("list.size(): "+list.size());
        Assert.assertTrue(list.size() > 0);
    }
}