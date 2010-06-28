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

import org.osgi.service.blueprint.reflect.MapEntry

trait TMapEntry extends MapEntry


sealed class MapEntry_( key:TNonNullMetadata,
                value:TMetadata) extends TMapEntry {
  override def getKey()=key
  override  def getValue() =value
}


class MapEntryBuilder {
  private [this] var  key:TNonNullMetadata=_
  private [this] var  value:TMetadata=_


  def withTNonNullMetadata(key:TNonNullMetadata)={
    this.key=key
    this
  }
  def withTMetadata(value:TMetadata)={
    this.value=value
    this
  }
}