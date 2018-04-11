package ones.quzhigang.order.dao;

import ones.quzhigang.order.OrderApplicationTests;
import ones.quzhigang.order.enums.OrderStatusEnum;
import ones.quzhigang.order.enums.PayStatusEnum;
import ones.quzhigang.order.model.OrderMaster;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository OrderMasterRepository;

    @Test
    public void testSave(){

        OrderMaster OrderMaster = new OrderMaster();
        OrderMaster.setOrderId("12345678");
        OrderMaster.setBuyerName("无双");
        OrderMaster.setBuyerPhone("13022188211");
        OrderMaster.setBuyerAddress("上海");
        OrderMaster.setBuyerOpenid("0001");
        OrderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        OrderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMasterRepository.save(OrderMaster);

    }

}