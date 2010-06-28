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
import org.osgi.service.blueprint.reflect.BeanArgument


trait TBeanArgument extends BeanArgument {

  val index : Option[Int]
  val value : TMetadata
  val valueType : Option[String]

}


sealed class BeanArgument_ (val value : TMetadata, val valueType : Option[String],val index : Option[Int]) extends TBeanArgument {
  override def getValue()=value
  override def getValueType()=valueType
  override def getIndex()=index getOrElse (-1)
}



class BeanArgumentBuilder   {
  private [this] var _value : TMetadata=_
  private [this] var _valueType : Option[String]=None
  private [this] var _index : Option[Int]=None


  def withValue(value : TMetadata)={
    this._value=value
    this
  }
  def withValuetype(valueType : String)={
    this._valueType=valueType
    this
  }
  def withIndex(index : Int)={
    this._index=index
    this
  }

 
 def build()={
    new BeanArgument_ (_value, _valueType , _index )
  }
}