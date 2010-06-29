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


import reflect._
import builder._
import scala.xml.Node


trait TBeanMetadataParser {
  this : TBeanMetadataBuilder with TRefMetadataBuilder with TBeanArgumentParser with TBeanPropertyParser with  TComponentMetadataParser=>

  val beanMetadataParser :BeanMetadataParser
  
  class BeanMetadataParser extends  Function1[Node,TBeanMetadata] {

    override def  apply( node:Node):TBeanMetadata = {



      val componentMetadata:TComponentMetadata = new ComponentMetadataParser()(node)
      val refMetadata:TRefMetadata =refMetadataBuilder.withcomponentId(node \ FACTORY_REF_ATTRIBUTE text) ()

      beanMetadataBuilder.
      withComponentMetadata(componentMetadata)
      .withClassName(node << CLASS_ATTRIBUTE )
      .withFactoryMethod(node << FACTORY_METHOD_ATTRIBUTE )
      .withFactoryComponent(refMetadata )
      .withInitMethod(node << INIT_METHOD_ATTRIBUTE )
      .withDestroyMethod(node << DESTROY_METHOD_ATTRIBUTE )
      .withScope(node << SCOPE_ATTRIBUTE )
      .withBeanProperties  (parseProperties(node) toList)
      .withBeanArguments (parseArguments(node) toList)     ()




    }

    def parseArguments(node : Node)={
      for( elem <-  node \ ARGUMENT_ELEMENT) yield beanArgumentParser (node)
    }
    def parseProperties(node : Node) = {
      for( elem <-  node \ PROPERTY_ELEMENT) yield beanPropertyParser (node)
    }

  }
}