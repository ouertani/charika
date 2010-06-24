package net.dikka.charika.blueprint
package reflect
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._


trait TCollectionMetadata extends CollectionMetadata with TNonNullMetadata

class CollectionMetadata_( collectionClass :Class[_],
                          valueType:String ,
                          values:List[TMetadata]) extends TCollectionMetadata {

  override def getCollectionClass()=collectionClass
  override def getValueType()=valueType
  override def getValues()=values
}