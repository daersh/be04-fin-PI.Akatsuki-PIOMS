package com.akatsuki.pioms.product.dto;


import com.akatsuki.pioms.categoryThird.aggregate.CategoryThird;
import com.akatsuki.pioms.product.aggregate.Product;
import com.akatsuki.pioms.product.etc.PRODUCT_COLOR;
import com.akatsuki.pioms.product.etc.PRODUCT_GENDER;
import com.akatsuki.pioms.product.etc.PRODUCT_STATUS;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class ProductDTO {
    private int productCode;
    private String productName;
    private int productPrice;
    private String productEnrollDate;
    private String productUpdateDate;
    private String productContent;
    private PRODUCT_COLOR productColor;
    private int productSize;
    private PRODUCT_GENDER productGender;
    private int productTotalCount;
    private PRODUCT_STATUS productStatus;
    private boolean productExposureStatus;
    private int productNoticeCount;
    private int productDiscount;
    private int productCount;
    private int categoryThirdCode;


    public ProductDTO(Product product) {
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productEnrollDate = product.getProductEnrollDate();
        this.productUpdateDate = product.getProductUpdateDate();
        this.productContent = product.getProductContent();
        this.productColor = product.getProductColor();
        this.productSize = product.getProductSize();
        this.productGender = product.getProductGender();
        this.productTotalCount = product.getProductTotalCount();
        this.productStatus = product.getProductStatus();
        this.productExposureStatus = product.isProductExposureStatus();
        this.productNoticeCount = product.getProductNoticeCount();
        this.productDiscount = product.getProductDiscount();
        this.productCount = product.getProductCount();
        this.categoryThirdCode = product.getCategoryThird().getCategoryThirdCode();
        //
    }
    public String getProductGender() {
        if (productGender == null) {
            return "UNKNOWN"; // 또는 적절한 기본 값
        }
        return productGender.toString();
    }
}
