package net.dikka.charika.blueprint
package reflect.impl

trait TPropsMetadata extends PropsMetadata with TNonNullMetadata

case class PropsMetadataImpl( entries:List[TMapEntry]) extends TPropsMetadata