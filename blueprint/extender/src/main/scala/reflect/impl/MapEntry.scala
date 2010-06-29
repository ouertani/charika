package net.dikka.charika.blueprint
package reflect.impl
import reflect._
class MapEntry( key:TNonNullMetadata,
                value:TMetadata) extends TMapEntry {
  override def getKey()=key
  override  def getValue() =value
}
