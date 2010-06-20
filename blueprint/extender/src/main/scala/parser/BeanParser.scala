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
import scala.xml.NodeSeq


class BeanParser extends ComponentParser [Bean] {
 
  override def parseElement ( node:Node):Bean ={

   
    Bean( node \ "@id"  text,
         activation = node \ "@activation" text,
         scope = node \ "@scope" text ,
         node,
         node,
         node
    )
  }
}

  

