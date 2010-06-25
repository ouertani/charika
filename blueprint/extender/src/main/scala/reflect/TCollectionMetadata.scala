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

trait CollectionMetadataBuilder extends TBuilderPattern[TCollectionMetadata] {
  private [this] var collectionClass :Class[_]=_
  private [this] var valueType:String =_
  private [this] var values:List[TMetadata]=_



   @throws(classOf[ComponentDefinitionException])
    def validate() {
      
    }


 abstract override def build() : TCollectionMetadata = {
    new CollectionMetadata_(collectionClass,
                                 valueType,
                                 values)
  }
}

