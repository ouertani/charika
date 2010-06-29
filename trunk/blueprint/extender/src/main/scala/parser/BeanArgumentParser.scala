package net.dikka.charika.blueprint
package parser

import builder.BeanArgumentBuilder


import reflect.TBeanArgument
import scala.xml.Node

class BeanArgumentParser  extends Function1[Node,Any]  {
  implicit def toInt(index:String) :Int={
    if(index ==null ){ -1}
    else {
    try {
      Int.unbox(index)
    }catch {
      case _ => error ("invalid index "+ index)
    }
    }
  }
  override def  apply( node:Node):TBeanArgument = {
    val metadata = new MetadataParser()(node)
    new BeanArgumentBuilder()
    .withValueType(node \"@type" text)
    .withIndex(node \"@index" text)
    .withValue(metadata)    ()
  }
}