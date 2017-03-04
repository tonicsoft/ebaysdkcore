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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSuggestedCategories call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Query</code> - Specifies the search string, consisting of one or
 * more words to search for in the listing title.
 * The words "and" and "or" are treated like any other
 * word.
 * <br> <B>Output property:</B> <code>ReturnedSuggestedCategoryArray</code> - Contains the categories that contain listings
 * that match the query string in the request. The array
 * can have up to 10 categories. Not returned if no categories match
 * the query in the request.
 * <br> <B>Output property:</B> <code>ReturnedCategoryCount</code> - Indicates the number of categories in the array.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSuggestedCategoriesCall extends com.ebay.sdk.ApiCall
{
  
  private String query = null;
  private SuggestedCategoryType[] returnedSuggestedCategoryArray=null;
  private Integer returnedCategoryCount=null;


  /**
   * Constructor.
   */
  public GetSuggestedCategoriesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSuggestedCategoriesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns a list of up to 10 categories that have the highest percentage of listings
   * whose titles or descriptions contain the keywords you specify.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SuggestedCategoryType[] object.
   */
  public SuggestedCategoryType[] getSuggestedCategories()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSuggestedCategoriesRequestType req;
    req = new GetSuggestedCategoriesRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.query != null)
      req.setQuery(this.query);

    GetSuggestedCategoriesResponseType resp = (GetSuggestedCategoriesResponseType) execute(req);

    this.returnedSuggestedCategoryArray = (resp.getSuggestedCategoryArray() == null? null: resp.getSuggestedCategoryArray().getSuggestedCategory());
    this.returnedCategoryCount = resp.getCategoryCount();
    return this.getReturnedSuggestedCategoryArray();
  }

  /**
   * Gets the GetSuggestedCategoriesRequestType.query.
   * @return String
   */
  public String getQuery()
  {
    return this.query;
  }

  /**
   * Sets the GetSuggestedCategoriesRequestType.query.
   * @param query String
   */
  public void setQuery(String query)
  {
    this.query = query;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSuggestedCategoriesResponseType.returnedCategoryCount.
   * 
   * @return Integer
   */
  public Integer getReturnedCategoryCount()
  {
    return this.returnedCategoryCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSuggestedCategoriesResponseType.returnedSuggestedCategoryArray.
   * 
   * @return SuggestedCategoryType[]
   */
  public SuggestedCategoryType[] getReturnedSuggestedCategoryArray()
  {
    return this.returnedSuggestedCategoryArray;
  }

}

