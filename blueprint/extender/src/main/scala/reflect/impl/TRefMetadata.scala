package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.RefMetadata

trait TRefMetadata extends RefMetadata with TTarget with TNonNullMetadata

case class RefMetadataImpl(componentId:String) extends TRefMetadata
