package net.dikka.charika.blueprint
package reflect.impl
import reflect._
class RegistrationListener (
  listenerComponent:TTarget,
  registrationMethod:String,
  unregistrationMethod:String
)extends TRegistrationListener {

  override def getListenerComponent()=listenerComponent
  override def getRegistrationMethod()=registrationMethod
  override def getUnregistrationMethod()=unregistrationMethod

}
