package net.dikka.charika.blueprint
package reflect.impl
import reflect._
class ReferenceListener(
  listenerComponent:TTarget,
  bindMethod:String,
  unbindMethod:String
) extends TReferenceListener {

  override def  getListenerComponent()=listenerComponent
  override  def getBindMethod()=bindMethod
  override def getUnbindMethod()=unbindMethod
}