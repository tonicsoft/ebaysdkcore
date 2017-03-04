/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetStore call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CategoryStructureOnly</code> - If this is set to True, only the category structure of the store is
 * returned. If this is not specified or set to False, the complete store
 * configuration is returned.
 * <br> <B>Input property:</B> <code>RootCategoryID</code> - Specifies the category ID for the topmost category to return (along with
 * the subcategories under it, the value of the LevelLimit property
 * determining how deep). This tag is optional. If RootCategoryID is not
 * specified, then the category tree starting at that root Category is
 * returned.
 * <br> <B>Input property:</B> <code>LevelLimit</code> - Specifies the limit for the number of levels of the category hierarchy
 * to return, where the given root category is level 1 and its children are
 * level 2. Only categories at or above the level specified are returned.
 * This tag is optional. If LevelLimit is not set, the complete category
 * hierarchy is returned. Stores support category hierarchies up to 3
 * levels only.
 * <br> <B>Input property:</B> <code>UserID</code> - Specifies the user whose store data is to be returned. If not specified,
 * then the store returned is that for the requesting user.
 * <br> <B>Output property:</B> <code>ReturnedStoreType</code> - The data describing the store configuration.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreCall extends com.ebay.sdk.ApiCall
{
  
  private Boolean categoryStructureOnly = null;
  private Long rootCategoryID = null;
  private Integer levelLimit = null;
  private String userID = null;
  private StoreType returnedStoreType=null;


  /**
   * Constructor.
   */
  public GetStoreCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves configuration information for the eBay store owned by the specified
   * UserID, or by the caller.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getStore()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreRequestType req;
    req = new GetStoreRequestType();
    if (this.categoryStructureOnly != null)
      req.setCategoryStructureOnly(this.categoryStructureOnly);
    if (this.rootCategoryID != null)
      req.setRootCategoryID(this.rootCategoryID);
    if (this.levelLimit != null)
      req.setLevelLimit(this.levelLimit);
    if (this.userID != null)
      req.setUserID(this.userID);

    GetStoreResponseType resp = (GetStoreResponseType) execute(req);

    this.returnedStoreType = resp.getStore();

  }

  /**
   * Gets the GetStoreRequestType.categoryStructureOnly.
   * @return Boolean
   */
  public Boolean getCategoryStructureOnly()
  {
    return this.categoryStructureOnly;
  }

  /**
   * Sets the GetStoreRequestType.categoryStructureOnly.
   * @param categoryStructureOnly Boolean
   */
  public void setCategoryStructureOnly(Boolean categoryStructureOnly)
  {
    this.categoryStructureOnly = categoryStructureOnly;
  }

  /**
   * Gets the GetStoreRequestType.levelLimit.
   * @return Integer
   */
  public Integer getLevelLimit()
  {
    return this.levelLimit;
  }

  /**
   * Sets the GetStoreRequestType.levelLimit.
   * @param levelLimit Integer
   */
  public void setLevelLimit(Integer levelLimit)
  {
    this.levelLimit = levelLimit;
  }

  /**
   * Gets the GetStoreRequestType.rootCategoryID.
   * @return Long
   */
  public Long getRootCategoryID()
  {
    return this.rootCategoryID;
  }

  /**
   * Sets the GetStoreRequestType.rootCategoryID.
   * @param rootCategoryID Long
   */
  public void setRootCategoryID(Long rootCategoryID)
  {
    this.rootCategoryID = rootCategoryID;
  }

  /**
   * Gets the GetStoreRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetStoreRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreResponseType.returnedStoreType.
   * 
   * @return StoreType
   */
  public StoreType getReturnedStoreType()
  {
    return this.returnedStoreType;
  }

}

