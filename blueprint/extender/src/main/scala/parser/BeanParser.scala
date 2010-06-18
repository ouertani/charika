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
package parser


import net.dikka.charika.blueprint.extender.impl._
import net.dikka.charika.blueprint.extender.impl.beans.Bean
import net.dikka.charika.blueprint.extender.impl.beans._
import scala.xml.Node


class BeanParser  extends ComponentParser {
 
  override def parseElement( node:Node) ={
     Bean( node \ "@name"  text,
                      activation = node \ "@activation" text,
                      scope = node \ "@scope" text ,
                      node,
                      node,
                      node
    )
   
  
  }


  implicit def toConstructionParam(node:Node):ConstructionParam= {
    ConstructionParam(dependsOn =(node \ "@dependsOn"). text.split (" ").toList, propertys = List(),  arguments = List())
  }
  implicit def toConstruction(node:Node):Construction ={
    Construction( clazz = node \ "@clazz"  ,
                 factoryMethod=  node \ "@factoryMethod" ,
                 factoryRef=  node \ "@factoryRef" )
  }

  implicit def toCallback(node :Node):Callback= {
    Callback(initMethod=  node \ "@initMethod"  ,
             destroyMethod =node \ "@destroyMethod" )
  }

  
}
