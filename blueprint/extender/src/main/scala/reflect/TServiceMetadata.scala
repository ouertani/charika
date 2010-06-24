package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.ServiceMetadata

trait TServiceMetadata extends ServiceMetadata with TComponentMetadata


case class ServiceMetadataImpl(	 getServiceComponent:TTarget,
                               getInterfaces:List[String],
                               autoExport:AutoExport,
                               serviceProperties: List[TMapEntry],ranking: Int,
                               registrationListeners:Seq[TRegistrationListener] ) extends TServiceMetadata