/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerDashboard call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedSearchStanding</code> - Provides information about the visibility level you have earned for your
 * listings. The higher your search standing rating, the higher your items
 * will be placed in search results sorted by Best Match. Because your search
 * standing rating is directly tied to your customer service record, this
 * rating is an important way that eBay rewards you as a good seller--it
 * encourages you to give buyers the best possible shopping experience.
 * <br><br>
 * This element is returned <b>only</b> for the following sites. 
 * <br><br>
 * <table>
 * <tr>  <th>Site</th> <th>Id</th>  </tr>  
 * <tr>  <td>AU</td> <td>15</td>  </tr>  
 * <tr>  <td>BEFR</td> <td>23</td>  </tr>  
 * <tr>  <td>BENL</td> <td>123</td>  </tr>  
 * <tr>  <td>CA</td> <td>2</td>  </tr>  
 * <tr>  <td>ES</td> <td>186</td>  </tr>  
 * <tr>  <td>FR</td> <td>71</td>  </tr>  
 * <tr>  <td>IN</td> <td>203</td>  </tr>  
 * <tr>  <td>IT</td> <td>101</td>  </tr>  
 * <tr>  <td>MOTORS</td> <td>100</td>  </tr>  
 * <tr>  <td>NL</td> <td>146</td>  </tr>  
 * <tr>  <td>PL</td> <td>212</td>  </tr>  
 * </table>								
 * <br> <B>Output property:</B> <code>ReturnedSellerFeeDiscount</code> - Provides information about the PowerSeller discount level you have earned,
 * if any. As a PowerSeller, you can earn discounts on your monthly invoice
 * Final Value Fees based on how well you're rated as a seller. Only returned
 * for members of the eBay US or Canada PowerSeller program.
 * <br> <B>Output property:</B> <code>ReturnedPowerSellerStatus</code> - Provides information about your PowerSeller status, such as whether or not
 * you meet the PowerSeller requirements. Your PowerSeller status directly
 * affects your discount (SellerFeeDiscount).
 * <br><br>
 * For eBay Germany and France, you must be a registered business seller to
 * see your PowerSeller status.
 * <br> <B>Output property:</B> <code>ReturnedPolicyCompliance</code> - This container is no longer returned in <b>GetSellerDashboard</b>.
 * <br> <B>Output property:</B> <code>ReturnedBuyerSatisfaction</code> - Rates your level of customer service. This information helps you to keep
 * track of how well you are providing members with positive buying
 * experiences.
 * <br><br>
 * This element is not returned for all sites. 
 * <br> <B>Output property:</B> <code>ReturnedSellerAccount</code> - The status of your latest eBay invoice. Includes any alerts issued to your
 * account to help you identify possible problems.
 * <br> <B>Output property:</B> <code>ReturnedPerformance</code> - Provides information about the seller's performance within different eBay
 * regions. A seller's performance rating can be Top-Rated, Above Standard,
 * Standard, and Below Standard.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerDashboardCall extends com.ebay.sdk.ApiCall
{
  
  private SearchStandingDashboardType returnedSearchStanding=null;
  private SellerFeeDiscountDashboardType returnedSellerFeeDiscount=null;
  private PowerSellerDashboardType returnedPowerSellerStatus=null;
  private PolicyComplianceDashboardType returnedPolicyCompliance=null;
  private BuyerSatisfactionDashboardType returnedBuyerSatisfaction=null;
  private SellerAccountDashboardType returnedSellerAccount=null;
  private PerformanceDashboardType[] returnedPerformance=null;


  /**
   * Constructor.
   */
  public GetSellerDashboardCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerDashboardCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves a brief summary of the requester's status as an eBay seller.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SearchStandingDashboardType object.
   */
  public SearchStandingDashboardType getSellerDashboard()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerDashboardRequestType req;
    req = new GetSellerDashboardRequestType();

    GetSellerDashboardResponseType resp = (GetSellerDashboardResponseType) execute(req);

    this.returnedSearchStanding = resp.getSearchStanding();
    this.returnedSellerFeeDiscount = resp.getSellerFeeDiscount();
    this.returnedPowerSellerStatus = resp.getPowerSellerStatus();
    this.returnedPolicyCompliance = resp.getPolicyCompliance();
    this.returnedBuyerSatisfaction = resp.getBuyerSatisfaction();
    this.returnedSellerAccount = resp.getSellerAccount();
    this.returnedPerformance = resp.getPerformance();
    return this.getReturnedSearchStanding();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedBuyerSatisfaction.
   * 
   * @return BuyerSatisfactionDashboardType
   */
  public BuyerSatisfactionDashboardType getReturnedBuyerSatisfaction()
  {
    return this.returnedBuyerSatisfaction;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedPerformance.
   * 
   * @return PerformanceDashboardType[]
   */
  public PerformanceDashboardType[] getReturnedPerformance()
  {
    return this.returnedPerformance;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedPolicyCompliance.
   * 
   * @return PolicyComplianceDashboardType
   */
  public PolicyComplianceDashboardType getReturnedPolicyCompliance()
  {
    return this.returnedPolicyCompliance;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedPowerSellerStatus.
   * 
   * @return PowerSellerDashboardType
   */
  public PowerSellerDashboardType getReturnedPowerSellerStatus()
  {
    return this.returnedPowerSellerStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedSearchStanding.
   * 
   * @return SearchStandingDashboardType
   */
  public SearchStandingDashboardType getReturnedSearchStanding()
  {
    return this.returnedSearchStanding;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedSellerAccount.
   * 
   * @return SellerAccountDashboardType
   */
  public SellerAccountDashboardType getReturnedSellerAccount()
  {
    return this.returnedSellerAccount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedSellerFeeDiscount.
   * 
   * @return SellerFeeDiscountDashboardType
   */
  public SellerFeeDiscountDashboardType getReturnedSellerFeeDiscount()
  {
    return this.returnedSellerFeeDiscount;
  }

}

