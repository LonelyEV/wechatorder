package ones.quzhigang.product.controller;

import ones.quzhigang.product.model.ProductCategory;
import ones.quzhigang.product.model.ProductInfo;
import ones.quzhigang.product.service.CategoryService;
import ones.quzhigang.product.service.ProductService;
import ones.quzhigang.product.utils.ResultVoUtil;
import ones.quzhigang.product.vo.ProductInfoVo;
import ones.quzhigang.product.vo.ProductVo;
import ones.quzhigang.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @Autowired
    private CategoryService CategoryService;

    /**
     *
     * 1、查询所有上架的商品
     * 2、获取类目type列表
     * 3、查询类目
     * 4、构造数据
     */
    @GetMapping("/list")
    public ResultVo<ProductVo> list(){

        //1、查询所有上架的商品
        List<ProductInfo> productInfoList = ProductService.findUpAll();

        //2、获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3、从数据库查询类目
        List<ProductCategory> categoryList = CategoryService.findByCateGoryTypeIn(categoryTypeList);

        //4、构造数据
        List<ProductVo> productVoList = new ArrayList<>();

        for (ProductCategory productCategory:categoryList) {

            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> ProductInfoVoList = new ArrayList<>();

            for (ProductInfo productInfo: productInfoList) {

                if(productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    ProductInfoVoList.add(productInfoVo);
                }
            }

            productVo.setProductInfoVoList(ProductInfoVoList);
            productVoList.add(productVo);

        }

        return ResultVoUtil.success(productVoList);


    }
}
