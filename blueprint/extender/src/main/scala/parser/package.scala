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
package net.dikka.charika.blueprint.extender.impl





import net.dikka.charika.blueprint.extender.impl.beans._
import net.dikka.charika.blueprint.extender.impl.beans.Activation


package object parser {

  implicit def toActivation(activation: String): Activation = {
    if(activation ==null ) Eager
    if(activation=="lazy") Lazy
    else if(activation=="eager") Eager
    else if(activation isEmpty) Eager
    else throw new IllegalArgumentException("invalid activation text")
  }
  
  implicit def toScope(scope: String): Scope={
    if(scope== null) Singleton
    if(scope=="singleton")  Singleton
    else if(scope =="prototype") Prototype
    else if (scope isEmpty) Singleton
    else throw new IllegalArgumentException("invalid scope text")
  }

  implicit def toOptionOfString(string :String):Option[String]= {
    if(string==null || string.isEmpty) None
    else Some(string)
  }


  implicit def toString(node:scala.xml.NodeSeq):Option[String]=node.text

  implicit def toOptionInt(string : String):Option[Int]= {
    
   
    try {
      if(string == null || string.isEmpty ) None
      else Some( Int.unbox(string))
    }catch {

      case _ => throw new IllegalArgumentException("Inavalid index found [" + string +"]")
    }


  }
}