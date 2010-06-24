package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.MapEntry

trait TMapEntry extends MapEntry


class MapEntry_( key:TNonNullMetadata,
                value:TMetadata) extends TMapEntry {
  override def getKey()=key
  override  def getValue() =value
}