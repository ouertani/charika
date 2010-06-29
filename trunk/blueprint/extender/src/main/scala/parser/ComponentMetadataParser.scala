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

import builder.ComponentMetadataBuilder
import reflect._
import scala.xml.Node


class ComponentMetadataParser extends  Function1[Node,TComponentMetadata] {
 override def  apply( node:Node) :TComponentMetadata = new  ComponentMetadataBuilder()
  .withId(node \ "@id" text)
  .withActivation(node \ "@activation" text)
  .withDependsOns(node \ "@depends-on" text)
  .build



}
