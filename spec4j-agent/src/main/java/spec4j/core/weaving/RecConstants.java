package spec4j.core.weaving;

import j.n.g.y.n.R$;

public interface RecConstants {

  public static final String R_HANDLER_CLASS_NAME = R$.class.getName().replace('.', '/');

  public static final String R_HANDLER_METHOD_NAME_NEW = "i";

  public static final String R_HANDLER_METHOD_NAME_START = "s";

  public static final String R_HANDLER_METHOD_DESC_START = "(Ljava/lang/String;)V";

  public static final String R_HANDLER_METHOD_NAME_RETURN = "r";

  public static final String R_HANDLER_METHOD_DESC_RETURN = "()V";

  public static final String R_HANDLER_METHOD_NAME_THROW = "e";

  public static final String R_HANDLER_METHOD_DESC_THROW = "()V";

  public static final String R_HANDLER_METHOD_NAME_LINE = "l";

  public static final String R_HANDLER_METHOD_DESC_LINE = "(I)V";

  public static final String R_HANDLER_METHOD_NAME_VARIABLE = "t";

  public static final String R_HANDLER_METHOD_DESC_VARIABLE = "(Ljava/lang/Object;)V";

  public static final String CATCH_HANDLER_CLASS_NAME = Throwable.class.getName().replace('.', '/');

  public static final String CATCH_HANDLER_TYPE_NAME = "L" + CATCH_HANDLER_CLASS_NAME + ";";

}
