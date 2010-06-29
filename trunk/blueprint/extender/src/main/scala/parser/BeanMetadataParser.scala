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
/*
 *  slim ouertani
 *  
 */

package net.dikka.charika.blueprint
package parser



import reflect.Constants._
import reflect._
import builder._
import scala.xml.Node

class BeanMetadataParser extends  Function1[Node,TBeanMetadata] {

  override def  apply( node:Node):TBeanMetadata = {



    val componentMetadata:TComponentMetadata = new ComponentMetadataParser()(node)
    val refMetadata:TRefMetadata =new RefMetadataBuilder().withcomponentId(node \ "@factory-ref" text) ()

//    val beanArgumentParser:TBeanArgumentParser= new BeanArgumentBuilder()

    new BeanMetadataBuilder().
    withComponentMetadata(componentMetadata)
    .withClassName(node \ "@className" text)
    .withFactoryMethod(node \ "@factory-method" text)
    .withFactoryComponent(refMetadata )
    .withInitMethod(node \ "@init-method" text)
    .withDestroyMethod(node \ "@destroy-method" text)
    .withScope(node \ "@scope" text)
    .withBeanProperties  (parseProperties(node) toList)
    .withBeanArguments (parseArguments(node) toList)     ()




  }

  def parseArguments(node : Node)={
    for( elem <-  node \ ARGUMENT_ELEMENT) yield new BeanArgumentParser() (node)
  }
  def parseProperties(node : Node) = {
    for( elem <-  node \ PROPERTY_ELEMENT) yield new BeanPropertyParser() (node)
  }

}
