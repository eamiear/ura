package com.ura.common.validator;

import com.ura.common.exception.URAException;
import org.apache.commons.lang.StringUtils;

public abstract class Assert {
  public static void isBlank(String string, String message) {
    if (StringUtils.isBlank(string)) {
      throw new URAException(message);
    }
  }

  public static void isNull(Object object, String message) {
    if (object == null) {
      throw new URAException(message);
    }
  }
}
