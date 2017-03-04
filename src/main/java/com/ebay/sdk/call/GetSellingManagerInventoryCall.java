/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Long;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellingManagerInventory call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Sort</code> - Sets the sorting method for the results.
 * <br> <B>Input property:</B> <code>FolderID</code> - Specifies the inventory folder containing the requested inventory information.
 * <br> <B>Input property:</B> <code>Pagination</code> - Details about how many Products to return per page and which page to view.
 * <br> <B>Input property:</B> <code>SortOrder</code> - Order to be used for sorting retrieved product lists.
 * <br> <B>Input property:</B> <code>Search</code> - Specifies types and values to search for in the seller's listings.
 * <br> <B>Input property:</B> <code>StoreCategoryID</code> - Specifies a store category whose products will be returned.
 * <br> <B>Input property:</B> <code>Filter</code> - Container for the list of filters that can be applied to the inventory information requested.
 * <br> <B>Output property:</B> <code>ReturnedInventoryCountLastCalculatedDate</code> - Returns the date the inventory counts were last calculated.
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerProduct</code> - Container for information about the requested products and templates.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains the total number of pages (TotalNumberOfPages) and the total
 * number of products entries (TotalNumberOfEntries) that can be returned
 * on repeated calls with the same format and report criteria.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerInventoryCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerProductSortCodeType sort = null;
  private Long folderID = null;
  private PaginationType pagination = null;
  private SortOrderCodeType sortOrder = null;
  private SellingManagerSearchType search = null;
  private Long storeCategoryID = null;
  private SellingManagerInventoryPropertyTypeCodeType[] filter = null;
  private Calendar returnedInventoryCountLastCalculatedDate=null;
  private SellingManagerProductType[] returnedSellingManagerProduct=null;
  private PaginationResultType returnedPaginationResult=null;


  /**
   * Constructor.
   */
  public GetSellingManagerInventoryCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerInventoryCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves a paginated list containing details of a user's Selling Manager inventory.
   * This call is subject to change without notice; the deprecation process is
   * inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Calendar object.
   */
  public Calendar getSellingManagerInventory()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerInventoryRequestType req;
    req = new GetSellingManagerInventoryRequestType();
    if (this.sort != null)
      req.setSort(this.sort);
    if (this.folderID != null)
      req.setFolderID(this.folderID);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.sortOrder != null)
      req.setSortOrder(this.sortOrder);
    if (this.search != null)
      req.setSearch(this.search);
    if (this.storeCategoryID != null)
      req.setStoreCategoryID(this.storeCategoryID);
    if (this.filter != null)
      req.setFilter(this.filter);

    GetSellingManagerInventoryResponseType resp = (GetSellingManagerInventoryResponseType) execute(req);

    this.returnedInventoryCountLastCalculatedDate = resp.getInventoryCountLastCalculatedDate();
    this.returnedSellingManagerProduct = resp.getSellingManagerProduct();
    this.returnedPaginationResult = resp.getPaginationResult();
    return this.getReturnedInventoryCountLastCalculatedDate();
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.filter.
   * @return SellingManagerInventoryPropertyTypeCodeType[]
   */
  public SellingManagerInventoryPropertyTypeCodeType[] getFilter()
  {
    return this.filter;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.filter.
   * @param filter SellingManagerInventoryPropertyTypeCodeType[]
   */
  public void setFilter(SellingManagerInventoryPropertyTypeCodeType[] filter)
  {
    this.filter = filter;
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.search.
   * @return SellingManagerSearchType
   */
  public SellingManagerSearchType getSearch()
  {
    return this.search;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.search.
   * @param search SellingManagerSearchType
   */
  public void setSearch(SellingManagerSearchType search)
  {
    this.search = search;
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.sort.
   * @return SellingManagerProductSortCodeType
   */
  public SellingManagerProductSortCodeType getSort()
  {
    return this.sort;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.sort.
   * @param sort SellingManagerProductSortCodeType
   */
  public void setSort(SellingManagerProductSortCodeType sort)
  {
    this.sort = sort;
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.sortOrder.
   * @return SortOrderCodeType
   */
  public SortOrderCodeType getSortOrder()
  {
    return this.sortOrder;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.sortOrder.
   * @param sortOrder SortOrderCodeType
   */
  public void setSortOrder(SortOrderCodeType sortOrder)
  {
    this.sortOrder = sortOrder;
  }

  /**
   * Gets the GetSellingManagerInventoryRequestType.storeCategoryID.
   * @return Long
   */
  public Long getStoreCategoryID()
  {
    return this.storeCategoryID;
  }

  /**
   * Sets the GetSellingManagerInventoryRequestType.storeCategoryID.
   * @param storeCategoryID Long
   */
  public void setStoreCategoryID(Long storeCategoryID)
  {
    this.storeCategoryID = storeCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerInventoryResponseType.returnedInventoryCountLastCalculatedDate.
   * 
   * @return Calendar
   */
  public Calendar getReturnedInventoryCountLastCalculatedDate()
  {
    return this.returnedInventoryCountLastCalculatedDate;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerInventoryResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerInventoryResponseType.returnedSellingManagerProduct.
   * 
   * @return SellingManagerProductType[]
   */
  public SellingManagerProductType[] getReturnedSellingManagerProduct()
  {
    return this.returnedSellingManagerProduct;
  }

}

