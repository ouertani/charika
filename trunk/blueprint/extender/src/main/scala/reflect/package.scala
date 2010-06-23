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


package object reflect {

  trait ComponentParser [T] {
    def  parseElement( node:Node):T
  }
  


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

  implicit def toOptionOfInt(string : String):Option[Int]= {
    try {
      if(string == null || string.isEmpty ) None
      else Some( Int.unbox(string))
    }catch {

      case _ => throw new IllegalArgumentException("Inavalid index found [" + string +"]")
    }
  }


  implicit def toArgument (node : NodeSeq):List[Argument]={

    val h= for (n <- node ) yield Argument (n \ "@index"  text, n \ "@type", None, n \ "@value" , None)

    h toList
  }


  implicit def toConstructionParam(node:Node):ConstructionParam= {
    node \\ "arguments"
    ConstructionParam(dependsOn = node, propertys = List(),  arguments = node \\ "argument")
  }

  implicit def toDepends(node : Node):List[String]={
    val n=( node \ "@dependsOn" )
    if( n isDefined){
      n.text.split (" ").toList

    }else  {
      List()
    }
  }

  implicit def toConstruction(node:Node):Construction ={
    Construction( clazz = node \ "@class"  ,
                 factoryMethod=  node \ "@factoryMethod" ,
                 factoryRef=  node \ "@factoryRef" )
  }




  implicit def toCallback(node :Node):Callback= {
    Callback(initMethod=  node \ "@initMethod"  ,
             destroyMethod =node \ "@destroyMethod" )
  }

  def xor3(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x && z) && !(y && z) && ! (x && y && z)


  def xor(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)



  implicit def toOption[T](t:T):Option[T]={if(t!=null) Some(t) else None}



  implicit def toConstructionParam(cpb:ConstructionParamBuilder)=cpb.build
  implicit def toArgumentBuilder(ab:ArgumentBuilder)=ab.build
  implicit def toCallback(cb :CallbackBuilder)=cb.build
  implicit def toConstruction(cb:ConstructionBuilder)=cb.build
  implicit def toProperty(pb:PropertyBuilder)=pb.build

  def need(b :Boolean, msg : String) {
    if(!b) throw new ComponentDefinitionException("Unknown element " + msg);
  }


}