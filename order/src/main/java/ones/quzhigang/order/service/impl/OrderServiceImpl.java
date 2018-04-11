package ones.quzhigang.order.service.impl;

import ones.quzhigang.order.dao.OrderDetailRepository;
import ones.quzhigang.order.dao.OrderMasterRepository;
import ones.quzhigang.order.dto.OrderDTO;
import ones.quzhigang.order.enums.OrderStatusEnum;
import ones.quzhigang.order.enums.PayStatusEnum;
import ones.quzhigang.order.model.OrderMaster;
import ones.quzhigang.order.service.OrderService;
import ones.quzhigang.order.utils.OrderIdCreateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository OrderMasterRepository;

    @Autowired
    private OrderDetailRepository OrderDetailRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        // TODO: 查询商品信息(调用商品服务)
        // TODO: 计算总价
        // TODO: 扣库存


        //订单入库
        orderDTO.setOrderId(OrderIdCreateUtil.getUinqueKey());

        OrderMaster OrderMaster = new OrderMaster();
        orderDTO.setOrderId(OrderIdCreateUtil.getUinqueKey());
        BeanUtils.copyProperties(orderDTO,OrderMaster);
        OrderMaster.setOrderAmount(new BigDecimal(5.00));
        OrderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        OrderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMasterRepository.save(OrderMaster);

        return orderDTO;
    }
}
