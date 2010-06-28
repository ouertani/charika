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

import org.osgi.service.blueprint.reflect.ValueMetadata

trait TValueMetadata  extends ValueMetadata with TNonNullMetadata

sealed class ValueMetadata_( stringValue:String,
                            tipe:String) extends TValueMetadata {
  override def  getStringValue()=stringValue
  override def getType()=tipe
}

class ValueMetadataBuilder extends  TBuilder[TValueMetadata]{
  private [this] var stringValue:String=_
  private [this] var tipe:String=_


  def withStringValue(stringValue:String)={
    this.stringValue=stringValue
    this
  }
  def withType(tipe:String)={
    this.tipe=tipe
    this
  }
override def validate (){}


  override def apply()={
    new ValueMetadata_( stringValue,
                            tipe)
  }

}