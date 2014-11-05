/**
 * File generated by Magnet rest2mobile 1.0 - Oct 23, 2014 1:11:25 PM
 * @see {@link http://developer.magnet.com}
 */

package com.magnetapi.examples.controller.api;

import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.controller.ControllerFactory;
import com.magnet.android.mms.controller.AbstractControllerSchemaFactory;
import com.magnet.android.mms.controller.RequestSchema;
import com.magnet.android.mms.controller.RequestSchema.JMethod;
import com.magnet.android.mms.controller.RequestSchema.JMeta;
import com.magnet.android.mms.controller.RequestSchema.JParam;

import java.util.Arrays;
import java.util.Collection;

import com.magnetapi.examples.model.beans.*;

public class ESPNHeadlinesFactory extends ControllerFactory<ESPNHeadlines> {
  public ESPNHeadlinesFactory(MagnetMobileClient magnetClient) {
    super(ESPNHeadlines.class, ESPNHeadlinesSchemaFactory.getInstance().getSchema(), magnetClient);
  }

  // Schema factory for controller ESPNHeadlines
  public static class ESPNHeadlinesSchemaFactory extends AbstractControllerSchemaFactory {
    private static ESPNHeadlinesSchemaFactory __instance;

    public static synchronized ESPNHeadlinesSchemaFactory getInstance() {
      if(null == __instance) {
        __instance = new ESPNHeadlinesSchemaFactory();
      }

      return __instance;
    }

    private ESPNHeadlinesSchemaFactory() {}

    protected synchronized void initSchemaMaps() {
      if(null != schema) {
        return;
      }

      schema = new RequestSchema();
      schema.setRootPath("");

      //controller schema for controller method getSportsNews
      JMethod method1 = addMethod("getSportsNews",
        "sports/news",
        "GET",
        SportsNewsResult.class,
        null,
        null,
        Arrays.asList("application/json"));
      method1.setBaseUrl("https://wmerydith-espn.p.mashape.com");
      method1.addParam("apikey",
        "QUERY",
        String.class,
        null,
        "",
        true);
      method1.addParam("X-Mashape-Authorization",
        "HEADER",
        String.class,
        null,
        "",
        true);
    }

  }

}