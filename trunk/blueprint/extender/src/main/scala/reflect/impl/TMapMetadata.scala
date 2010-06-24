package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.MapMetadata

trait TMapMetadata extends MapMetadata with TNonNullMetadata


case class MapMetadataImpl(  keyType:String,
                           valueType:String,
                           getEntries:List[TMapEntry]


) extends TMapMetadata