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
import net.dikka.charika.blueprint.extender.impl.beans.Component
import scala.collection._

trait ComponentParser [T] {
  def  parseElement( node:Node):T
}



