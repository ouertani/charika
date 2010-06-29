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

import reflect.Constants._
import reflect._
import builder._
import scala.xml.Node

class BeanPropertyParser extends  Function1[Node,TBeanProperty]{
 
    override def  apply( node:Node):TBeanProperty = {
    val metadata = new MetadataParser()(node)
    new BeanPropertyBuilder()
    .withName(node \ NAME_ATTRIBUTE text)
    .withValue(metadata)    ()
  }
}