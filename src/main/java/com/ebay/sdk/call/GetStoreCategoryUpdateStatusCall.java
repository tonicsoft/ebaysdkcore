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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetStoreCategoryUpdateStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>TaskID</code> - The task ID returned by the SetStoreCategories call. If the
 * SetStoreCategories call was processed asynchronously, the TaskID will be
 * a positive number. If SetStoreCategories returned a TaskID with a value of
 * 0, the change was completed at the time the call was made (and there is
 * no need to check status).
 * <br> <B>Output property:</B> <code>ReturnedStatus</code> - The status (Pending, InProgress, Complete, or Failed) of an update to the 
 * store category structure. 
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreCategoryUpdateStatusCall extends com.ebay.sdk.ApiCall
{
  
  private long taskID = 0;
  private TaskStatusCodeType returnedStatus=null;


  /**
   * Constructor.
   */
  public GetStoreCategoryUpdateStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreCategoryUpdateStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns the status of the processing for category-structure changes specified
   * with a call to SetStoreCategories.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The TaskStatusCodeType object.
   */
  public TaskStatusCodeType getStoreCategoryUpdateStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreCategoryUpdateStatusRequestType req;
    req = new GetStoreCategoryUpdateStatusRequestType();
    if (this.taskID != 0)
      req.setTaskID(new Long(this.taskID));

    GetStoreCategoryUpdateStatusResponseType resp = (GetStoreCategoryUpdateStatusResponseType) execute(req);

    this.returnedStatus = resp.getStatus();
    return this.getReturnedStatus();
  }

  /**
   * Gets the GetStoreCategoryUpdateStatusRequestType.taskID.
   * @return long
   */
  public long getTaskID()
  {
    return this.taskID;
  }

  /**
   * Sets the GetStoreCategoryUpdateStatusRequestType.taskID.
   * @param taskID long
   */
  public void setTaskID(long taskID)
  {
    this.taskID = taskID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreCategoryUpdateStatusResponseType.returnedStatus.
   * 
   * @return TaskStatusCodeType
   */
  public TaskStatusCodeType getReturnedStatus()
  {
    return this.returnedStatus;
  }

}

