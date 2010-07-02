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

  
  class MapEntryBuilder  extends Function0[TMapEntry] {

    final protected [this] var  _key:TNonNullMetadata=_
    final protected [this] var  _value:TMetadata=_


    def withTNonNullMetadata(key:TNonNullMetadata)={
      this._key=key
      this
    }
    def withTMetadata(value:TMetadata)={
      this._value=value
      this
    }
    def apply()={
      new MapEntry( _key,
                   _value)
    }
  }

