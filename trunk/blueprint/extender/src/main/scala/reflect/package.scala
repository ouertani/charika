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


package object reflect{

  trait TValidator {
    @throws(classOf[ComponentDefinitionException])
    def validate():Unit
  }
  trait TBuilder[T] {
    @throws(classOf[ComponentDefinitionException])
    def build():T
  }

  trait TBuilderPattern[T] extends TBuilder[T] with TValidator {
    override def build() : T ={
      validate()
      build()
    }
  }
  


  


  implicit def toOptionOfString(string :String):Option[String]= {
    if(string==null || string.isEmpty) None
    else Some(string)
  }


  implicit def toString(node:scala.xml.NodeSeq):Option[String]=node.text

  implicit def toOptionOfInt(string : String):Option[Int]= {
    try {
      if(string == null || string.isEmpty ) None
      else Some( Int.unbox(string))
    }catch {

      case _ => throw new IllegalArgumentException("Inavalid index found [" + string +"]")
    }
  }


//  implicit def toArgument (node : NodeSeq):List[Argument]={
//
//    val h= for (n <- node ) yield Argument (n \ "@index"  text, n \ "@type", None, n \ "@value" , None)
//
//    h toList
//  }


//  implicit def toConstructionParam(node:Node):ConstructionParam= {
//    node \\ "arguments"
//    ConstructionParam(dependsOn = node, propertys = List(),  arguments = node \\ "argument")
//  }

  implicit def toDepends(node : Node):List[String]={
    val n=( node \ "@dependsOn" )
    if( n isDefined){
      n.text.split (" ").toList

    }else  {
      List()
    }
  }

//  implicit def toConstruction(node:Node):Construction ={
//    Construction( clazz = node \ "@class"  ,
//                 factoryMethod=  node \ "@factoryMethod" ,
//                 factoryRef=  node \ "@factoryRef" )
//  }



//
//  implicit def toCallback(node :Node):Callback= {
//    Callback(initMethod=  node \ "@initMethod"  ,
//             destroyMethod =node \ "@destroyMethod" )
//  }

  def xor3(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x && z) && !(y && z) && ! (x && y && z)


  def xor(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)



  implicit def toOption[T](t:T):Option[T]={if(t!=null) Some(t) else None}





  def need(b :Boolean, msg : String) {
    if(!b) throw new ComponentDefinitionException("Unknown element " + msg);
  }


}