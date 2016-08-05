//package pl.writeonly.scala.util.dynamic
//
//import pl.writeonly.scala.util.ToBoolean
//import scala.util.logging.Logged
//
//trait AndApply {
//  implicit def wrap[T>: AnyRef](alt: T) = new {
//    def andApply[A >: T](obj: A) = new Dynamic with ToBoolean {
//      def applyDynamic(name: String)(args: AnyRef*) = if (obj) obj.getClass.getMethod(name, obj.getClass).invoke(obj, args);
//      def applyDynamicNamed(name: String)(args: (String, AnyRef)*) = {
//        if (obj) {
//          val clazz = obj.getClass
//          val method = clazz.getMethod(name, clazz)
//        }
//      }
//      def selectDynamic(name: String): Any = if (obj) obj.getClass.getMethod(name, obj.getClass).invoke(obj, null);
//      def updateDynamic(name: String)(value: AnyRef) {
//        if (obj) obj.getClass.getMethod(name, obj.getClass).invoke(obj, value);
//      }
//    }
//  }
//}
//
//trait Apply {
//  implicit def wrap[T](obj: T) = new {
//    def invoke = new Dynamic with ToBoolean {
//      def applyDynamic(name: String)(args: Any*) = obj.getClass.getMethod(name, obj.getClass).invoke(obj, args) + "apply";
//      def applyDynamicNamed(name: String)(args: (String, Any)*) = {
//        val clazz = obj.getClass
//        val method = clazz.getMethod(name, clazz)
//      }
//      def selectDynamic(name: String): Any = obj.getClass.getMethod(name, obj.getClass).invoke(obj, null) + "select";
//      def updateDynamic(name: String)(value: AnyRef) {
//        obj.getClass.getMethod(name, obj.getClass).invoke(obj, value);
//      }
//    }
//  }
//}
//
//trait Mock {
//  implicit def wrap[T](obj: T) = new {
//    def invoke = new Dynamic with ToBoolean with Logged {
//      def applyDynamic(name: String)(args: Any*) = log("applyDynamic " + name);
//      def applyDynamicNamed(name: String)(args: (String, Any)*) = {
//        val clazz = obj.getClass
//        val method = clazz.getMethod(name, clazz)
//      }
//      def selectDynamic(name: String): Any = log("selectDynamic " + name);
//      def updateDynamic(name: String)(value: AnyRef) {
//        obj.getClass.getMethod(name, obj.getClass).invoke(obj, value);
//      }
//    }
//  }
//}