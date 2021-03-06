/**
 * File generated by Magnet rest2mobile 1.0 - Oct 23, 2014 2:40:59 PM
 * @see {@link http://developer.magnet.com}
 */

package com.magnetapi.examples.model.beans;

import java.util.List;

/**
 * Generated from json example
{
  "data" : [ {
    "id" : 107979555105,
    "name" : "JohnDoe"
  }, {
    "id" : 3729106556,
    "name" : "JaneSmith"
  } ]
}

 */

public class AsanaUsersResult {

  
  private List<Datum> data;

  public List<Datum> getData() {
    return data;
  }

  /**
  * Builder for AsanaUsersResult
  **/
  public static class AsanaUsersResultBuilder {
    private AsanaUsersResult toBuild = new AsanaUsersResult();

    public AsanaUsersResultBuilder() {
    }

    public AsanaUsersResult build() {
      return toBuild;
    }

    public AsanaUsersResultBuilder data(List<Datum> value) {
      toBuild.data = value;
      return this;
    }
  }
}
