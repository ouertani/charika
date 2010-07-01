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


import reflect.TBeanArgument
import reflect.TMetadata
import reflect.impl.BeanArgument



  class BeanArgumentBuilder  extends Function0[TBeanArgument]  {
    
    final private [this] var _value : TMetadata=_
    final private [this] var _valueType : Option[String]=None
    final private [this] var _index : Option[Int]=None


    def withValue(value : TMetadata)={
      this._value=value
      this
    }
    def withValueType(valueType : String)={
      this._valueType=valueType
      this
    }
    private def toInt(index:String) : Option[Int]={
      if((index ==null) || (index isEmpty) ){None}
      else {
        try {
         Some( Integer.parseInt(index) )
        }catch {
          case _ => error ("invalid index "+ index)
        }
      }
    }
    def withIndex(index : String)={
      this._index=toInt(index)
      this
    }

    def apply()={
      new BeanArgument (_value, _valueType , _index )
    }
  }

