package net.dikka.charika.blueprint
package reflect



import org.osgi.service.blueprint.reflect.PropsMetadata
trait TPropsMetadata extends PropsMetadata with TNonNullMetadata

case class PropsMetadataImpl( entries:List[TMapEntry]) extends TPropsMetadata