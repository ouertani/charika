/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v. 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint
package reflect
import org.osgi.service.blueprint.container.ComponentDefinitionException
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._


trait TCollectionMetadata extends CollectionMetadata with TNonNullMetadata

sealed class CollectionMetadata_( collectionClass :Class[_],
                                 valueType:String ,
                                 values:List[TMetadata]) extends TCollectionMetadata {

  override def getCollectionClass()=collectionClass
  override def getValueType()=valueType
  override def getValues()=values

}

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
    new CollectionMetadata_(_collectionClass ,
                                 _valueType,
                                 _values)
  }
}

