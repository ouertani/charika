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


trait TMetadataParser { this:TDelegateParser with TValueMetadataParser with TRefMetadataBuilder =>
  val metadataParser:MetadataParser= new MetadataParser()
  
  class MetadataParser  extends  Function1[Node,TMetadata] {


    def  apply(node:Node):  TMetadata= {

      println (node)
      val ref = node <<< REF_ATTRIBUTE
      val value = node <<< VALUE_ATTRIBUTE
      val child = node.child \ "_"
      var p:Option[TMetadata]=None
      
      if(child isDefined){
        p =delegateParser (node)
      }
      val b= xor(ref isDefined,value isDefined ,p isDefined)

      if(b) {
        if( ref isDefined) refMetadataBuilder.withcomponentId(node << REF_ATTRIBUTE) ()
        if( value isDefined) valueMetadataParser(node)
       else p get
       
      }else {
        error("MetadataParser Error ---------- TO BE FIXED ---------------\n")
      }
      

    }
  }
}
