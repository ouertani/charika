package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class IdRefMetadataBuilder   {
  private [this] var _componentId:String=_

  def withComponentId(componentId:String)={
    this._componentId=componentId
    this
  }

 def build()={
    new IdRefMetadata(_componentId)
  }
}