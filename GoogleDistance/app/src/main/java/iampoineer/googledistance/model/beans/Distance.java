/**
 * File generated by Magnet rest2mobile 1.0 - Oct 20, 2014 3:26:02 PM
 * @see {@link http://developer.magnet.com}
 */

package iampoineer.googledistance.model.beans;


/**
 * Generated from json example
{
  "text" : "55.4km",
  "value" : 55389
}

 */

public class Distance {

  
  private String text;

  
  private Integer value;

  public String getText() {
    return text;
  }
  public Integer getValue() {
    return value;
  }

  /**
  * Builder for Distance
  **/
  public static class DistanceBuilder {
    private Distance toBuild = new Distance();

    public DistanceBuilder() {
    }

    public Distance build() {
      return toBuild;
    }

    public DistanceBuilder text(String value) {
      toBuild.text = value;
      return this;
    }
    public DistanceBuilder value(Integer value) {
      toBuild.value = value;
      return this;
    }
  }
}
