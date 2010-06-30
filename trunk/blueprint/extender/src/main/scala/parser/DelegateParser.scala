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
import reflect._
import builder._
import scala.xml._

trait TDelegateParser {

  val delegateParser:DelegateParser=new DelegateParser()
  val delegates = Map (
    BEAN_ELEMENT  ->BeanMetadataParserComponent.beanMetadataParser ,
    VALUE_ELEMENT -> ValueMetadataParserComponent.valueMetadataParser)
  
  class DelegateParser extends  Function1[NodeSeq,Option[TMetadata]]{
   

    def apply ( node:NodeSeq):Option[TMetadata] ={

      for(n <- node \ "_") {

        if(BLUEPRINT_NAMESPACE == n.namespace ) {
          delegates.get(n.label) match {
            case Some(p) => p (n)
            case None => throw new ComponentDefinitionException (n.label + " is not a valid blueprint element ")
          }
        }else {
          //TODO
          println("TODO DELEAGATE "+ n.label)
          None
        }

      }
      None
    
    }



       



  }
}