package ones.quzhigang.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ones.quzhigang.order.dto.OrderDTO;
import ones.quzhigang.order.enums.ResultEnum;
import ones.quzhigang.order.exception.OrderException;
import ones.quzhigang.order.form.OrderForm;
import ones.quzhigang.order.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken< List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            throw  new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);


        return orderDTO;
    }

}
