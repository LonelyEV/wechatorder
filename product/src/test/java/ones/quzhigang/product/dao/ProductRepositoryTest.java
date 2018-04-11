package ones.quzhigang.product.dao;

import ones.quzhigang.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository ProductRepository;

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> list = ProductRepository.findByProductStatus(0);
        System.out.print("list.size():  "+list.size() );
        Assert.assertTrue(list.size() > 0);
    }
}