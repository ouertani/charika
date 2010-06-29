package net.dikka.charika.blueprint
package parser

import reflect.Constants._
import reflect._
import builder._
import scala.xml.Node

class BeanPropertyParser extends  Function1[Node,TBeanProperty]{
 
    override def  apply( node:Node):TBeanProperty = {
    val metadata = new MetadataParser()(node)
    new BeanPropertyBuilder()
    .withName(node \ NAME_ATTRIBUTE text)
    .withValue(metadata)    ()
  }
}