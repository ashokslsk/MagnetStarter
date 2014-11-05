/**
 * File generated by Magnet rest2mobile 1.0 - Oct 20, 2014 3:26:02 PM
 * @see {@link http://developer.magnet.com}
 */

package iampoineer.googledistance.model.beans;

import java.util.List;

/**
 * Generated from json example
{
  "destination_addresses" : [ "EmbarcaderoNorthStreet,SanFrancisco,CA,USA" ],
  "origin_addresses" : [ "435TassoStreet,PaloAlto,CA94301,USA" ],
  "rows" : [ {
    "elements" : [ {
      "distance" : {
        "text" : "55.4km",
        "value" : 55389
      },
      "duration" : {
        "text" : "45mins",
        "value" : 2727
      },
      "status" : "OK"
    } ]
  } ],
  "status" : "OK"
}

 */

public class DistanceResult {

  
  private List<java.lang.String> destination_addresses;

  
  private List<java.lang.String> origin_addresses;

  
  private List<Row> rows;

  
  private String status;

  public List<java.lang.String> getDestination_addresses() {
    return destination_addresses;
  }
  public List<java.lang.String> getOrigin_addresses() {
    return origin_addresses;
  }
  public List<Row> getRows() {
    return rows;
  }
  public String getStatus() {
    return status;
  }

  /**
  * Builder for DistanceResult
  **/
  public static class DistanceResultBuilder {
    private DistanceResult toBuild = new DistanceResult();

    public DistanceResultBuilder() {
    }

    public DistanceResult build() {
      return toBuild;
    }

    public DistanceResultBuilder destination_addresses(List<java.lang.String> value) {
      toBuild.destination_addresses = value;
      return this;
    }
    public DistanceResultBuilder origin_addresses(List<java.lang.String> value) {
      toBuild.origin_addresses = value;
      return this;
    }
    public DistanceResultBuilder rows(List<Row> value) {
      toBuild.rows = value;
      return this;
    }
    public DistanceResultBuilder status(String value) {
      toBuild.status = value;
      return this;
    }
  }
}