package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.IdRefMetadata

trait TIdRefMetadata extends IdRefMetadata with TNonNullMetadata


case class IdRefMetadataImpl(componentId:String) extends TIdRefMetadata