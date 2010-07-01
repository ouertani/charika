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
trait TDefaultParser { this : TDefaultBuilder =>

  val defaultParser:DefaultParser= new DefaultParser()
  class DefaultParser extends  Function1[Node,TDefault]{

   override def  apply( node:Node):TDefault = {

     

      defaultBuilder
      .withDefaultActivation(node << DEFAULT_ACTIVATION_ATTRIBUTE)
      .withDefaultAvailability(node << DEFAULT_AVAILABILITY_ATTRIBUTE)
      .withDefaultTimeout(node << DEFAULT_TIMEOUT_ATTRIBUTE) ()
    }
  }
}
