package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.RegistrationListener

trait TRegistrationListener extends RegistrationListener

case class RegistrationListenerImpl (

   listenerComponent:TTarget, registrationMethod:String,unregistrationMethod:String

  )extends TRegistrationListener