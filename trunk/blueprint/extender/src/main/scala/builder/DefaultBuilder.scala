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


  
  class DefaultBuilder extends Function0[TDefault]{
    
    private[this] var _defaultActivation:Activation=Eager
    private[this] var _defaultTimeout:Int=300000
    private[this] var _defaultAvailability:Availability = Mandatory


   
    def withDefaultActivation(activation:String)={
   
      activation match {
        case "eager" =>  _defaultActivation=Eager;
        case "lazy" => _defaultActivation= Lazy;
        case "" => _defaultActivation=Eager;
        case null =>_defaultActivation=Eager;
        case e => error ( e +" is invalid defaultActivation text")
      }
     
      this
    
    }

    private def toInt(index:String) : Int={
      if((index ==null) || (index isEmpty) ){_defaultTimeout}
      else {
        try {
          Integer.parseInt(index) 
        }catch {
          case _ => error ("invalid index "+ index)
        }
      }
    }
    def withDefaultTimeout(timeOut:String)={

      _defaultTimeout=toInt(timeOut)
      this
    }
    def withDefaultAvailability(defaultAvailability:String)={
      defaultAvailability match {
        case "mondatory" =>  _defaultAvailability=Mandatory;
        case "Optional" => _defaultAvailability= Optional;
        case "" => _defaultAvailability=Mandatory;
        case null =>_defaultAvailability=Mandatory;
        case e => error ( e +" is invalid defaultAvailability text")
      }
      this
    }
    def apply()={
      Default(_defaultActivation,_defaultTimeout,_defaultAvailability)
    }
  }

