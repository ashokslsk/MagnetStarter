/**
 * File generated by Magnet rest2mobile 1.0 - Oct 23, 2014 2:40:59 PM
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

public class AsanaUsersFactory extends ControllerFactory<AsanaUsers> {
  public AsanaUsersFactory(MagnetMobileClient magnetClient) {
    super(AsanaUsers.class, AsanaUsersSchemaFactory.getInstance().getSchema(), magnetClient);
  }

  // Schema factory for controller AsanaUsers
  public static class AsanaUsersSchemaFactory extends AbstractControllerSchemaFactory {
    private static AsanaUsersSchemaFactory __instance;

    public static synchronized AsanaUsersSchemaFactory getInstance() {
      if(null == __instance) {
        __instance = new AsanaUsersSchemaFactory();
      }

      return __instance;
    }

    private AsanaUsersSchemaFactory() {}

    protected synchronized void initSchemaMaps() {
      if(null != schema) {
        return;
      }

      schema = new RequestSchema();
      schema.setRootPath("");

      //controller schema for controller method getAsanaUsers
      JMethod method1 = addMethod("getAsanaUsers",
        "api/1.0/users",
        "GET",
        AsanaUsersResult.class,
        null,
        null,
        Arrays.asList("application/json"));
      method1.setBaseUrl("https://app.asana.com");
      method1.addParam("Authorization",
        "HEADER",
        String.class,
        null,
        "",
        true);
    }

  }

}
