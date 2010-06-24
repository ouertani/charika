package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.IdRefMetadata

trait TIdRefMetadata extends IdRefMetadata with TNonNullMetadata


class IdRefMetadata_(componentId:String) extends TIdRefMetadata {
  override def  getComponentId()=componentId
}