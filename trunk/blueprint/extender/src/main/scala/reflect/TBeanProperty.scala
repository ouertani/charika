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

import org.osgi.service.blueprint.reflect.BeanProperty

trait TBeanProperty extends BeanProperty


class BeanProperty_(name:String ,
                    value : TMetadata ) extends TBeanProperty {

  override def getName()=name
  override def getValue()=value
}


class BeanPropertyBuilder  {
  private [this] var _name:String=_
  private [this] var _value : TMetadata=_



  def withName( name:String)={
    this._name=name
    this
  }
  def withValue(value : TMetadata)={
    this._value=value
    this
  }

def build()={
    new BeanProperty_(_name,
                    _value )
  }
}