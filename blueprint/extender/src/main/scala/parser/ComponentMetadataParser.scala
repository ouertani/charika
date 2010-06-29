
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
