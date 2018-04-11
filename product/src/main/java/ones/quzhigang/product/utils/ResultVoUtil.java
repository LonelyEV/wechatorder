package ones.quzhigang.product.utils;

import ones.quzhigang.product.vo.ResultVo;

public class ResultVoUtil {

    public static ResultVo success(Object object){

        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setData(object);
        resultVo.setMessage("成功");

        return resultVo;
    }
}
