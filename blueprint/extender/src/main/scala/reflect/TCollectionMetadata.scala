package net.dikka.charika.blueprint
package reflect
import org.osgi.service.blueprint.reflect._
trait TCollectionMetadata extends CollectionMetadata with TNonNullMetadata

case class CollectionMetadataImpl( collectionClass :Class[_],
                                  valueType:String ,
                                  values:List[TMetadata]) extends TCollectionMetadata