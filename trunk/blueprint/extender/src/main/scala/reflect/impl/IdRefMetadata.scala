package net.dikka.charika.blueprint
package reflect.impl
import reflect._
class IdRefMetadata(componentId:String) extends TIdRefMetadata {
  override def  getComponentId()=componentId
}
