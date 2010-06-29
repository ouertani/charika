package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._

class CollectionMetadataBuilder {
  private [this] var _collectionClass :Class[_]=_
  private [this] var _valueType:String =_
  private [this] var _values:List[TMetadata]=_



  def withCollectionClass(collectionClass :Class[_]) ={
    this._collectionClass=collectionClass
    this
  }

  def withValueType(valueType:String)={
    this._valueType= valueType
    this
  }
  def withValues( values:List[TMetadata])={
    this._values=values
    this
  }

  def withValue(value: TMetadata)= {
    this._values ::= value
    this
  }

def build()={
    new CollectionMetadata(_collectionClass ,
                                 _valueType,
                                 _values)
  }
}