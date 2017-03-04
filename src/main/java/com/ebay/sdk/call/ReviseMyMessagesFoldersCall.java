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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseMyMessagesFolders call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Operation</code> - Indicates the type of operation to perform on a
 * specified My Messages folder. Operations include creating,
 * renaming, removing, and restoring folders. Operations
 * cannot be performed on the Inbox and Sent folders.
 * <br> <B>Input property:</B> <code>FolderID</code> - An ID that uniquely identifies the My Messages
 * folder to perform the operation on. This value is set by
 * eBay and cannot be changed. Retrieve FolderIDs
 * by calling GetMyMessages with a DetailLevel of
 * ReturnSummary. Inbox is FolderID = 0, and Sent is
 * FolderID = 1.
 * <br> <B>Input property:</B> <code>FolderName</code> - The name of a specified My Messages folder. Depending
 * on the specified Operation, the value is an existing
 * folder name or a new folder name. Retrieve existing
 * FolderNames by calling GetMyMessages with a DetailLevel
 * of ReturnSummary. Inbox is FolderID = 0, and Sent is
 * FolderID = 1.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseMyMessagesFoldersCall extends com.ebay.sdk.ApiCall
{
  
  private MyMessagesFolderOperationCodeType operation = null;
  private long[] folderID = null;
  private String[] folderName = null;


  /**
   * Constructor.
   */
  public ReviseMyMessagesFoldersCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseMyMessagesFoldersCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Renames, removes, or restores the specified My Messages folders for
   * a given user.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void reviseMyMessagesFolders()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseMyMessagesFoldersRequestType req;
    req = new ReviseMyMessagesFoldersRequestType();

    if( this.folderID == null )
      throw new SdkException("FolderID property is not set.");
    if( this.operation == null )
      throw new SdkException("Operation property is not set.");

    if (this.operation != null)
      req.setOperation(this.operation);
    if (this.folderID != null)
      req.setFolderID(this.folderID);
    if (this.folderName != null)
      req.setFolderName(this.folderName);

    ReviseMyMessagesFoldersResponseType resp = (ReviseMyMessagesFoldersResponseType) execute(req);


  }

  /**
   * Gets the ReviseMyMessagesFoldersRequestType.folderID.
   * @return long[]
   */
  public long[] getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the ReviseMyMessagesFoldersRequestType.folderID.
   * @param folderID long[]
   */
  public void setFolderID(long[] folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the ReviseMyMessagesFoldersRequestType.folderName.
   * @return String[]
   */
  public String[] getFolderName()
  {
    return this.folderName;
  }

  /**
   * Sets the ReviseMyMessagesFoldersRequestType.folderName.
   * @param folderName String[]
   */
  public void setFolderName(String[] folderName)
  {
    this.folderName = folderName;
  }

  /**
   * Gets the ReviseMyMessagesFoldersRequestType.operation.
   * @return MyMessagesFolderOperationCodeType
   */
  public MyMessagesFolderOperationCodeType getOperation()
  {
    return this.operation;
  }

  /**
   * Sets the ReviseMyMessagesFoldersRequestType.operation.
   * @param operation MyMessagesFolderOperationCodeType
   */
  public void setOperation(MyMessagesFolderOperationCodeType operation)
  {
    this.operation = operation;
  }

}

