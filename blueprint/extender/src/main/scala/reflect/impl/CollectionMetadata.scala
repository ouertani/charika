package net.dikka.charika.blueprint
package reflect.impl

import reflect._
import scala.collection.JavaConversions._
class CollectionMetadata( collectionClass :Class[_],
                                 valueType:String ,
                                 values:List[TMetadata]) extends TCollectionMetadata {

  override def getCollectionClass()=collectionClass
  override def getValueType()=valueType
  override def getValues()=values

}