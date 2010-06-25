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

trait TBeanArgument extends BeanArgument 


sealed class BeanArgument_ (value : TMetadata, valueType : String, index : Int) extends TBeanArgument {
  override def getValue()=value
  override def 	getValueType()=valueType
  override def	getIndex()=index
}



class BeanArgumentBuilder  {
  private [this] var  value : TMetadata=_
  private [this] var  valueType : String=_
  private [this] var index : Int=_


  def withValue(value : TMetadata)={
    this.value=value
    this
  }
  def withValuetype(valueType : String)={
    this.valueType=valueType
    this
  }
  def withIndex(index : Int)={
    this.index=index
    this
  }

}