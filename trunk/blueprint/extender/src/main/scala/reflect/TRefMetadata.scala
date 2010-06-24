package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.RefMetadata

trait TRefMetadata extends RefMetadata with TTarget with TNonNullMetadata

class RefMetadata_(componentId:String) extends TRefMetadata {
  override def getComponentId()=componentId
}
