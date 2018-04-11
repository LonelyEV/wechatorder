package ones.quzhigang.product.dao;

import com.netflix.discovery.converters.Auto;
import ones.quzhigang.product.model.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository ProductCategoryRepository;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> list =  ProductCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,12));
        System.out.print("list.size(): "+list.size());
        Assert.assertTrue(list.size() > 0);
    }
}