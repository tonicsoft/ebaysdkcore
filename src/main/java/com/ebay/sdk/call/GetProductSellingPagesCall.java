/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetProductSellingPages call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>UseCase</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>Products</code> - This field is deprecated.
 * <br> <B>Output property:</B> <code>ProductSellingPagesData</code> - This field is deprecated.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetProductSellingPagesCall extends com.ebay.sdk.ApiCall
{
  
  private ProductUseCaseCodeType useCase = null;
  private ProductType[] products = null;
  private String productSellingPagesData=null;


  /**
   * Constructor.
   */
  public GetProductSellingPagesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetProductSellingPagesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * <b>This call is deprecated.</b>
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String getProductSellingPages()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetProductSellingPagesRequestType req;
    req = new GetProductSellingPagesRequestType();

    if( this.products == null )
      throw new SdkException("Products property is not set.");
    if( this.useCase == null )
      throw new SdkException("UseCase property is not set.");

    if (this.useCase != null)
      req.setUseCase(this.useCase);
    if (this.products != null)
      req.setProduct(this.products);

    GetProductSellingPagesResponseType resp = (GetProductSellingPagesResponseType) execute(req);

    this.productSellingPagesData = resp.getProductSellingPagesData();
    return this.getProductSellingPagesData();
  }

  /**
   * Gets the GetProductSellingPagesRequestType.products.
   * @return ProductType[]
   */
  public ProductType[] getProducts()
  {
    return this.products;
  }

  /**
   * Sets the GetProductSellingPagesRequestType.products.
   * @param products ProductType[]
   */
  public void setProducts(ProductType[] products)
  {
    this.products = products;
  }

  /**
   * Gets the GetProductSellingPagesRequestType.useCase.
   * @return ProductUseCaseCodeType
   */
  public ProductUseCaseCodeType getUseCase()
  {
    return this.useCase;
  }

  /**
   * Sets the GetProductSellingPagesRequestType.useCase.
   * @param useCase ProductUseCaseCodeType
   */
  public void setUseCase(ProductUseCaseCodeType useCase)
  {
    this.useCase = useCase;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetProductSellingPagesResponseType.productSellingPagesData.
   * 
   * @return String
   */
  public String getProductSellingPagesData()
  {
    return this.productSellingPagesData;
  }

}

