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
package reflect



import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._




trait TBeanArgument extends BeanArgument {
  val index: Option[Int]
  val tipe:Option[String]
  val ref:TReferenceMetadata
  val value:TValueMetadata
  val component: TComponentMetadata

  override def getIndex()=index.getOrElse(-1)
  override def getValueType()=tipe.getOrElse( null )
//  override def getValue():MetaData = value.getOrElse(ref.getOrElse(component))
}



case class Argument (index: Option[Int], 
                     tipe:Option[String],
                     ref:Option[String] ,
                     value:Option[String] ,
                     component: Option[Component]) extends TBeanArgument {
  need (index!=null, "index must not be null")
  need (tipe!=null, "type must not be null")
  need (ref !=null,"ref must not be null")
  need (value != null,"value must not be null")
  need (component != null,"component must not be null")



 
  /*
   The following attributes and elements are mutually exclusive:
   • ref
   • value
   • An inlined object value
   */
  need (xor3(ref isDefined, value isDefined, component isDefined),""" The following attributes and elements are mutually exclusive:
   • ref
   • value
   • An inlined object value""")
}



