package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class ReferenceListenerBuilder {

  private [this] var _listenerComponent:TTarget=_
  private [this] var _bindMethod:String=_
  private [this] var _unbindMethod:String=_



  def withListenerComponent  (listenerComponent:TTarget)={
    _listenerComponent=listenerComponent
    this
  }
  def withBindMethod   (bindMethod:String)={
   _bindMethod=bindMethod
    this
  }
  def withUnbindMethod   (unbindMethod:String)={
    _unbindMethod=unbindMethod
    this
  }
  def build()={
    new ReferenceListener(
      _listenerComponent,
      _bindMethod,
      _unbindMethod
    )
  }
}
