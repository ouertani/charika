package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.ReferenceListener

trait TReferenceListener extends ReferenceListener

class ReferenceListener_(
  listenerComponent:TTarget,bindMethod:String,unbindMethod:String
) extends TReferenceListener {

  override def  getListenerComponent()=listenerComponent
  override  def getBindMethod()=bindMethod
  override def getUnbindMethod()=unbindMethod
}