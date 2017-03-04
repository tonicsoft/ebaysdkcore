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
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellingManagerSoldListings call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Search</code> - Search filters for sold listings.
 * <br> <B>Input property:</B> <code>StoreCategoryID</code> - Listings with this store category ID will be listed.
 * <br> <B>Input property:</B> <code>Filter</code> - This holds the list of filters that can be applicable for sold listings.
 * <br> <B>Input property:</B> <code>Archived</code> - Requests listing records that are more than 90 days old. Records are archived between 90
 * and 120 days after being created, and thereafter can only be retrieved using this tag.
 * <br> <B>Input property:</B> <code>Sort</code> - Field to be used to sort the response.
 * <br> <B>Input property:</B> <code>SortOrder</code> - Order to be used for sorting the requested listings.
 * <br> <B>Input property:</B> <code>Pagination</code> - Details about how many listings to return per page and which page to view.
 * <br> <B>Input property:</B> <code>SaleDateRange</code> - Specifies the earliest (oldest) and latest (most recent) dates to use in a date
 * range filter based on item start time. A time range can be up to 120
 * days.
 * <br> <B>Output property:</B> <code>ReturnedSaleRecord</code> - Returns a Selling Manager user's sold listings.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains the total number of pages (<b>TotalNumberOfPages</b>) and the total
 * number of products entries (<b>TotalNumberOfEntries</b>) that can be returned
 * on repeated calls with the same format and report criteria.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerSoldListingsCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerSearchType search = null;
  private Long storeCategoryID = null;
  private SellingManagerSoldListingsPropertyTypeCodeType[] filter = null;
  private Boolean archived = null;
  private SellingManagerSoldListingsSortTypeCodeType sort = null;
  private SortOrderCodeType sortOrder = null;
  private PaginationType pagination = null;
  private TimeRangeType saleDateRange = null;
  private SellingManagerSoldOrderType[] returnedSaleRecord=null;
  private PaginationResultType returnedPaginationResult=null;


  /**
   * Constructor.
   */
  public GetSellingManagerSoldListingsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerSoldListingsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves a Selling Manager user's sold listings.
   * <br><br>
   * This call is subject to change without notice; the deprecation process is
   * inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerSoldOrderType[] object.
   */
  public SellingManagerSoldOrderType[] getSellingManagerSoldListings()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerSoldListingsRequestType req;
    req = new GetSellingManagerSoldListingsRequestType();
    if (this.search != null)
      req.setSearch(this.search);
    if (this.storeCategoryID != null)
      req.setStoreCategoryID(this.storeCategoryID);
    if (this.filter != null)
      req.setFilter(this.filter);
    if (this.archived != null)
      req.setArchived(this.archived);
    if (this.sort != null)
      req.setSort(this.sort);
    if (this.sortOrder != null)
      req.setSortOrder(this.sortOrder);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.saleDateRange != null)
      req.setSaleDateRange(this.saleDateRange);

    GetSellingManagerSoldListingsResponseType resp = (GetSellingManagerSoldListingsResponseType) execute(req);

    this.returnedSaleRecord = resp.getSaleRecord();
    this.returnedPaginationResult = resp.getPaginationResult();
    return this.getReturnedSaleRecord();
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.archived.
   * @return Boolean
   */
  public Boolean getArchived()
  {
    return this.archived;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.archived.
   * @param archived Boolean
   */
  public void setArchived(Boolean archived)
  {
    this.archived = archived;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.filter.
   * @return SellingManagerSoldListingsPropertyTypeCodeType[]
   */
  public SellingManagerSoldListingsPropertyTypeCodeType[] getFilter()
  {
    return this.filter;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.filter.
   * @param filter SellingManagerSoldListingsPropertyTypeCodeType[]
   */
  public void setFilter(SellingManagerSoldListingsPropertyTypeCodeType[] filter)
  {
    this.filter = filter;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.saleDateRange.
   * @return TimeRangeType
   */
  public TimeRangeType getSaleDateRange()
  {
    return this.saleDateRange;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.saleDateRange.
   * @param saleDateRange TimeRangeType
   */
  public void setSaleDateRange(TimeRangeType saleDateRange)
  {
    this.saleDateRange = saleDateRange;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.search.
   * @return SellingManagerSearchType
   */
  public SellingManagerSearchType getSearch()
  {
    return this.search;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.search.
   * @param search SellingManagerSearchType
   */
  public void setSearch(SellingManagerSearchType search)
  {
    this.search = search;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.sort.
   * @return SellingManagerSoldListingsSortTypeCodeType
   */
  public SellingManagerSoldListingsSortTypeCodeType getSort()
  {
    return this.sort;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.sort.
   * @param sort SellingManagerSoldListingsSortTypeCodeType
   */
  public void setSort(SellingManagerSoldListingsSortTypeCodeType sort)
  {
    this.sort = sort;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.sortOrder.
   * @return SortOrderCodeType
   */
  public SortOrderCodeType getSortOrder()
  {
    return this.sortOrder;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.sortOrder.
   * @param sortOrder SortOrderCodeType
   */
  public void setSortOrder(SortOrderCodeType sortOrder)
  {
    this.sortOrder = sortOrder;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.storeCategoryID.
   * @return Long
   */
  public Long getStoreCategoryID()
  {
    return this.storeCategoryID;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.storeCategoryID.
   * @param storeCategoryID Long
   */
  public void setStoreCategoryID(Long storeCategoryID)
  {
    this.storeCategoryID = storeCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerSoldListingsResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerSoldListingsResponseType.returnedSaleRecord.
   * 
   * @return SellingManagerSoldOrderType[]
   */
  public SellingManagerSoldOrderType[] getReturnedSaleRecord()
  {
    return this.returnedSaleRecord;
  }

}

