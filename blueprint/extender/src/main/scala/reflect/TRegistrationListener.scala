package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.RegistrationListener

trait TRegistrationListener extends RegistrationListener

class RegistrationListener_ (
  listenerComponent:TTarget, 
  registrationMethod:String,
  unregistrationMethod:String
)extends TRegistrationListener {

  override def getListenerComponent()=listenerComponent
  override def getRegistrationMethod()=registrationMethod
  override def getUnregistrationMethod()=unregistrationMethod

}