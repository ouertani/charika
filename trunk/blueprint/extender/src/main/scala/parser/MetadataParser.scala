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
import scala.xml._



class MetadataParser  extends  Function1[ Node,TMetadata] {
//  this: ValueMetadataBuilder with RefMetadataBuilder =>

  def  apply(node:Node):  TMetadata= {
      
    val ref = node <<< REF_ATTRIBUTE
    val value = node <<< VALUE_ATTRIBUTE
    val child = node \ "_"
    var p:Option[TMetadata]=None


    if((child isDefined)  && !( child.isEmpty) ){
     
      val n:Node =child.head
      p =(parsers.get(n label)) get (n)
        
    }
     
    val b = true //TODO TO BE FIXED
    if(b) {
      if( ref isDefined) new RefMetadataBuilder().withcomponentId(node << REF_ATTRIBUTE) ()
      else if( value isDefined) new ValueMetadataBuilder().withStringValue(node << VALUE_ATTRIBUTE).withType(node << TYPE_ATTRIBUTE) ()
      else p get
       
    }else {
      error("MetadataParser Error ---------- TO BE FIXED ---------------\n")
    }
      

  }
}

