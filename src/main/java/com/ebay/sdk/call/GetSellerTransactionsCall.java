/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.List;
import java.util.ArrayList;


import java.lang.Boolean;
import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerTransactions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ModifiedTimeFilter</code> - Helper wrapper to set GetSellerTransactionsRequestType ModTimeFrom, ModTimeTo:
 * TimeFrom sets GetSellerTransactionsRequestType.ModTimeFrom: 
 * The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields specify a date range for retrieving
 * order line items associated with the seller. The <b>ModTimeFrom</b>
 * field is the starting date range. All of the seller's order line items that were
 * last modified within this date range are returned in the output.  The
 * maximum date range that may be specified is 30 days. This value cannot be set back more than 90 days in the past, as this call cannot retrieve sales older than 90 days old. This field is not
 * applicable if the <b>NumberOfDays</b> date filter is used.
 * <br><br>
 * If you don't specify a <b>ModTimeFrom</b>/<b>ModTimeTo</b> filter, the <b>NumberOfDays</b>
 * time filter is used and it defaults to 30 (days).
 * TimeTo sets GetSellerTransactionsRequestType.ModTimeTo: 
 * The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields specify a date range for retrieving
 * order line items associated with the seller. The <b>ModTimeTo</b>
 * field is the ending date range. All of the seller's order line items that were last
 * modified within this date range are returned in the output.
 * <br/><br/>
 * The maximum
 * date range that may be specified is 30 days.
 * <br/><br/>
 * If the <b>ModTimeFrom</b> field is
 * used and the <b>ModTimeTo</b> field is omitted, the <b>ModTimeTo</b> value defaults to
 * the present time or to 30 days past the <b>ModTimeFrom</b> value (if
 * <b>ModTimeFrom</b> value is more than 30 days in the past). This field is not
 * applicable if the <b>NumberOfDays</b> date filter is used.
 * <br><br>
 * If you don't specify a <b>ModTimeFrom</b>/<b>ModTimeTo</b> filter, the <b>NumberOfDays</b>
 * time filter is used and it defaults to 30 (days).
 * <br> <B>Input property:</B> <code>Pagination</code> - Child elements control pagination of the output. Use <b>EntriesPerPage</b> property to
 * control the number of transactions to return per call and <b>PageNumber</b> property to
 * specify the page of data to return.
 * <br> <B>Input property:</B> <code>IncludeFinalValueFee</code> - Indicates whether to include Final Value Fee (FVF) in the response. For most
 * listing types, the Final Value Fee is returned in <b>Transaction.FinalValueFee</b>.
 * The Final Value Fee is returned for each order line item.
 * <br>
 * <br> <B>Input property:</B> <code>IncludeContainingOrder</code> - Include this field and set it to <code>true</code> if you want the <b>ContainingOrder</b>
 * container to be returned in the response under each <b>Transaction</b> node.
 * For single line item orders, the <b>ContainingOrder.OrderID</b> value takes the
 * value of the <b>OrderLineItemID</b> value for the order line item. For Combined Invoice orders, the <b>ContainingOrder.OrderID</b> value will be shared by at
 * least two order line items (transactions) that are part of the same
 * order.
 * <br> <B>Input property:</B> <code>SKUArray</code> - Container for a set of SKUs.
 * Filters (reduces) the response to only include order line items
 * for listings that include any of the specified SKUs.
 * If multiple listings include the same SKU, order line items for
 * all of them are returned (assuming they also match the other
 * criteria in the <b>GetSellerTransactions</b> request).<br>
 * <br>
 * You can combine SKUArray with <b>InventoryTrackingMethod</b>.
 * For example, if you also pass in <code>InventoryTrackingMethod=SKU</code>,
 * the response only includes order line items for listings that
 * include <code>InventoryTrackingMethod=SKU</code> and one of the
 * requested SKUs.
 * <br> <B>Input property:</B> <code>Platform</code> - The default behavior of <b>GetSellerTransactions</b> is to retrieve all order line items originating from eBay.com and Half.com. If the user wants to retrieve only eBay.com order line items or Half.com order line items, this filter can be used to perform that function. Inserting 'eBay' into this field will restrict retrieved order line items to those originating on eBay.com, and inserting 'Half' into this field will restrict retrieved order line items to those originating on Half.com.
 * <br> <B>Input property:</B> <code>NumberOfDays</code> - Enables you to specify the number of days' worth of new and modified
 * order line items that you want to retrieve. The maximum value for this field is <code>30</code>
 * <br/><br/>
 * The call response contains the
 * order line items whose status was modified within the specified number of days since
 * the API call was made. <b>NumberOfDays</b> is often preferable to using the <b>ModTimeFrom</b>
 * and <b>ModTimeTo</b> filters because you only need to specify one value. If you use
 * <b>NumberOfDays</b>, then <b>ModTimeFrom</b> and <b>ModTimeTo</b> are ignored.
 * <br/><br/>
 * For this field, one day is defined as 24 hours.
 * <br> <B>Input property:</B> <code>InventoryTrackingMethod</code> - Filters the response to only include order line items for listings
 * that match this <b>InventoryTrackingMethod</b> setting. <br>
 * <br>
 * For example,
 * <b></b>
 * <ul>
 * <li>If you set this to <b>SKU</b>, the call returns order line items for your listings that are tracked by SKU.</li>
 * <li>If you set this to <b>ItemID</b>, the call omits order line items for your listings that are tracked by SKU.</li>
 * <li>If you don't pass this in, the call returns all order line items, regardless of whether they are tracked by <b>SKU</b>, or <b>ItemID</b>.</li>
 * </ul>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * To specify the <b>InventoryTrackingMethod</b> when you create a listing, use <b>AddFixedPriceItem</b> or <b>RelistFixedPriceItem</b>.
 * <b>AddFixedPriceItem</b> and <b>RelistFixedPriceItem</b> are defined in
 * the Merchant Data API (part of Large Merchant Services).
 * </span>
 * <br>
 * You can combine <b>SKUArray</b> with <b>InventoryTrackingMethod</b>.
 * For example, if you set this to SKU and you also pass in
 * <b>SKUArray</b>, the response only includes order line items for listings
 * that include <code>InventoryTrackingMethod</code> = <code>SKU</code> and one of the
 * requested SKUs.
 * <br> <B>Input property:</B> <code>IncludeCodiceFiscale</code> - If this field is included in the call request and set to <code>true</code>, taxpayer identification information for the buyer is returned under the <b>BuyerTaxIdentifier</b> container in the response.
 * <br><br>
 * Codice Fiscale is only applicable to buyers on the Italy and Spain sites. It is required that buyers on the Italy site provide their Codice Fiscale ID before buying an item, and sellers on the Spain site have the option of requiring buyers on the Spain site to provide their taxpayer ID.
 * <br> <B>Output property:</B> <code>PaginationResult</code> - Container consisting of the total number of order line items that match the input
 * criteria and the total number of pages that must be scrolled through to view all order
 * line items. To scroll through each page of order line item data, make subsequent 
 * <b>GetSellerTransactions</b> calls, incrementing the <b>Pagination.PageNumber</b> 
 * field by a value of '1' each time.
 * <br> <B>Output property:</B> <code>HasMoreTransactions</code> - This flag indicates whether there are additional pages of order line items to view.
 * This field will be returned as <code>true</code> if there are additional pages or order line items
 * to <code>view</code>, or <code>false</code> if the current page of order line item data is the last page of 
 * data.
 * <br> <B>Output property:</B> <code>ReturnedTransactionsPerPage</code> - This value indicates the number of order line items returned per page (per call) and is
 * controlled by the <b>Pagination.EntriesPerPage</b> value passed in the call
 * request. Unless it is the last (or possibly only) page of data (<b>HasMoreTransactions=false</b>),  
 * the <b>TransactionsPerPage</b> value should equal the 
 * <b>Pagination.EntriesPerPage</b> value passed in the call request.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Due to the fact that item data on the eBay platform has a shorter retention period than 
 * order data, it is possible that some retrieved pages will contain no data. For pages 
 * that contain no data, the <b>ReturnedTransactionCountActual</b> value will 
 * be '0'. It is also possible that pages 2, 3, and 4 have no data, but pages 1 and 5 do 
 * have data. Therefore, we recommend that you scroll through each page of data (making 
 * subsequent <b>GetSellerTransactions</b> calls and incrementing the
 * <b>Pagination.PageNumber</b> value by '1' each time) until you reach the 
 * last page, indicated by <b>HasMoreTransactions=false</b>.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - This value indicates the page number of retrieved order line items that match the input
 * criteria. This value is controlled by the <b>Pagination.PageNumber</b>
 * value passed in the call request. To scroll through all pages of order line items that match the 
 * input criteria, you increment the <b>Pagination.PageNumber</b> value by <code>1</code> 
 * with each subsequent <b>GetSellerTransactions</b> call.
 * <br> <B>Output property:</B> <code>ReturnedTransactionCountActual</code> - This value indicates the total number of (non-empty) order line items retrieved in the
 * current page of results. The <b>ReturnedTransactionCountActual</b> value
 * will be lower than the <b>TransactionsPerPage</b> value if one or more 
 * empty order line items are retrieved on the page.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Due to the fact that item data on the eBay platform has a shorter retention period than 
 * order data, it is possible that some retrieved pages will contain no data. For pages 
 * that contain no order line item data, the <b>ReturnedTransactionCountActual</b> value will 
 * be '0'. It is also possible that pages 2, 3, and 4 have no data, but pages 1 and 5 do 
 * have data. Therefore, we recommend that you scroll through each page of data (making 
 * subsequent <b>GetSellerTransactions</b> calls and incrementing the
 * <b>Pagination.PageNumber</b> value by '1' each time) until you reach the 
 * last page, indicated by <b>HasMoreTransactions=false</b>.
 * </span>
 * <br> <B>Output property:</B> <code>Seller</code> - Contains information about the seller whose order line items are being returned.
 * See the reference guide for information about the <b>Seller</b> object fields
 * that are returned.
 * <br> <B>Output property:</B> <code>ReturnedTransactions</code> - List of <b>Transaction</b> objects representing the seller's recent sales.
 * Each <b>Transaction</b> object contains the data for one purchase
 * (of one or more items in the same listing).
 * See the reference guide for more information about the fields that are returned
 * for each order line item.
 * <br> <B>Output property:</B> <code>PayPalPreferred</code> - Indicates whether the seller has the preference enabled that shows that the seller
 * prefers PayPal as the method of payment for an item. This preference is indicated on
 * an item's View Item page and is intended to influence a buyer to use PayPal
 * to pay for the item.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerTransactionsCall extends com.ebay.sdk.ApiCall
{
  
  private TimeFilter modifiedTimeFilter = null;
  private PaginationType pagination = null;
  private Boolean includeFinalValueFee = null;
  private Boolean includeContainingOrder = null;
  private SKUArrayType sKUArray = null;
  private TransactionPlatformCodeType platform = null;
  private Integer numberOfDays = null;
  private InventoryTrackingMethodCodeType inventoryTrackingMethod = null;
  private Boolean includeCodiceFiscale = null;
  private PaginationResultType paginationResult=null;
  private boolean hasMoreTransactions=false;
  private Integer returnedTransactionsPerPage=null;
  private Integer returnedPageNumber=null;
  private int returnedTransactionCountActual=0;
  private UserType seller=null;
  private TransactionType[] returnedTransactions=null;
  private boolean payPalPreferred=false;


  /**
   * Constructor.
   */
  public GetSellerTransactionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerTransactionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves transaction information for the user for which the call is made (and
   * not for any other user), where a transaction is the information about the sale
   * of one or more items by one buyer from a single listing. (To retrieve
   * transactions for another seller's listing, use GetItemTransactions.)
   * 
   * <br>
   * @throws ApiException
   * @return The TransactionType[] object.
   */
  public TransactionType[] getSellerTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerTransactionsRequestType req;
    req = new GetSellerTransactionsRequestType();

    if( this.modifiedTimeFilter == null )
      throw new SdkException("ModifiedTimeFilter property is not set.");

    req.setDetailLevel(this.getDetailLevel());
    if (this.modifiedTimeFilter != null)
    {
      req.setModTimeFrom(this.modifiedTimeFilter.getTimeFrom());
      req.setModTimeTo(this.modifiedTimeFilter.getTimeTo());
    }
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.includeFinalValueFee != null)
      req.setIncludeFinalValueFee(this.includeFinalValueFee);
    if (this.includeContainingOrder != null)
      req.setIncludeContainingOrder(this.includeContainingOrder);
    if (this.sKUArray != null)
      req.setSKUArray(this.sKUArray);
    if (this.platform != null)
      req.setPlatform(this.platform);
    if (this.inventoryTrackingMethod != null)
      req.setInventoryTrackingMethod(this.inventoryTrackingMethod);
    if(this.includeCodiceFiscale !=null)
      req.setIncludeCodiceFiscale(this.includeCodiceFiscale);

    GetSellerTransactionsResponseType resp = (GetSellerTransactionsResponseType) execute(req);

    this.paginationResult = resp.getPaginationResult();
    this.hasMoreTransactions = (resp.isHasMoreTransactions() == null? false: resp.isHasMoreTransactions().booleanValue());
    this.returnedTransactionsPerPage = resp.getTransactionsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedTransactionCountActual = (resp.getReturnedTransactionCountActual() == null? 0: resp.getReturnedTransactionCountActual().intValue());
    this.seller = resp.getSeller();
    this.returnedTransactions = (resp.getTransactionArray() == null? null: resp.getTransactionArray().getTransaction());
    this.payPalPreferred = (resp.isPayPalPreferred() == null? false: resp.isPayPalPreferred().booleanValue());
    return this.getReturnedTransactions();
  }

  /**
   * Gets the GetSellerTransactionsRequestType.includeCodiceFiscale.
   * @return Boolean
   */
  public Boolean getIncludeCodiceFiscale()
  {
    return this.includeCodiceFiscale;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.includeCodiceFiscale.
   * @param includeCodiceFiscale Boolean
   */
  public void setIncludeCodiceFiscale(Boolean includeCodiceFiscale)
  {
    this.includeCodiceFiscale = includeCodiceFiscale;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.includeContainingOrder.
   * @return Boolean
   */
  public Boolean getIncludeContainingOrder()
  {
    return this.includeContainingOrder;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.includeContainingOrder.
   * @param includeContainingOrder Boolean
   */
  public void setIncludeContainingOrder(Boolean includeContainingOrder)
  {
    this.includeContainingOrder = includeContainingOrder;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.includeFinalValueFee.
   * @return Boolean
   */
  public Boolean getIncludeFinalValueFee()
  {
    return this.includeFinalValueFee;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.includeFinalValueFee.
   * @param includeFinalValueFee Boolean
   */
  public void setIncludeFinalValueFee(Boolean includeFinalValueFee)
  {
    this.includeFinalValueFee = includeFinalValueFee;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.inventoryTrackingMethod.
   * @return InventoryTrackingMethodCodeType
   */
  public InventoryTrackingMethodCodeType getInventoryTrackingMethod()
  {
    return this.inventoryTrackingMethod;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.inventoryTrackingMethod.
   * @param inventoryTrackingMethod InventoryTrackingMethodCodeType
   */
  public void setInventoryTrackingMethod(InventoryTrackingMethodCodeType inventoryTrackingMethod)
  {
    this.inventoryTrackingMethod = inventoryTrackingMethod;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.modifiedTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getModifiedTimeFilter()
  {
    return this.modifiedTimeFilter;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.modifiedTimeFilter.
   * @param modifiedTimeFilter TimeFilter
   */
  public void setModifiedTimeFilter(TimeFilter modifiedTimeFilter)
  {
    this.modifiedTimeFilter = modifiedTimeFilter;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.numberOfDays.
   * @return Integer
   */
  public Integer getNumberOfDays()
  {
    return this.numberOfDays;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.numberOfDays.
   * @param numberOfDays Integer
   */
  public void setNumberOfDays(Integer numberOfDays)
  {
    this.numberOfDays = numberOfDays;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.platform.
   * @return TransactionPlatformCodeType
   */
  public TransactionPlatformCodeType getPlatform()
  {
    return this.platform;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.platform.
   * @param platform TransactionPlatformCodeType
   */
  public void setPlatform(TransactionPlatformCodeType platform)
  {
    this.platform = platform;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.sKUArray.
   * @return SKUArrayType
   */
  public SKUArrayType getSKUArray()
  {
    return this.sKUArray;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.sKUArray.
   * @param sKUArray SKUArrayType
   */
  public void setSKUArray(SKUArrayType sKUArray)
  {
    this.sKUArray = sKUArray;
  }
/**
   * Get all seller transactions in specified date range.
   * It handles pagination internally and ignores the Pagination property.
   * GetSellerTransactionsCall.TimeFilter will be ignored.
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getEntireSellerTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    if( this.modifiedTimeFilter == null )
      throw new SdkException("TimeFilter is not set.");
    return getEntireSellerTransactions(this.modifiedTimeFilter);
  }
/**
   * Get all seller transactions in specified date range.
   * It handles pagination internally and ignores the Pagination property.
   *
   * @param modifiedTimeFilter TimeFilter
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getEntireSellerTransactions(TimeFilter modifiedTimeFilter)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerTransactionsRequestType req = new GetSellerTransactionsRequestType();

    // Modified time filter is mandatory.
    req.setModTimeFrom(modifiedTimeFilter.getTimeFrom());
    req.setModTimeTo(modifiedTimeFilter.getTimeTo());

    int pageNum = 1;
    PaginationType pgn = new PaginationType();
    pgn.setEntriesPerPage(new Integer(100));
    pgn.setPageNumber(new Integer(pageNum++));

    req.setPagination(pgn);
    
    if (this.includeFinalValueFee != null)
        req.setIncludeFinalValueFee(this.includeFinalValueFee);
    if (this.includeContainingOrder != null)
        req.setIncludeContainingOrder(this.includeContainingOrder);
    if (this.sKUArray != null)
        req.setSKUArray(this.sKUArray);
    if (this.platform != null)
        req.setPlatform(this.platform);
    if (this.inventoryTrackingMethod != null)
        req.setInventoryTrackingMethod(this.inventoryTrackingMethod);
     if(this.includeCodiceFiscale !=null)
        req.setIncludeCodiceFiscale(this.includeCodiceFiscale);

    ArrayList transList = new ArrayList();

    while(true)
    {
      GetSellerTransactionsResponseType resp = (GetSellerTransactionsResponseType)this.execute(req);
      TransactionArrayType tarray = resp.getTransactionArray();
      TransactionType[] tm = (tarray == null) ? null : tarray.getTransaction();
      if( tm != null )
      {
        for (int i = 0; i < tm.length; i++)
          transList.add(tm[i]);
      }

      if( resp.getReturnedTransactionCountActual() != null )
        this.returnedTransactionCountActual = resp.getReturnedTransactionCountActual().intValue();
      if( !resp.isHasMoreTransactions().booleanValue() )
        break;

      pgn.setPageNumber(new Integer(pageNum++));
    }

    // Build results.
    this.returnedTransactions = new TransactionType[transList.size()];
    for(int i = 0; i < this.returnedTransactions.length; i ++)
    {
      this.returnedTransactions[i] = (TransactionType)transList.get(i);
    }
    return this.returnedTransactions;
  }

/**
   * Executes the API. GetSellerTransactionsCall.TimeFilter will be ignored.
   * @param modifiedTimeFilter TimeFilter
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getSellerTransactions(TimeFilter modifiedTimeFilter)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
     this.modifiedTimeFilter = modifiedTimeFilter;
     return getSellerTransactions();
  }
/**
   *
   * @return TimeFilter
   */
  public TimeFilter getTimeFilter() {
    return this.modifiedTimeFilter;
  }
/**
   * Sets time filter for transactions to be returned.
   * @param timeFilter TimeFilter
   */
  public void setTimeFilter(TimeFilter timeFilter) {
    this.modifiedTimeFilter = timeFilter;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.hasMoreTransactions.
   * 
   * @return boolean
   */
  public boolean getHasMoreTransactions()
  {
    return this.hasMoreTransactions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.payPalPreferred.
   * 
   * @return boolean
   */
  public boolean getPayPalPreferred()
  {
    return this.payPalPreferred;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedTransactionCountActual.
   * 
   * @return int
   */
  public int getReturnedTransactionCountActual()
  {
    return this.returnedTransactionCountActual;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedTransactions.
   * 
   * @return TransactionType[]
   */
  public TransactionType[] getReturnedTransactions()
  {
    return this.returnedTransactions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedTransactionsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedTransactionsPerPage()
  {
    return this.returnedTransactionsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.seller.
   * 
   * @return UserType
   */
  public UserType getSeller()
  {
    return this.seller;
  }

}

