/**
 * File generated by Magnet rest2mobile 1.0 - Oct 23, 2014 1:11:25 PM
 * @see {@link http://developer.magnet.com}
 */

package com.magnetapi.examples.controller.api.test;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.test.suitebuilder.annotation.Suppress;

import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.exception.SchemaException;
import java.util.concurrent.ExecutionException;

import com.magnetapi.examples.controller.api.ESPNHeadlines;
import com.magnetapi.examples.controller.api.ESPNHeadlinesFactory;
import com.magnetapi.examples.model.beans.*;

/**
* This is generated stub to test {@link ESPNHeadlines}
* <p>
* All test cases are suppressed by defaullt. To run the test, you need to fix all the FIXMEs first :
* <ul>
* <li>Set proper value for the parameters
* <li>Remove out the @Suppress annotation
* <li>(optional)Add more asserts for the result
* <ul><p>
*/

public class ESPNHeadlinesTest extends InstrumentationTestCase {
  private ESPNHeadlines eSPNHeadlines;

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    // Instantiate a controller
    MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(this.getInstrumentation().getTargetContext());
    ESPNHeadlinesFactory controllerFactory = new ESPNHeadlinesFactory(magnetClient);
    eSPNHeadlines = controllerFactory.obtainInstance();

    assertNotNull(eSPNHeadlines);
  }

  /**
    * Generated unit test for {@link ESPNHeadlines#getSportsNews}
    */
  @Suppress //FIXME : set proper parameter value and un-suppress this test case
  @SmallTest
  public void testGetSportsNews() throws SchemaException, ExecutionException, InterruptedException {
    // FIXME : set proper value for the parameters
    String apikey = null;
    String paramXMashapeAuthorization = null;

    Call<SportsNewsResult> callObject = eSPNHeadlines.getSportsNews(
      apikey, 
      paramXMashapeAuthorization, null);
    assertNotNull(callObject);

    SportsNewsResult result = callObject.get();
    assertNotNull(result);
    //TODO : add more asserts
  }

}
