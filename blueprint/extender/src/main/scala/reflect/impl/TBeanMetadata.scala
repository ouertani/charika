package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.BeanMetadata

trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata


case class BeanMetadataImpl(classNmae:String,
                            initMethod:String ,
                            destroyMethod:String,
                            beanArguments:List[TBeanArgument],
                            beanProperties:List[TBeanProperty],
                            factoryMethod:String,
                            factoryComponent:TTarget,
                            scope:Scope) extends TBeanMetadata {



}