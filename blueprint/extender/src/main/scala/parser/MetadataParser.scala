package net.dikka.charika.blueprint
package parser


import reflect.Constants._
import reflect._
import builder._
import scala.xml.Node

class MetadataParser  extends  Function1[Node,TMetadata] {


  def  apply(node:Node):  TMetadata= {

    val ref = node.attribute(REF_ATTRIBUTE)
    val value = node.attribute(VALUE_ATTRIBUTE)
    val child = node.child





     error("")


    }
}
