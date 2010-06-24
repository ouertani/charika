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



import org.osgi.service.blueprint.container.ComponentDefinitionException
import scala.xml.Node


//class Parser extends TComponentParser [BluePrintContainerTree] {
//  val delegates = Map ("bean" -> new BeanParser ,
//                       "service" -> new ServiceParser,
//                       "reference" -> new ReferenceMetadataParser,
//                       "reference-list" -> new ReferenceListParser)
//  val BLUEPRINT_NAMESPACE = "http://www.osgi.org/xmlns/blueprint/v1.0.0";
//  override def parseElement ( node:Node):BluePrintContainerTree ={
//
//    val bct = new BluePrintContainerTree
//    for(n <- node \ "_") {
//
//      if(BLUEPRINT_NAMESPACE == n.namespace ) {
//        delegates.get(n.label) match {
//          case Some(p) => bct + p.parseElement(n)
//          case None => throw new ComponentDefinitionException (n.label + " is not a valid blueprint element ")
//        }
//      }else {
//        //TODO
//      }
//
//    }
//    bct
//  }

//}