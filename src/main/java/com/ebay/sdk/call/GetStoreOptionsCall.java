/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Integer;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetStoreOptions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedBasicThemeArray</code> - The current set of basic themes. Each basic theme definition
 * specifies a valid color scheme for the theme.
 * <br> <B>Output property:</B> <code>ReturnedAdvancedThemeArray</code> - The current set of advances themes. Unlike basic themes, you
 * can use any color	scheme with an advanced theme. These themes 
 * are suitable for more advanced customization.
 * <br> <B>Output property:</B> <code>ReturnedLogoArray</code> - The current set of Store logos. These logos are used in the Store header.
 * <br> <B>Output property:</B> <code>ReturnedSubscriptionArray</code> - The current set of eBay Store subscription tiers and corresponding 
 * subscription prices.
 * <br> <B>Output property:</B> <code>MaxCategories</code> - The maximum number of categories in this store.
 * <br> <B>Output property:</B> <code>MaxCategoryLevels</code> - The maximum number of category levels in this store.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreOptionsCall extends com.ebay.sdk.ApiCall
{
  
  private StoreThemeArrayType returnedBasicThemeArray=null;
  private StoreThemeArrayType returnedAdvancedThemeArray=null;
  private StoreLogoArrayType returnedLogoArray=null;
  private StoreSubscriptionArrayType returnedSubscriptionArray=null;
  private Integer maxCategories=null;
  private Integer maxCategoryLevels=null;


  /**
   * Constructor.
   */
  public GetStoreOptionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreOptionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the current list of eBay store configuration settings.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getStoreOptions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreOptionsRequestType req;
    req = new GetStoreOptionsRequestType();

    GetStoreOptionsResponseType resp = (GetStoreOptionsResponseType) execute(req);

    this.returnedBasicThemeArray = resp.getBasicThemeArray();
    this.returnedAdvancedThemeArray = resp.getAdvancedThemeArray();
    this.returnedLogoArray = resp.getLogoArray();
    this.returnedSubscriptionArray = resp.getSubscriptionArray();
    this.maxCategories = resp.getMaxCategories();
    this.maxCategoryLevels = resp.getMaxCategoryLevels();

  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreOptionsResponseType.maxCategories.
   * 
   * @return Integer
   */
  public Integer getMaxCategories()
  {
    return this.maxCategories;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreOptionsResponseType.maxCategoryLevels.
   * 
   * @return Integer
   */
  public Integer getMaxCategoryLevels()
  {
    return this.maxCategoryLevels;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreOptionsResponseType.returnedAdvancedThemeArray.
   * 
   * @return StoreThemeArrayType
   */
  public StoreThemeArrayType getReturnedAdvancedThemeArray()
  {
    return this.returnedAdvancedThemeArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreOptionsResponseType.returnedBasicThemeArray.
   * 
   * @return StoreThemeArrayType
   */
  public StoreThemeArrayType getReturnedBasicThemeArray()
  {
    return this.returnedBasicThemeArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreOptionsResponseType.returnedLogoArray.
   * 
   * @return StoreLogoArrayType
   */
  public StoreLogoArrayType getReturnedLogoArray()
  {
    return this.returnedLogoArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreOptionsResponseType.returnedSubscriptionArray.
   * 
   * @return StoreSubscriptionArrayType
   */
  public StoreSubscriptionArrayType getReturnedSubscriptionArray()
  {
    return this.returnedSubscriptionArray;
  }

}

