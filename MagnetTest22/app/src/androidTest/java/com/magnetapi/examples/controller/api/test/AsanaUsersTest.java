/**
 * File generated by Magnet rest2mobile 1.0 - Oct 23, 2014 2:40:59 PM
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

import com.magnetapi.examples.controller.api.AsanaUsers;
import com.magnetapi.examples.controller.api.AsanaUsersFactory;
import com.magnetapi.examples.model.beans.*;

/**
* This is generated stub to test {@link AsanaUsers}
* <p>
* All test cases are suppressed by defaullt. To run the test, you need to fix all the FIXMEs first :
* <ul>
* <li>Set proper value for the parameters
* <li>Remove out the @Suppress annotation
* <li>(optional)Add more asserts for the result
* <ul><p>
*/

public class AsanaUsersTest extends InstrumentationTestCase {
  private AsanaUsers asanaUsers;

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    // Instantiate a controller
    MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(this.getInstrumentation().getTargetContext());
    AsanaUsersFactory controllerFactory = new AsanaUsersFactory(magnetClient);
    asanaUsers = controllerFactory.obtainInstance();

    assertNotNull(asanaUsers);
  }

  /**
    * Generated unit test for {@link AsanaUsers#getAsanaUsers}
    */
  @Suppress //FIXME : set proper parameter value and un-suppress this test case
  @SmallTest
  public void testGetAsanaUsers() throws SchemaException, ExecutionException, InterruptedException {
    // FIXME : set proper value for the parameters
    String Authorization = null;

    Call<AsanaUsersResult> callObject = asanaUsers.getAsanaUsers(
      Authorization, null);
    assertNotNull(callObject);

    AsanaUsersResult result = callObject.get();
    assertNotNull(result);
    //TODO : add more asserts
  }

}
