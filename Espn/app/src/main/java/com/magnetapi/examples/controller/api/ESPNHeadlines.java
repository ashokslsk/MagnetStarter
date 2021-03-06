/**
 * File generated by Magnet rest2mobile 1.0 - Oct 23, 2014 1:11:25 PM
 * @see {@link http://developer.magnet.com}
 */

package com.magnetapi.examples.controller.api;

import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.async.StateChangedListener;

import com.magnetapi.examples.model.beans.*;

public interface ESPNHeadlines {

  /**
   * Generated from URL GET https://wmerydith-espn.p.mashape.com/sports/news?apikey=someApiKey
   * GET sports/news
   * @param apikey  style:QUERY
   * @param paramXMashapeAuthorization (original name : X-Mashape-Authorization) style:HEADER
   * @param listener
   * @return SportsNewsResult
   */
  Call<SportsNewsResult> getSportsNews(
     String apikey,
     String paramXMashapeAuthorization,
     StateChangedListener listener
  );


}
