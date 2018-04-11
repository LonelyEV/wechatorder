package ones.quzhigang.order.utils;

import ones.quzhigang.order.vo.ResultVo;

public class ResultVoUtil {

    public static ResultVo sucesses(Object object){

        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);

        return resultVo;
    }

}
