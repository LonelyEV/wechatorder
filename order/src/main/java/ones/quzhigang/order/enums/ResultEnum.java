package ones.quzhigang.order.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    CAR_EMPTY(2, "购物车为空"),;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
