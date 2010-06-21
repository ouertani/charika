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

import javax.xml.stream.XMLStreamException
import javax.xml.stream.XMLStreamReader
import scala.xml.Node
import net.dikka.charika.blueprint.extender.impl.beans.BluePrintContainerTree

class Parser extends ComponentParser [BluePrintContainerTree] {
  val delegates = Map ("bean" -> new BeanParser ,
                       "service" -> new ServiceParser,
                       "reference" -> new ReferenceParser,
                       "reference-list" -> new ReferenceListParser)
  val BLUEPRINT_NAMESPACE = "http://www.osgi.org/xmlns/blueprint/v1.0.0";
  override def parseElement ( node:Node):BluePrintContainerTree ={

    val bct = new BluePrintContainerTree
    for(n <- node \ "_") {

      if(BLUEPRINT_NAMESPACE == n.namespace ) {
        delegates.get(n.label) match {
          case Some(p) => bct + p.parseElement(n)
          case None => throw new IllegalArgumentException (n.label + " is not a valid blueprint element ")
        }
      }else {
        //TODO
      }

    }
    bct
  }

}