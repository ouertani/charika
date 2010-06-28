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

import org.osgi.service.blueprint.reflect.MapMetadata
import scala.collection.JavaConversions._

trait TMapMetadata extends MapMetadata with TNonNullMetadata


sealed class MapMetadata_(  keyType:String,
                          valueType:String,
                          entries:List[TMapEntry]
) extends TMapMetadata {
  override def getKeyType()=keyType
  override def getValueType()=valueType
  override def getEntries()=entries
}

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
    new MapMetadata_(_keyType,
                          _valueType,
                          _entries)
  }
}