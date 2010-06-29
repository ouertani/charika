package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class RefMetadataBuilder  {
  private [this] var _componentId:String=_

  def withcomponentId(componentId:String)={
    this._componentId=componentId
    this
  }

  def apply()={
    new RefMetadata(_componentId)
  }
}