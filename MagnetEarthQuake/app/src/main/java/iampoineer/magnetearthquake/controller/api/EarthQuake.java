/**
 * File generated by Magnet rest2mobile 1.0 - Oct 16, 2014 1:36:55 PM
 * @see {@link http://developer.magnet.com}
 */

package iampoineer.magnetearthquake.controller.api;

import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.async.StateChangedListener;

import iampoineer.magnetearthquake.model.beans.CheckQuakeResult;

public interface EarthQuake {

  /**
   * Generated from URL GET http://www.seismi.org/api/eqs/2011/03?min_magnitude=6
   * GET api/eqs/2011/03
   * @param min_magnitude  style:QUERY
   * @param listener
   * @return CheckQuakeResult
   */
  Call<CheckQuakeResult> checkQuake(
     String min_magnitude,
     StateChangedListener listener
  );


}
