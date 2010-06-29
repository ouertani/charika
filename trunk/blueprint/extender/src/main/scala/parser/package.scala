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


import scala.xml.Node
import scala.xml.NodeSeq
import org.osgi.service.blueprint.container._


package object parser{


  implicit def toOptionOfString(string :String):Option[String]= {
    if(string==null || string.isEmpty) None
    else Some(string)
  }

  implicit def toString(op :Option[String])= op match {
    case Some(x)=>x
    case None =>null
  }

 

  implicit def toString(node:scala.xml.NodeSeq):String=node.text

  implicit def toOptionOfInt(string : String):Option[Int]= {
    try {
      if(string == null || string.isEmpty ) None
      else Some( Int.unbox(string))
    }catch {

      case _ => throw new IllegalArgumentException("Inavalid index found [" + string +"]")
    }
  }





  implicit def toOption[T](t:T):Option[T]={if(t!=null) Some(t) else None}





  def need(b :Boolean, msg : String):Unit={
    if(!b) throw new ComponentDefinitionException("Unknown element " + msg);
   
  }
  def error( msg : String) : Nothing={
   throw new ComponentDefinitionException("Unknown element " + msg);
  }


 
}