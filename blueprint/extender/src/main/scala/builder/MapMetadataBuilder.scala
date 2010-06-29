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
class MapMetadataBuilder{

  private [this] var _keyType:String=_
  private [this] var _valueType:String=_
  private [this] var _entries:List[TMapEntry]=_


  def withKeyType(keyType:String)={
    this._keyType=keyType
    this
  }
  def withValueType(valueType:String)={
    this._valueType=valueType
    this
  }
  def withEntries(entries:List[TMapEntry])={
    this._entries=entries
    this
  }

  def withEntry(entry:TMapEntry)={
    this._entries::=entry
    this
  }



  def build()={
    new MapMetadata(_keyType,
                          _valueType,
                          _entries)
  }
}
