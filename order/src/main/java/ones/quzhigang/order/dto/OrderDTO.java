package ones.quzhigang.order.dto;

import lombok.Data;
import ones.quzhigang.order.model.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    private List<OrderDetail> OrderDetailList;
}
