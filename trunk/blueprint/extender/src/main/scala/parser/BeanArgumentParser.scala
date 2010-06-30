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
package parser


import reflect._
import builder._
import scala.xml.Node

trait TBeanArgumentParser { this : TMetadataParser with TBeanArgumentBuilder=>

 
  val beanArgumentParser :BeanArgumentParser
  
  class BeanArgumentParser  extends Function1[Node,TBeanArgument]  {
    implicit def toInt(index:String) :Int={
      if(index ==null ){ -1}
      else {
        try {
          Int.unbox(index)
        }catch {
          case _ => error ("invalid index "+ index)
        }
      }
    }
    override def  apply( node:Node):TBeanArgument = {
      val metadata = metadataParser(node)
      beanArgumentBuilder
      .withValueType(node << TYPE_ATTRIBUTE )
      .withIndex(node << INDEX_ATTRIBUTE )
      .withValue(metadata)    ()
    }
  }
}