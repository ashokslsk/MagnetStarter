/**
 * File generated by Magnet rest2mobile 1.0 - Oct 20, 2014 3:26:02 PM
 * @see {@link http://developer.magnet.com}
 */

package iampoineer.googledistance.model.beans;


/**
 * Generated from json example
{
  "distance" : {
    "text" : "55.4km",
    "value" : 55389
  },
  "duration" : {
    "text" : "45mins",
    "value" : 2727
  },
  "status" : "OK"
}

 */

public class Element {

  
  private Distance distance;

  
  private Duration duration;

  
  private String status;

  public Distance getDistance() {
    return distance;
  }
  public Duration getDuration() {
    return duration;
  }
  public String getStatus() {
    return status;
  }

  /**
  * Builder for Element
  **/
  public static class ElementBuilder {
    private Element toBuild = new Element();

    public ElementBuilder() {
    }

    public Element build() {
      return toBuild;
    }

    public ElementBuilder distance(Distance value) {
      toBuild.distance = value;
      return this;
    }
    public ElementBuilder duration(Duration value) {
      toBuild.duration = value;
      return this;
    }
    public ElementBuilder status(String value) {
      toBuild.status = value;
      return this;
    }
  }
}