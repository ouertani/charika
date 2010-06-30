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


import scala.xml.Node
import scala.xml.NodeSeq
import builder._
import reflect._
import org.osgi.service.blueprint.container._


package object parser{

  val BLUEPRINT_NAMESPACE = "http://www.osgi.org/xmlns/blueprint/v1.0.0";
  val  BLUEPRINT_ELEMENT = "blueprint";
  val  DESCRIPTION_ELEMENT = "description";
  val  TYPE_CONVERTERS_ELEMENT = "type-converters";
  val  BEAN_ELEMENT = "bean";
  val  ARGUMENT_ELEMENT = "argument";
  val  REF_ELEMENT = "ref";
  val  IDREF_ELEMENT = "idref";
  val  LIST_ELEMENT = "list";
  val  SET_ELEMENT = "set";
  val  MAP_ELEMENT = "map";
  val  ARRAY_ELEMENT = "array";
  val  PROPS_ELEMENT = "props";
  val  PROP_ELEMENT = "prop";
  val  PROPERTY_ELEMENT = "property";
  val  NULL_ELEMENT = "null";
  val  VALUE_ELEMENT = "value";
  val  SERVICE_ELEMENT = "service";
  val  REFERENCE_ELEMENT = "reference";
  val  REFERENCE_LIST_ELEMENT = "reference-list";
  val  INTERFACES_ELEMENT = "interfaces";
  val  REFERENCE_LISTENER_ELEMENT = "reference-listener";
  val  SERVICE_PROPERTIES_ELEMENT = "service-properties";
  val  REGISTRATION_LISTENER_ELEMENT = "registration-listener";
  val  ENTRY_ELEMENT = "entry";
  val  KEY_ELEMENT = "key";
  val  DEFAULT_ACTIVATION_ATTRIBUTE = "default-activation";
  val  DEFAULT_TIMEOUT_ATTRIBUTE = "default-timeout";
  val  DEFAULT_AVAILABILITY_ATTRIBUTE = "default-availability";
  val  NAME_ATTRIBUTE = "name";
  val  ID_ATTRIBUTE = "id";
  val  CLASS_ATTRIBUTE = "class";
  val  INDEX_ATTRIBUTE = "index";
  val  TYPE_ATTRIBUTE = "type";
  val  VALUE_ATTRIBUTE = "value";
  val  VALUE_REF_ATTRIBUTE = "value-ref";
  val  KEY_ATTRIBUTE = "key";
  val  KEY_REF_ATTRIBUTE = "key-ref";
  val  REF_ATTRIBUTE = "ref";
  val  COMPONENT_ID_ATTRIBUTE = "component-id";
  val  INTERFACE_ATTRIBUTE = "interface";
  val  DEPENDS_ON_ATTRIBUTE = "depends-on";
  val  AUTO_EXPORT_ATTRIBUTE = "auto-export";
  val  RANKING_ATTRIBUTE = "ranking";
  val  TIMEOUT_ATTRIBUTE = "timeout";
  val  FILTER_ATTRIBUTE = "filter";
  val  COMPONENT_NAME_ATTRIBUTE = "component-name";
  val  AVAILABILITY_ATTRIBUTE = "availability";
  val  REGISTRATION_METHOD_ATTRIBUTE = "registration-method";
  val  UNREGISTRATION_METHOD_ATTRIBUTE = "unregistration-method";
  val  BIND_METHOD_ATTRIBUTE = "bind-method";
  val  UNBIND_METHOD_ATTRIBUTE = "unbind-method";
  val  KEY_TYPE_ATTRIBUTE = "key-type";
  val  VALUE_TYPE_ATTRIBUTE = "value-type";
  val  MEMBER_TYPE_ATTRIBUTE = "member-type";
  val  SCOPE_ATTRIBUTE = "scope";
  val  INIT_METHOD_ATTRIBUTE = "init-method";
  val  DESTROY_METHOD_ATTRIBUTE = "destroy-method";
  val  ACTIVATION_ATTRIBUTE = "activation";
  val  FACTORY_REF_ATTRIBUTE = "factory-ref";
  val  FACTORY_METHOD_ATTRIBUTE = "factory-method";
  val  AUTO_EXPORT_DISABLED = "disabled";
  val  AUTO_EXPORT_INTERFACES = "interfaces";
  val  AUTO_EXPORT_CLASS_HIERARCHY = "class-hierarchy";
  val  AUTO_EXPORT_ALL = "all-classes";

  val  USE_SERVICE_OBJECT = "service-object";
  val  USE_SERVICE_REFERENCE = "service-reference";


  def error( msg : String) : Nothing={
    throw new ComponentDefinitionException("Unknown element " + msg);
  }


  implicit def toRichNode(node:Node):RichNode=new RichNode(node)

  class RichNode (node: Node){

    def <<(att : String) =  node \ ("@"+att) text

    def <<<(att : String) = if(node.attribute(att) isDefined) Some (<< (att)) else None
  }


  trait ComponentMetadataComponent extends TComponentMetadataParser with TComponentMetadataBuilder with TDefault {
    override val componentMetadataBuilder:ComponentMetadataBuilder = new ComponentMetadataBuilder() with TDefault
    override val componentMetadataParser:ComponentMetadataParser = new ComponentMetadataParser()
  }

  trait BeanArgumentParserComponent extends TBeanArgumentParser with TMetadataParser with TValueMetadataParser with TDelegateParser with TBeanArgumentBuilder with TValueMetadataBuilder with TRefMetadataBuilder  {
    override val beanArgumentParser :BeanArgumentParser= new BeanArgumentParser()
    override val beanArgumentBuilder:BeanArgumentBuilder = new BeanArgumentBuilder()
    override val metadataParser:MetadataParser = new MetadataParser()
  }

  trait BeanPropertyComponent extends TBeanPropertyParser with TMetadataParser with TValueMetadataParser  with TDelegateParser with TBeanPropertyBuilder with TValueMetadataBuilder with TRefMetadataBuilder{
    override val beanPropertyParser :BeanPropertyParser= new BeanPropertyParser()
    override val beanPropertyBuilder :BeanPropertyBuilder = new BeanPropertyBuilder()
    override  val metadataParser:MetadataParser = new MetadataParser()
  }



  object BeanMetadataParserComponent extends TBeanMetadataParser                                      
                                        with BeanPropertyComponent
                                        with BeanArgumentParserComponent
                                        with ComponentMetadataComponent
                                        with TBeanMetadataBuilder
                                        with TRefMetadataBuilder{
    override val beanMetadataBuilder:BeanMetadataBuilder = new BeanMetadataBuilder()
    override val refMetadataBuilder:RefMetadataBuilder = new RefMetadataBuilder()
    override val componentMetadataParser:ComponentMetadataParser = new ComponentMetadataParser()
    override val beanMetadataParser :BeanMetadataParser =new BeanMetadataParser()
  }


   def xor(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x && z) && !(y && z) && ! (x && y && z)

}