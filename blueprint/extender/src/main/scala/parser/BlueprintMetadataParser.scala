package net.dikka.charika.blueprint
package parser


import org.osgi.service.blueprint.container.ComponentDefinitionException
import reflect._
import builder._
import scala.xml.Node


class BlueprintMetadataParser extends  Function1[Node,TBlueprintMetadata]{


    override def apply( node:Node):TBlueprintMetadata = {
      val default= new DefaultParser () (node)
      val d=   new BlueprintMetadataBuilder().withDefault(default)


      for(n <- node \ "_") {

        if(BLUEPRINT_NAMESPACE == n.namespace ) {
          parsers.get(n.label) match {
            case Some(p) => d.withMetaData(p (n))
            case None => throw new ComponentDefinitionException (n.label + " is not a valid blueprint element ")
          }
        }else {
          //TODO
          println("TODO DELEAGATE "+ n.label)
          None
        }

      }
      d()
    }

   
    

  }


