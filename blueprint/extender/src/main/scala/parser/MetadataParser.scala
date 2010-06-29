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


trait TMetadataParser {
  val metadataParser:MetadataParser
  
  class MetadataParser  extends  Function1[Node,TMetadata] {


    def  apply(node:Node):  TMetadata= {

//      val ref = node.attribute(REF_ATTRIBUTE)
//      val value = node.attribute(VALUE_ATTRIBUTE)
//      val child = node.child


      error("")


    }
  }
}
