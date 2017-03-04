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
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerPayments call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PaymentStatus</code> - A filter to retrieve only items with the specified payment status (Paid or
 * Pending). 
 * <b></b>	 
 * <ul>
 * <li><b>Pending payments</b> are payments that Half.com has created but
 * that have not yet been sent to the seller's financial institution. Pending
 * payments are typically available once a buyer pays for an order. 
 * As 	Half.com processes payments by using periodic batch jobs, the
 * <b>GetSellerPayments</b> response might not include an order line item's payment for
 * up to 20 minutes after the buyer has paid. 
 * You can retrieve pending
 * payments for the current pay period. Pending payments that have not been
 * settled yet can also be retrieved for previous pay periods. </li>
 * <li><b>Paid payments</b> are payments that Half.com processed during previous pay
 * periods. Paid payments might not appear in the seller's financial
 * institution account balance until a certain number of days after the
 * current pay period ends (see the Half.com online help for details). You
 * can only retrieve paid payments for one previous pay period at a time.</li>
 * </ul>
 * <br> <B>Input property:</B> <code>PaymentTimeFrom</code> - Time range filter that retrieves Half.com payments that were created within
 * a single pay period. Sellers can refer to the Half.com site to determine
 * their pay periods. <b>PaymentTimeFrom</b> is the earliest (oldest) time and
 * <b>PaymentTimeTo</b> is the latest (most recent) time in the range. Half.com pay
 * periods start and end at midnight Pacific time, but the time values are
 * stored in the database in GMT (not Pacific time). See "Time Values" in the
 * eBay Features Guide for information about converting between GMT and
 * Pacific time. <br>
 * <br>
 * If you specify a <b>PaymentStatus</b> of <b>Pending</b>, add a buffer of one hour (or one
 * day) to both ends of the time range to retrieve more data than you need, and
 * then filter the results on the client side as needed. If any pending
 * payments match the request, the response may include all payments since the
 * beginning of the period. <br>
 * <br>
 * If you specify a <b>PaymentStatus</b> of <b>Paid</b>, the time range must contain one
 * full pay period. That is, <b>PaymentTimeFrom</b> must be earlier or equal the
 * start time of the pay period, and <b>PaymentTimeTo</b> must be later than or
 * equal to the end time of the pay period. Otherwise, no paid payments are
 * returned. For example, if the pay period starts on 2005-09-16 and ends on
 * 2005-09-30, you could specify an earlier <b>PaymentTimeFrom</b> value of
 * 2005-09-16T00:00:00.000Z and a later <b>PaymentTimeTo</b> value of
 * 2005-10-01T12:00:00.000Z. <br>
 * <br>
 * If you specify a time range that covers two pay periods, only the payments
 * from the most recent pay period are returned. The earliest time you can
 * specify is 18 months ago.
 * <br> <B>Input property:</B> <code>PaymentTimeTo</code> - Time range filter that retrieves Half.com payments for a single pay
 * period. See the description of <b>PaymentTimeTo</b> for details about using this
 * time range filter. For paid payments, this value should be equal to or
 * later than the end of the last day of the pay period, where the time is
 * converted to GMT. For example, if the period ends on 2005-09-30, you could
 * specify 2005-10-01T09:00:00.000Z, which is later than the end of the last
 * day.
 * <br> <B>Input property:</B> <code>Pagination</code> - If many payments are available, you may need to call <b>GetSellerPayments</b> 
 * multiple times to retrieve all the data. Each result set is returned as a
 * page of entries. Use this <b>Pagination</b> information to indicate the maximum
 * number of entries to retrieve per page (i.e., per call), the page number
 * to retrieve, and other data.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains information regarding the pagination of data (if pagination is used),
 * including total number of pages and total number of entries.
 * <br> <B>Output property:</B> <code>ReturnedHasMorePayments</code> - If true, there are more payments yet to be retrieved. Additional
 * <b>GetSellerPayments</b> calls with higher page numbers or more entries per page
 * must be made to retrieve these payments. If false, no more payments are
 * available or no payments match the request (based on the payment status
 * and time filter).
 * <br> <B>Output property:</B> <code>ReturnedSellerPayment</code> - Information about a single payment that matches the criteria in the
 * request. A payment is between Half.com and a seller. 
 * <br/><br/>
 * Each payment is for
 * one transaction for one item in one order. An order can contain
 * transactions for multiple items from multiple sellers, but this call only
 * retrieves payments that are relevant to one seller. The financial value of
 * a payment is typically based on an amount that a buyer paid to Half.com
 * for a transaction, plus the shipping cost the buyer paid for the item,
 * minus Half.com's commission. 
 * <br/><br/>
 * Payments can also describe refunds that the
 * seller has issued. Multiple <b>SellerPayment</b> entries can be returned per page
 * of results. Typically, they are returned in reverse chronological order
 * (most recent <b>PaidTime</b> first). Only returned if payments exist that match
 * the request.
 * <br> <B>Output property:</B> <code>ReturnedPaymentsPerPage</code> - Indicates the number of payments that can be returned per page of data
 * (i.e., per call). This is the same as the value specified in the
 * <b>Pagination.EntriesPerPage</b> input (or the default value, if <b>EntriesPerPage</b> 
 * was not specified). This is not necessarily the actual number of payments
 * returned per page (see <b>ReturnedPaymentCountActual</b>).
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - Indicates which page of data holds the current result set. Will be the
 * same as the value specified in the <b>Pagination.PageNumber</b> input. (If the
 * input is higher than the total number of pages, the call fails with an
 * error.) If no payments are returned, the value is 0. If payments are
 * returned, the first page number is 1.
 * <br> <B>Output property:</B> <code>ReturnedReturnedPaymentCountActual</code> - Indicates the total number of payments returned (i.e., the number of
 * <b>SellerPayment</b> entries returned.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerPaymentsCall extends com.ebay.sdk.ApiCall
{
  
  private RCSPaymentStatusCodeType paymentStatus = null;
  private Calendar paymentTimeFrom = null;
  private Calendar paymentTimeTo = null;
  private PaginationType pagination = null;
  private PaginationResultType returnedPaginationResult=null;
  private Boolean returnedHasMorePayments=null;
  private SellerPaymentType[] returnedSellerPayment=null;
  private Integer returnedPaymentsPerPage=null;
  private Integer returnedPageNumber=null;
  private Integer returnedReturnedPaymentCountActual=null;


  /**
   * Constructor.
   */
  public GetSellerPaymentsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerPaymentsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * <b>Half.com only.</b>&nbsp;Retrieves a summary of pending or paid payments that Half.com created for the
   * seller identified by the authentication token in the request. 
   * This call retrieves only
   * payments that occurred within a particular pay period. 
   * <br/><br/>
   * Each payment is for one
   * order line item in one order. An order can contain order line items for
   * multiple items from multiple sellers, but this call only retrieves payments that
   * are relevant to one seller. The financial value of a payment is typically based on
   * an amount that a buyer paid to Half.com for an order line item, with adjustments for
   * shipping costs and Half.com's commission. 
   * <br/><br/>
   * For most sellers, each month contains
   * two pay periods: One from the 1st to the 15th of the month, and one from the 16th
   * to the last day of the month. Sellers can refer to their account information on
   * the Half.com site to determine their pay periods. (You cannot retrieve a seller's
   * pay periods by using eBay API.) 
   * <br/><br/>
   * When a buyer makes a purchase and an
   * order is created, Half.com creates a payment for the seller and marks it as
   * <b>Pending</b> in the seller's Half.com account. Within a certain number of days after
   * the pay period ends, Half.com settles payments for that period and marks each
   * completed payment as Paid. 
   * <br/><br/>
   * See the Half.com Web site online help for more
   * information about how payments are managed.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellerPaymentType[] object.
   */
  public SellerPaymentType[] getSellerPayments()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerPaymentsRequestType req;
    req = new GetSellerPaymentsRequestType();
    if (this.paymentStatus != null)
      req.setPaymentStatus(this.paymentStatus);
    if (this.paymentTimeFrom != null)
      req.setPaymentTimeFrom(this.paymentTimeFrom);
    if (this.paymentTimeTo != null)
      req.setPaymentTimeTo(this.paymentTimeTo);
    if (this.pagination != null)
      req.setPagination(this.pagination);

    GetSellerPaymentsResponseType resp = (GetSellerPaymentsResponseType) execute(req);

    this.returnedPaginationResult = resp.getPaginationResult();
    this.returnedHasMorePayments = resp.isHasMorePayments();
    this.returnedSellerPayment = resp.getSellerPayment();
    this.returnedPaymentsPerPage = resp.getPaymentsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedReturnedPaymentCountActual = resp.getReturnedPaymentCountActual();
    return this.getReturnedSellerPayment();
  }

  /**
   * Gets the GetSellerPaymentsRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellerPaymentsRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellerPaymentsRequestType.paymentStatus.
   * @return RCSPaymentStatusCodeType
   */
  public RCSPaymentStatusCodeType getPaymentStatus()
  {
    return this.paymentStatus;
  }

  /**
   * Sets the GetSellerPaymentsRequestType.paymentStatus.
   * @param paymentStatus RCSPaymentStatusCodeType
   */
  public void setPaymentStatus(RCSPaymentStatusCodeType paymentStatus)
  {
    this.paymentStatus = paymentStatus;
  }

  /**
   * Gets the GetSellerPaymentsRequestType.paymentTimeFrom.
   * @return Calendar
   */
  public Calendar getPaymentTimeFrom()
  {
    return this.paymentTimeFrom;
  }

  /**
   * Sets the GetSellerPaymentsRequestType.paymentTimeFrom.
   * @param paymentTimeFrom Calendar
   */
  public void setPaymentTimeFrom(Calendar paymentTimeFrom)
  {
    this.paymentTimeFrom = paymentTimeFrom;
  }

  /**
   * Gets the GetSellerPaymentsRequestType.paymentTimeTo.
   * @return Calendar
   */
  public Calendar getPaymentTimeTo()
  {
    return this.paymentTimeTo;
  }

  /**
   * Sets the GetSellerPaymentsRequestType.paymentTimeTo.
   * @param paymentTimeTo Calendar
   */
  public void setPaymentTimeTo(Calendar paymentTimeTo)
  {
    this.paymentTimeTo = paymentTimeTo;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerPaymentsResponseType.returnedHasMorePayments.
   * 
   * @return Boolean
   */
  public Boolean getReturnedHasMorePayments()
  {
    return this.returnedHasMorePayments;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerPaymentsResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerPaymentsResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerPaymentsResponseType.returnedPaymentsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedPaymentsPerPage()
  {
    return this.returnedPaymentsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerPaymentsResponseType.returnedReturnedPaymentCountActual.
   * 
   * @return Integer
   */
  public Integer getReturnedReturnedPaymentCountActual()
  {
    return this.returnedReturnedPaymentCountActual;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerPaymentsResponseType.returnedSellerPayment.
   * 
   * @return SellerPaymentType[]
   */
  public SellerPaymentType[] getReturnedSellerPayment()
  {
    return this.returnedSellerPayment;
  }

}

