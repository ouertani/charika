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
package builder

import reflect._
import reflect.impl._


 class CollectionMetadataBuilder extends Function0[TCollectionMetadata]{
    final protected [this] var _collectionClass :Class[_]=_
    final protected [this] var _valueType:String =_
    final protected [this] var _values:List[TMetadata]=_



    def withCollectionClass(collectionClass :Class[_])={
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

    def withValue(value: TMetadata)={
      this._values ::= value
      this
    }

    def apply()={
      new CollectionMetadata(_collectionClass ,
                             _valueType,
                             _values)
    }
  }
