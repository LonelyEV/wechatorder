package ones.quzhigang.order.controller;

import lombok.extern.slf4j.Slf4j;
import ones.quzhigang.order.converter.OrderForm2OrderDTO;
import ones.quzhigang.order.dto.OrderDTO;
import ones.quzhigang.order.enums.ResultEnum;
import ones.quzhigang.order.exception.OrderException;
import ones.quzhigang.order.form.OrderForm;
import ones.quzhigang.order.service.OrderService;
import ones.quzhigang.order.utils.ResultVoUtil;
import ones.quzhigang.order.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public ResultVo<Map<String, String>> createOrder(@Valid OrderForm orderForm,
                                     BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确！");
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        // orderForm --> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);

        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车为空");
            throw new OrderException(ResultEnum.CAR_EMPTY);
        }

        OrderDTO result = orderService.createOrder(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVoUtil.sucesses(map);
    }
}
