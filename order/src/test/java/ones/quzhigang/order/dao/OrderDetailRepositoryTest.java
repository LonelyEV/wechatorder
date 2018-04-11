package ones.quzhigang.order.dao;

import ones.quzhigang.order.OrderApplicationTests;
import ones.quzhigang.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository OrderDetailRepository;

    @Test
    public void testSave(){

        OrderDetail OrderDetail = new OrderDetail();
        OrderDetail.setDetailId("0001");
        OrderDetail.setOrderId("0001");
        OrderDetail.setProductId("001");
        OrderDetail.setProductName("牛奶");
        OrderDetail.setProductPrice(new BigDecimal(3.00));
        OrderDetail.setProductQuantity(1);
        OrderDetail.setProductIcon("www.images.com");

        OrderDetail result = OrderDetailRepository.save(OrderDetail);
        Assert.assertTrue(result != null);

    }

}