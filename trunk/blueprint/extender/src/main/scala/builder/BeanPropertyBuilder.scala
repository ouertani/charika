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


trait TBeanPropertyBuilder {

  val beanPropertyBuilder :BeanPropertyBuilder
  
  class BeanPropertyBuilder  {
    final protected [this] var _name:String=_
    final protected [this] var _value : TMetadata=_



    def withName( name:String)={
      this._name=name
      this
    }
    def withValue(value : TMetadata)={
      this._value=value
      this
    }

    def apply()={
      new BeanProperty(_name,
                       _value )
    }
  }
}