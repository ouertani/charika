package net.dikka.charika.blueprint
package parser

import reflect._
import builder._
import scala.xml._
trait TNullMetadataParser {
  val nullMetadataParser:NullMetadataParser=new NullMetadataParser
  class NullMetadataParser  extends Function1[Node,TNullMetadata]  {
    def  apply(node:Node):  TNullMetadata= {
      TNullMetadata.NILL
    }
  }
}
