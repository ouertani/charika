package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.MapEntry

trait TMapEntry extends MapEntry


case class MapEntryImpl( key:TNonNullMetadata,
                        value:TMetadata) extends TMapEntry