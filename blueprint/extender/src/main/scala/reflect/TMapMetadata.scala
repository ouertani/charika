package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.MapMetadata
import scala.collection.JavaConversions._

trait TMapMetadata extends MapMetadata with TNonNullMetadata


class MapMetadata_(  keyType:String,
                           valueType:String,
                           entries:List[TMapEntry]
) extends TMapMetadata {
  override def getKeyType()=keyType
  override def getValueType()=valueType
  override def getEntries()=entries
}