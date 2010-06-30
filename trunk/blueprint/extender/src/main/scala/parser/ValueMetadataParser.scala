package net.dikka.charika.blueprint
package parser


import reflect._
import builder._
import scala.xml.Node

trait TValueMetadataParser { this : TValueMetadataBuilder =>
  val valueMetadataParser:ValueMetadataParser = new ValueMetadataParser()

  class ValueMetadataParser  extends Function1[Node,TValueMetadata]  {
    override def  apply( node:Node):TValueMetadata = {
     
      valueMetadataBuilder.withStringValue(node.text).withType(node <<< TYPE_ATTRIBUTE)()
    }
  }
}
