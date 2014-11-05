/**
 * File generated by Magnet rest2mobile 1.0 - Oct 16, 2014 1:36:55 PM
 * @see {@link http://developer.magnet.com}
 */

package iampoineer.magnetearthquake.controller.api;

import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.controller.ControllerFactory;
import com.magnet.android.mms.controller.AbstractControllerSchemaFactory;
import com.magnet.android.mms.controller.RequestSchema;
import com.magnet.android.mms.controller.RequestSchema.JMethod;
import com.magnet.android.mms.controller.RequestSchema.JMeta;
import com.magnet.android.mms.controller.RequestSchema.JParam;

import java.util.Arrays;
import java.util.Collection;

import iampoineer.magnetearthquake.model.beans.*;

public class EarthQuakeFactory extends ControllerFactory<EarthQuake> {
  public EarthQuakeFactory(MagnetMobileClient magnetClient) {
    super(EarthQuake.class, EarthQuakeSchemaFactory.getInstance().getSchema(), magnetClient);
  }

  // Schema factory for controller EarthQuake
  public static class EarthQuakeSchemaFactory extends AbstractControllerSchemaFactory {
    private static EarthQuakeSchemaFactory __instance;

    public static synchronized EarthQuakeSchemaFactory getInstance() {
      if(null == __instance) {
        __instance = new EarthQuakeSchemaFactory();
      }

      return __instance;
    }

    private EarthQuakeSchemaFactory() {}

    protected synchronized void initSchemaMaps() {
      if(null != schema) {
        return;
      }

      schema = new RequestSchema();
      schema.setRootPath("");

      //controller schema for controller method checkQuake
      JMethod method1 = addMethod("checkQuake",
        "api/eqs/2011/03",
        "GET",
        CheckQuakeResult.class,
        null,
        null,
        Arrays.asList("application/json"));
      method1.setBaseUrl("http://www.seismi.org");
      method1.addParam("min_magnitude",
        "QUERY",
        String.class,
        null,
        "",
        true);
    }

  }

}
