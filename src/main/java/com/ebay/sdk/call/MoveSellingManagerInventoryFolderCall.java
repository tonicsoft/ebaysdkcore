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
 * Wrapper class of the MoveSellingManagerInventoryFolder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FolderID</code> - Unique ID of the folder that will be moved. User can retrieve the FolderId
 * using GetSellingManagerInventoryFolder.
 * <br> <B>Input property:</B> <code>NewParentFolderID</code> - Unique folder ID for the new parent folder. If no NewParentFolderID is
 * submitted, the folder is moved to the root level.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class MoveSellingManagerInventoryFolderCall extends com.ebay.sdk.ApiCall
{
  
  private Long folderID = null;
  private Long newParentFolderID = null;


  /**
   * Constructor.
   */
  public MoveSellingManagerInventoryFolderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public MoveSellingManagerInventoryFolderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to move a Selling Manager inventory folder.
   * <br><br>
   * This call is subject to change without notice; the deprecation process is
   * inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void moveSellingManagerInventoryFolder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    MoveSellingManagerInventoryFolderRequestType req;
    req = new MoveSellingManagerInventoryFolderRequestType();
    if (this.folderID != null)
      req.setFolderID(this.folderID);
    if (this.newParentFolderID != null)
      req.setNewParentFolderID(this.newParentFolderID);

    MoveSellingManagerInventoryFolderResponseType resp = (MoveSellingManagerInventoryFolderResponseType) execute(req);


  }

  /**
   * Gets the MoveSellingManagerInventoryFolderRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the MoveSellingManagerInventoryFolderRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the MoveSellingManagerInventoryFolderRequestType.newParentFolderID.
   * @return Long
   */
  public Long getNewParentFolderID()
  {
    return this.newParentFolderID;
  }

  /**
   * Sets the MoveSellingManagerInventoryFolderRequestType.newParentFolderID.
   * @param newParentFolderID Long
   */
  public void setNewParentFolderID(Long newParentFolderID)
  {
    this.newParentFolderID = newParentFolderID;
  }

}

