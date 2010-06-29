package net.dikka.charika.blueprint
package reflect.impl

import reflect._
import scala.collection.JavaConversions._

class MapMetadata(  keyType:String,
                          valueType:String,
                          entries:List[TMapEntry]
) extends TMapMetadata {
  override def getKeyType()=keyType
  override def getValueType()=valueType
  override def getEntries()=entries
}
